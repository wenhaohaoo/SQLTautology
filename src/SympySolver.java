import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class SympySolver {

    private static HashMap<String, String> hashMap = new HashMap<String, String>();
    private static HashMap<String, String> reversedMap = new HashMap<String, String>();

    public SympySolver() {

    }

    private static String[] preProcess(String expression) {
        final String IMPORT_LIBRARY = "from sympy import *\n";
        final String INIT_SYMBOL = "%1$ssymbols(%2$s)\n";
        final String PRINT_FUNCTION = "print(factor(simplify(%1$s)))\n";
        final String PRINT_ROOTS = "print(roots(factor(simplify(%1$s))))\n";

        ArrayList<String> script = new ArrayList<String>();
        String[] parser = ExpressionHelper.parseSingle(expression);
        StringBuilder convertVarToSymbol = new StringBuilder();
        StringBuilder declareVar = new StringBuilder();
        StringBuilder modifiedExpression = new StringBuilder();
        String var = "x";
        int counter = 1;

        for (int i = 0; i < parser.length; i++) {
            if (ExpressionHelper.isValidVariable(parser[i]) && hashMap.containsKey(parser[i])) {
                modifiedExpression.append(hashMap.get(parser[i]));
            } else if (ExpressionHelper.isValidVariable(parser[i])) {
                hashMap.put(parser[i], var + counter);
                reversedMap.put(var + counter, parser[i]);
                declareVar.append(var + counter + ",");
                convertVarToSymbol.append(var + counter + " ");
                modifiedExpression.append(var + counter++);
            } else {
                modifiedExpression.append(parser[i]);
            }
        }

        script.add(IMPORT_LIBRARY);

        if (declareVar.length() != 0) {
            declareVar.setCharAt(declareVar.length() - 1, '=');
            convertVarToSymbol.setCharAt(convertVarToSymbol.length() - 1, '\'');
            convertVarToSymbol.insert(0, "'");
            script.add(String.format(INIT_SYMBOL, declareVar.toString(), convertVarToSymbol.toString()));
        }

        script.add(String.format(PRINT_FUNCTION, modifiedExpression));
        script.add(String.format(PRINT_ROOTS, modifiedExpression));

        return script.toArray(new String[script.size()]);
    }

    private static ArrayList<String> connectToPython(String[] script) {

        String s = null;
        ArrayList<String> results = new ArrayList<String>();

        try {

            FileWriter fileWriter = new FileWriter(new File("temp.py"));

            for (int i = 0; i < script.length; i++) {
                fileWriter.write(script[i]);
            }
            fileWriter.flush();
            fileWriter.close();

            Process p = Runtime.getRuntime().exec("python temp.py");

            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

            // read the output from the command
            // System.out.println("Here is the standard output of the
            // command:\n");
            while ((s = stdInput.readLine()) != null) {
                results.add(s);
                //				 System.out.println(s);
            }

            // read any errors from the attempted command
            // System.out.println("Here is the standard error of the command (if
            // any):\n");
            while ((s = stdError.readLine()) != null) {
                //				 System.out.println(s);
            }

            p.destroy();

        } catch (IOException e) {
            //			System.out.println("exception happened - here's what I know: ");
            e.printStackTrace();
            System.exit(-1);
        }

        return results;
    }

    private static String postProcess(ArrayList<String> array) {
        //System.out.println(expression);
        String expression = array.get(0);
        System.out.println(expression);
        expression = expression.replace("**", "&");
        String[] components = ExpressionHelper.parseSingle(expression);
        StringBuilder sb = new StringBuilder();
        String lastVar = "";
        for (int i = 0; i < components.length; i++) {
            if (reversedMap.containsKey(components[i])) {
                components[i] = reversedMap.get(components[i]);
                lastVar = components[i];
            } else if (components[i].equals("&")) {
                sb.replace(sb.length() - lastVar.length(), sb.length(), "");
                // sb.substring(0, sb.length()-lastVar.length());
                sb.append("Math.pow(" + lastVar + ", " + components[i + 1] + ")");
                i += 2;
            }
            sb.append(components[i]);
        }
        hashMap.clear();
        reversedMap.clear();
        return sb.toString();
    }

    public static String solve(String expression) {
        String[] sympyString = preProcess(expression);
        ArrayList<String> result = connectToPython(sympyString);
        String results = postProcess(result);
        System.out.println("RESULT: " + results);
        return results;
    }

    public static void main(String[] args) {
        SympySolver ss = new SympySolver();
        solve("5*8+3*x");
    }

}
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
    
    private static String[] preProcess(String expression) {
        final String IMPORT_LIBRARY = "from sympy import *\n";
        final String INIT_SYMBOL = "%1$ssymbols(%2$s)\n";
        final String PRINT_FUNCTION = "print(factor(simplify(%1$s)))\n";
        final String PRINT_ROOTS = "print(roots(factor(simplify(%1$s))))\n";
        final String PRINT_DIFF = "print(diff(factor(simplify(%1$s))))\n";

        ArrayList<String> script = new ArrayList<String>();
        String[] parser = ExpressionHelper.parseSingle(expression, true);
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
        script.add(String.format(PRINT_DIFF, modifiedExpression));

        return script.toArray(new String[script.size()]);
    }

    private static String[] connectToPython(String[] script) {

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
        
        return results.toArray(new String[results.size()]);
    }

    private static String[] postProcess(String[] results) {
    	for (int k = 0; k < results.length; k++) {
	        String expression = results[k];//.replace("**", "&");
	        String[] components = ExpressionHelper.parseSingle(expression, true);
	        StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < components.length; i++) {
	            if (reversedMap.containsKey(components[i])) {
	                components[i] = reversedMap.get(components[i]);
	            }
	            sb.append(components[i]);
	        }
	        expression = sb.toString();
	        results[k] = sb.toString();
    	}
//        components = ExpressionHelper.parseSingle(expression, false);
//        sb = new StringBuilder();
//        String lastVar = components[0];
//        sb.append(components[0]);
//        for (int i = 1; i < components.length; i++) {
//	        if (components[i].equals("&")) {
//	            sb.replace(sb.length() - lastVar.length(), sb.length(), "");
//	            sb.append("Math.pow(" + lastVar + ", " + components[i + 1] + ")");
//	            lastVar = components[i+1];
//	            i += 1;
//	        } else {
//	        	sb.append(components[i]);
//	        }
//        }
        hashMap.clear();
        reversedMap.clear();
        return results;
    }

    public static String[] solve(String expression) {
        String[] sympyString = preProcess(expression);
        String[] result = connectToPython(sympyString);
        String[] results = postProcess(result);
        System.out.println("RESULT: " + results[0]);
        System.out.println("ROOTS: " + results[1]);
        System.out.println("DIFF: " + results[2]);
        return results;
    }

    public static void main(String[] args) {
        SympySolver ss = new SympySolver();
        solve("x*x**2");
    }

}
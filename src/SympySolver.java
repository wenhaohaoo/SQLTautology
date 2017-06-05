import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class SympySolver {

    private static HashMap<String, String> hashMap;

    public SympySolver() {
        hashMap = new HashMap<String, String>();
    }


    private static String[] preProcess(String expression) {
        final String IMPORT_LIBRARY = "from sympy import *\n";
        final String INIT_SYMBOL = "%1$ssymbols(%2$s)\n";
        final String PRINT_FUNCTION = "print(factor(simplify(%1$s)))\n";

        ArrayList<String> script = new ArrayList<String>();
        String[] parser = ExpressionHelper.parseSingle(expression);
        StringBuilder convertVarToSymbol = new StringBuilder();
        StringBuilder declareVar = new StringBuilder();
        String var = "x";
        int counter = 1;

        for(int i=0; i<parser.length; i++) {
            if(ExpressionHelper.isValidVariable(parser[i])) {
                hashMap.put(var + counter, parser[i]);
                declareVar.append(var + counter + ",");
                convertVarToSymbol.append(var + counter + " ");
            }
        }

        declareVar.setCharAt(declareVar.length()-1, '=');
        convertVarToSymbol.setCharAt(convertVarToSymbol.length()-1, '\'');
        convertVarToSymbol.insert(0, "'");

        script.add(IMPORT_LIBRARY);
        script.add(String.format(INIT_SYMBOL, declareVar.toString(), convertVarToSymbol.toString()));
        script.add(String.format(PRINT_FUNCTION, expression));
        for(String s: script) {
            System.out.println(s);
        }
        return script.toArray(new String[script.size()]);
    }

    private static String connectToPython(String[] script) {

        String s = null;
        String result = "";

        try {

            // run the Unix "ps -ef" command
            // using the Runtime exec method:

            FileWriter fileWriter = new FileWriter(new File("temp.py"));

            for (int i = 0; i < script.length; i++) {
                fileWriter.write(script[i]);
            }
            fileWriter.flush();
            fileWriter.close();


            Process p = Runtime.getRuntime().exec("python temp.py");

            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(p.getInputStream()));

            BufferedReader stdError = new BufferedReader(new
                    InputStreamReader(p.getErrorStream()));

            // read the output from the command
            System.out.println("Here is the standard output of the command:\n");
            while ((s = stdInput.readLine()) != null) {
                result = s;
                System.out.println(s);
            }

            // read any errors from the attempted command
            System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }

            p.destroy();

        }
        catch (IOException e) {
            System.out.println("exception happened - here's what I know: ");
            e.printStackTrace();
            System.exit(-1);
        }

        return result;
    }

    private static String postProcess(String expression) {
        return "";
    }

    public static String solve(String expression) {
        String[] sympyString = preProcess(expression);
        String result = connectToPython(new String[10]);
        return postProcess(result);
    }

    public static void main(String[] args) {
        SympySolver sympySolver = new SympySolver();
        solve("x|4");
    }

}
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class SympySolver {

    private HashMap<String, String> hashMap;

    public SympySolver() {
        hashMap = new HashMap<String, String>();
    }

    private String[] preProcess(String expression) {
        ArrayList<String> script = new ArrayList<String>();
        script.add(importLibrary());
        String[] parser = ExpressionHelper.parseSingle(expression);
        StringBuilder convertVarToSymbol = new StringBuilder();
        StringBuilder declareVar = new StringBuilder();
        String var = "x";
        int counter = 1;

        for(int i=0; i<parser.length; i++) {
            if(ExpressionHelper.isValidVariable(parser[i])) {
                hashMap.put(var + Integer.toString(counter), parser[i]);
                declareVar.append(var + Integer.toString(counter) + ",");
                convertVarToSymbol.append(var + Integer.toString(counter++) + " ");
            }
        }
        declareVar.setCharAt(declareVar.length()-1, '=');
        convertVarToSymbol.setCharAt(convertVarToSymbol.length()-1, '\'');
        convertVarToSymbol.insert(0, "'");
        script.add(initSymbol(declareVar.toString(), convertVarToSymbol.toString()));
        script.add(printToConsole(expression));
        for(String s: script) {
            System.out.println(s);
        }
        return script.toArray(new String[script.size()]);
    }

    private String printToConsole(String expression) {
        StringBuilder sb = new StringBuilder();
        sb.append("print(factor(simplify(");
        sb.append(expression);
        sb.append(")))\n");
        return sb.toString();
    }

    private String initSymbol(String declareVar, String symbols) {
        StringBuilder sb = new StringBuilder();
        sb.append(declareVar);
        sb.append("symbols(" + symbols + ")\n");
        //System.out.println(sb.toString());
        return sb.toString();
    }

    private String importLibrary() {
        return "from sympy import *\n";
    }

    private String connectToPython(String[] script) {
        String s = null;
        String result = "";

        try {

            // run the Unix "ps -ef" command
            // using the Runtime exec method:

            FileWriter fileWriter = new FileWriter(new File("temp.py"));

            fileWriter.write("from sympy import *\n");
            fileWriter.write("x = Symbol('x')\n");
            fileWriter.write("print(simplify(x|4))\n");
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

    private String postProcess(String expression) {

    }

    public String solve(String expression) {
        String[] sympyString = this.preProcess(expression);
        String result = connectToPython(sympyString);
        return postProcess(expression);
    }

    public static void main(String[] args) {
        SympySolver sympySolver = new SympySolver();
        sympySolver.solve("x|4");
    }

}
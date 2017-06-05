import java.io.*;
import java.util.HashMap;

public class SympySolver {
	
	private HashMap<String, String> hashMap;
	
	public SympySolver() {
		hashMap = new HashMap<String, String>();
	}
	
	private String[] preProcess(String expression) {
		
	}
	
	private String connectToPython(String[] script) {
        String s = null;
        String result = "";

        try {
            
        	// run the Unix "ps -ef" command
            // using the Runtime exec method:
            
            FileWriter fileWriter = new FileWriter(new File("temp.py"));
            
            fileWriter.write("from symp;y import *\n");
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
		return postProcess(result);
	}

}
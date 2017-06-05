import java.io.*;

public class JavaRunCommand {

    public static void main(String args[]) {

        String s = null;

        try {
            
        	String[] cmd = {"python -V"};
        	// run the Unix "ps -ef" command
            // using the Runtime exec method:
            
            FileWriter fileWriter = new FileWriter(new File("temp.py"));
            
//            fileWrite.write("which python");
            
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
                System.out.println(s);
            }
            
            // read any errors from the attempted command
            System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }
            
            System.exit(0);
        }
        catch (IOException e) {
            System.out.println("exception happened - here's what I know: ");
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
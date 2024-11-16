
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Run {

    public static void main(String[] args) throws IOException {
        Runtime rt = Runtime.getRuntime();
        System.out.println("hi");
        //rt.exec("java -Xmx1024M -Xms1024M -jar server.jar nogui");
        
        Process proc = rt.exec("java -Xmx1024M -Xms1024M -jar server.jar nogui");

        BufferedReader stdInput = new BufferedReader(new 
            InputStreamReader(proc.getInputStream()));

        BufferedReader stdError = new BufferedReader(new 
            InputStreamReader(proc.getErrorStream()));

        // Read the output from the command
        System.out.println("Here is the standard output of the command:\n");
        String s = null;
        while ((s = stdInput.readLine()) != null) {
            System.out.println(s);
        }
        System.out.println("Here is the standard error of the command (if any):\n");
        while ((s = stdError.readLine()) != null) {
            System.out.println(s);
        }

        
    }
    
}
package cmd;

import java.util.Scanner;

/**
 *
 * @author jan.himmel
 */
public class CmdUI {
    public static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        CmdInterface cmd = new CmdEditor();
        
        String line;
        while(cmd.isRunning()){
            System.out.print(cmd.getActualDir() + "$ ");
            line = sc.nextLine();
            try{
                System.out.println(cmd.parseAndExecute(line));
            } catch(RuntimeException e){
                System.out.println(e.getMessage());
            }
        }
    }

}

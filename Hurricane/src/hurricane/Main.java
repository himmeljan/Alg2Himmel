/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hurricane;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Honzik note
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        
        Logic logic = new Logic();
        
        String hurData = "hurricanedata.txt";
        try{
            logic.load(hurData);

            System.out.println("pocatecni rok");
            int beginYear = sc.nextInt();
            System.out.println("konecnz rok");
            int endYear = sc.nextInt();
            System.out.println(logic.showHurricanes(beginYear, endYear));
            System.out.println("napis jmeno hurikanu");
            String name = sc.next();

            System.out.println(logic.getCategory(name));
            System.out.println("zadej file name");
            String fileName = sc.next();
            logic.write(fileName);
            
        }catch(IOException e){
            System.out.println("problem pri nacitani");
        }
    }

   
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package competition;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author Honzik note
 */
public class Main {
public static Scanner sc =new Scanner(System.in);
    
    public static void main(String[] args) {
        Competition c = new Competition();   
        System.out.println("Zadej nazvy vstupnich souboru");
        try{
            while(true){
                try{
                     String startfile  = sc.next();
                     String finishfile = sc.next();
                     c.load(startfile, finishfile);
                     break;
                }catch(FileNotFoundException e){
                     System.out.println("Zadany zly soubor");
                }
            }
            System.out.println(c.getResult());  

            System.out.println("zadej nazev vystupniho souboru");
            String resultFile = sc.next();
            c.saveResult(resultFile);
            System.out.println("data byla ulozena");
    
        }catch (IOException e){
            System.out.println("Chyba pri cteni souboru");
        }catch(NoSuchElementException e){
            System.out.println(e.getMessage());       
        }
    }
}

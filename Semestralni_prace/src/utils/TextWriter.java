/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author jan.himmel
 */
public class TextWriter extends Writer{

    @Override
    public void getOrder(String card, String orderNum) throws IOException {
        String fileName = "Order"+orderNum+".txt";
        PrintWriter pw =null;
        try{
            pw = new PrintWriter(fileName);
        }catch(IOException e){
            
        }
        pw.print("Vase objednavka\n");
        pw.print(card);
        pw.close();

                
    }

    public static void addOrder(String file) throws IOException {
        PrintWriter writer = null;
        
            FileWriter fw = new FileWriter(file, true);
            writer = new PrintWriter(fw);
         
  
        writer.println("ahoj");
        writer.close();
    }
    

    public static void main(String[]args){
        try{
            addOrder("temp");
        }catch(IOException e){
            System.out.println("spatny soubor");
        }    
    }

    
}
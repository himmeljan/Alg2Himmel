/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vareni;

import java.util.Scanner;

/**
 *
 * @author Honzik note
 */
public class Vareni {

    /**
     * @param args the command line arguments
     */
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
       
        System.out.println("Zadej stupnovitost piva");        
        double grade = sc.nextDouble();
        
        System.out.println("Zadej chtenou stupnovitost");
        double grade2 = sc.nextDouble();
        
        System.out.println("Zadej mnozstvi");
        double v1 = sc.nextDouble();
        
        double h1 = ((4*grade)/1000)+1;
        double h2 = ((4*grade2)/1000)+1;
        
        
        double v2 = (h1*v1*grade)/(h2*grade2);
        
        System.out.println(v2-v1);
        
        
                
        
    }
    
}

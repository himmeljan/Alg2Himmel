/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import app.Beer;
import app.Evidence;
import app.Order;
import app.Shop;
import app.Storage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import utils.BeerInterface;
import utils.ComparatorInterface;
import java.util.Scanner;

/**
 *
 * @author Honzik note
 */
public class BeerApp {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Shop s = new Shop();
        System.out.println("jste nakupce ci prodejce n/p");
        try{
            while(true){
                String vote = sc.next();

                if ("p".equals(vote)) {
                    heslo();
                    prodejce(s);
                    break;
                }else if("n".equals(vote)){
                    zakaznik(s);
                    break;
                }else{
                    System.out.println("Zadej znovu");
                }
            }   
        }catch(NoSuchElementException e){
            System.out.println("neplatna volba");
        }catch(IOException e){
            System.out.println("zly subor");    
        }
    }

    public static void zakaznik(Shop s) throws IOException{
        while(true){
            System.out.println("*******Vitej v beershopu*******");
            System.out.println("aktualni nabidka piv ");
            String beerfile  = "beerfile.txt";
            s.load(beerfile);
            
            System.out.println("chcete seradit nabidku podle..");
          
            

            System.out.println("vyhledat");
            System.out.println("objednavka");
            System.out.println("faktura");
            

            //  System.out.println("vypocty");
            System.out.println("ubrat pivo l");
            int choise = sc.nextInt();
            switch (choise) {
                case 1:

            }
        }
    }
    public static void prodejce(Shop s)){
        System.out.println(" mnozstvi na skladu");
        System.out.println("ubrat pivo - litry ");
        System.out.println("pridat pivo litry");
        System.out.println("nove pivo");
        System.out.println("zobrazit objednavky - serazeny podle datumu splatnosti");

    }

    // piva - druhy, porovnavani
    //vzpocty pro vyrobu
    //suroviny
    //recepty 
    //zasoby 
    //objednavky
    public static boolean heslo() {
        String heslo = "kocicak";
        System.out.println("zadejte heslo");
        for (int i = 0; i < 5; i++) {
             
            String fillHeslo = sc.next();
            if (fillHeslo.equals(heslo)) {
                return true;
            } else {
                System.out.println("Spatne heslo, zkuste to znovu");
                System.out.println("zpet? a/n");
                String s = sc.next();
                if("a".equals(s)){
                    return false;
                }
            }
        }
        System.out.println("prilis mnoho pokusu");
        return false;

    }
    public static void loadFile(){
        while(true){
                try{
                     String beerfile  = sc.next();
                     
                     e.load(beerfile);
                     break;
                }catch(FileNotFoundException e){
                     System.out.println("Zadany zly soubor");
                }
        }
    }
}

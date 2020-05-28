/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import app.Beer;
import app.Evidence;
import app.Order;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import utils.BeerInterface;
import utils.ComparatorInterface;

/**
 *
 * @author Honzik note
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
       Beer b1  = new Beer("Euqanot APA","ale",12,12);
       Beer b2  = new Beer("Euqanot APA","ale",12,13);
       b1.addBottles(15);
        System.out.println(b1);
        System.out.println(b2);
      /* Beer b2  = new Beer("Imperial Scout",15.5,7 );
       
       ComparatorInterface c1 = new Beer("Euqanot APA",3,12); 
       ComparatorInterface c2  = new Beer("Imperial Scout",15.5,7); 
       List<ComparatorInterface> beers = new ArrayList<>(); 
       beers.add(c2);
       beers.add(c1);
       Collections.sort(beers, );
       for (ComparatorInterface beer : beers) {
            System.out.println(beer);
        }
        */    
            
        }
       
    }
    
        
    


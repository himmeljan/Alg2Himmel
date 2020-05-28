/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.ArrayList;
import utils.BeerInterface;

/**
 *
 * @author Honzik note
 */
public class Evidence extends Storage {
    
    private ArrayList<Beer> beers;
    private int nAllLitres;
    
    
    public void addBeer(Beer b){
        this.beers.add(b);
    }
    
    //metoda nacte seznam do textoveho dokumentu
    public void loadEvidence(){
        
    }
    
    //metoda vyhledava ze zadaneho stringu
    public void findInList(String name){
      
    }
    
    
}

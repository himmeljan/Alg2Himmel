/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.io.File;
import utils.ComparatorInterface;

/**
 *
 * @author Honzik note
 */
public class Beer implements ComparatorInterface {
    //nektere vlasnosti ubrany pro prehlednost - v pripade potreby odkomentovat
    //private int IBU; //horkost
   // private int EBC;  //barva
    private double ABV;  //procent alkoholu
    private double stupnovitost;
    private String style;
    private String name;
    private int nOfBottles;
    private String popis; 
   // private File recept;
    private double prize;

    public Beer(String name, String style, double stupnovitost, double prize) {
        
        this.ABV = ABV;
        this.stupnovitost = stupnovitost;
        this.style = style;
        this.name = name;
    }

    public int getnOfBottles() {
        return nOfBottles;
    }

    
    
    public void addBottles(int bottles){
        this.nOfBottles = nOfBottles + bottles;
    }
    
    public void takeBottles(int bottles){        
             this.nOfBottles = nOfBottles - bottles;
    }    
    
    public void loadRecipe(){
        
    }

    public boolean isInStorage(int Bottles) {
       return (nOfBottles>Bottles);

    }

    public double getABV() {
        return ABV;
    }
    
   /* @Override
    public int compareTo(Beer b) {
        if(this.ABV < b.getABV()){
            return 1;
        }else{
            return -1;
        }

    }*/

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return   String.format("%-15s%-8s%-8s%-8s%-10s ", name, style,
                stupnovitost + "°", prize + "Kc", getnOfBottles() + " lahvi" );   
    }

    @Override
    public boolean compareByName(Beer b1, Beer b2) {
        if(b1.getName().charAt(0)>b2.getName().charAt(0)){
            return true;
        }else{
            return false;
        }

    }

    @Override
    public boolean compareByAlcohol(Beer b1, Beer b2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ale() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void scout() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void lager() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

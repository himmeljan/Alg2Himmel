/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.io.File;

import compare.ComparingInterface;
import java.util.Comparator;

/**
 *
 * @author jan.himmel
 */
public class Beer implements/* Comparable<Beer>,*/ComparingInterface{
    //nektere vlasnosti ubrany pro prehlednost - v pripade potreby odkomentovat
    //private int IBU; //horkost
   // private int EBC;  //barva
    //private double ABV;  //procent alkoholu
    private double grade;
   // private String style;
    private String name;
    private int nOfBottles;
    
   // private File recept;
    private double prize;

    public Beer(String name, double grade, double prize,int nOfBottles ) {
        
        this.nOfBottles = nOfBottles;
        this.grade = grade;
       
        this.name = name;
        this.prize = prize;
    }

    public double getPrize() {
        return prize;
    }

    public int getnOfBottles() {
        return nOfBottles;
    }
    /**
     * metoda prida nove lahve
     * @param bottles
     */
    public void addBottles(int bottles){
        this.nOfBottles = nOfBottles + bottles;
    }
    /**
     * metoda odebere lahve
     * @param bottles
     */
    public void takeBottles(int bottles){        
             this.nOfBottles = nOfBottles - bottles;
    }    
    
    /**
     * metoda zjistuje jestli je pivo na sklade
     * @param Bottles
     * @return 
     */
    public boolean isInStorage(int Bottles) {
       return (nOfBottles>=Bottles);

    }
   
   /* @Override
    public int compareTo(Beer b) {
        return 1;
    }
*/
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return   String.format("%-12s%-8s%-8s ", name,
                grade+ "°", prize + "Kc ");   
    }

   /* @Override
    public boolean compareByName(Beer b1, Beer b2) {
        if(b1.getName().charAt(0)>b2.getName().charAt(0)){
            return true;
        }else{
            return false;
        }

    }*/

    private double getGrade() {
        return grade;
    }
    /**
     * metoda tridi podle stupnovitosti piva
     * @param o
     * @return 
     */
    @Override
    public boolean isBigger(ComparingInterface o) {
        return (this.grade < ((Beer) o).grade);
       
    }

   

   




}

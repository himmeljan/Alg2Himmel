/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalendar;

import java.util.Scanner;

/**
 *
 * @author Honzik note
 */
public class Kalendar {

    //data
    private int den;
    private int mesic;
    private int rok;
    private final int rozmery = 7;
    private final String []mesice = {"Leden", "Únor", "Březen",
                      "Duben", "Květen", "Červen", 
                      "Červenec", "Srpen", "Zaří", 
                      "Říjen", "Listopad", "Prosinec"};
    private final int [] daycount = {31,unor(),31,30,31,30,31,31,30,31,30,31};
    private final String[] dny ={"pondeli", "utery","streda","ctvrtek","patek","sobota","nedele"};

    //konstruktor
    public Kalendar(int den, int mesic, int rok) {
        this.den = den;
        this.mesic = mesic;
        this.rok = rok;
    }

    public int getDen() {
        return den;
    }

    public String getMesic() {
        return dny[mesic-1];
    }

    public int getRok() {
        return rok;
    }

    public  boolean is_leap() {
        return rok % 4 == 0;
    }
    public int dayCount(){
        int b = 0;
        for(int a : daycount){
            b = b+a;
        }
        return b;
    }

    public int Dayinweek() {

        int k = rok % 100;
        int j = rok / 100;

        if (mesic == 1) {
            mesic = 13;
            k = k - 1;
            if (k < 0) {
                k = k + 100;
                j = j - 1;

            }
        }
        if (mesic == 2) {
            mesic = 14;
            k = k - 1;
            if (k < 0) {
                k = k + 100;
                j = j - 1;

            }
        }
    

        int h = (den + ((13 * (mesic + 1)) / 5) + k + (k / 4) + (j / 4) + 5 * j) % 7;
        int d = (h + 5) % 7 + 1;
        
        return d;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        
        int a =Dayinweek();
        sb.append("Rok:" +rok + " 4%d" + getMesic() +"\n" );
        sb.append("%d2,%d2,%d2,%d2,%d2,%d2,%d2,"+dny);
       int[][]tabulka = new int[5][7];
       
        
        return sb.toString();
    }

    public void nextM(){
        this.den = 1;
        if(this.mesic == 12){
            this.mesic = 1;
            this.rok = rok +1;
        }else{
            this.mesic = mesic +1;
        }
    }
    public void lastM(){
        this.den = 1;
        if(this.mesic == 1){
            this.mesic = 12;
            this.rok = rok -1;
        }else{
            this.mesic = mesic -1;
        }
    }
    public int unor(){
         is_leap();
        int a;
        if (is_leap()== true) {
            return 29;
        } else {
            return 28;
        }
    }
    

     
    
  public static void main(String[] args) {
        Kalendar k = new Kalendar(12,2,3);
        System.out.println(k);
        
    }  
    
}

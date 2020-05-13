/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication19;

/**
 *
 * @author Honzik note
 */
public class Fraction {

    //data
    private double citatel;
    private double jmenovatel;

    public Fraction(double citatel, double jmenovatel) {
        this.citatel = citatel;
        this.jmenovatel = jmenovatel;
    }

    @Override
    public String toString() {
        return citatel+"/"+jmenovatel;
    }

    public double getCitatel() {
        return citatel;
    }

    public double getJmenovatel() {
        return jmenovatel;
    }
    public void pokratit(){
        double r;
        double u = jmenovatel;
        double w = citatel;
        
        while(w!=0){
           r = u%w;        
           u = w;
           w = r;               
        }
        
        this.citatel = citatel/u;
        this.jmenovatel = jmenovatel/u;
                
    }

    public void setCitatel(double citatel) {
        this.citatel = citatel;
    }

    public void setJmenovatel(double jmenovatel) {
        this.jmenovatel = jmenovatel;
    }
    
    public static void main(String[]args){
        Fraction f1 = new Fraction(1,2);
        Fraction f2 = new Fraction(2,6);
        f2.pokratit();

        Fraction f3 = FractionCalculator.sum(f1, f2);
        System.out.println(f3);
        
    }

}

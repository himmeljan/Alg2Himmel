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
public class FractionCalculator {
    
    public static Fraction multiple(Fraction f1, Fraction f2){
        Fraction f3 = new Fraction(1,1);
        f3.setCitatel(f1.getCitatel()*f2.getCitatel());
        f3.setJmenovatel(f1.getJmenovatel()*f2.getJmenovatel());        
        return f3;
    }
    public static Fraction sum(Fraction f1, Fraction f2){
        Fraction f3 = new Fraction(1,1);    
        f3.setJmenovatel(f1.getJmenovatel()*f2.getJmenovatel());   
        f3.setCitatel(f1.getCitatel()*f2.getJmenovatel()+f2.getCitatel()*f1.getJmenovatel());
        f3.pokratit();
        return f3;
    }
    public static Fraction minus(Fraction f1, Fraction f2){
        Fraction f3 = new Fraction(1,1);    
        f3.setJmenovatel(f1.getJmenovatel()*f2.getJmenovatel());   
        f3.setCitatel(f1.getCitatel()*f2.getJmenovatel()-f2.getCitatel()*f1.getJmenovatel());
        f3.pokratit();
        return f3;
    }
    public static Fraction divide(Fraction f1, Fraction f2){
        Fraction f3 = new Fraction(1,1);
        f3.setCitatel(f1.getCitatel()*f2.getJmenovatel());
        f3.setJmenovatel(f1.getJmenovatel()*f2.getCitatel());
        f3.pokratit();
        return f3;
    }
}

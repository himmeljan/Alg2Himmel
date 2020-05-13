/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.util.ArrayList;

/**
 *
 * @author jan.himmel
 */
public abstract class Client {
    
  
    private int n=1;
    private ArrayList<Acount> acounts= new ArrayList<>();

    @Override
    public abstract String toString();
    
   
    
    public Acount  addAcount(double castka){
       
       Acount a1= Acount.AwM(castka);
       acounts.add(a1);
        
      return a1;
    }

    
    public ArrayList<Acount> getAcounts() {
        return acounts;
    }
    
    public double allMoney(){
        double value=0;
        for (Acount acount : acounts) {
            value = value + acount.getMoneyCount();
        }
        return value;
    }
    
    public static void main(String[]args){
       
    }
}

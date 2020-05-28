/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import utils.BeerInterface; 

/**
 *
 * @author Honzik note
 */

public class Order {    
    private List<Beer> card;
    private final LocalDateTime timeOrder;
    private final long nOfDays;
    private final LocalDateTime exDate;
    public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM dd");
   
   
    //nastavi cas objednavky v okamziku jejiho vytvoreni
    public Order(long nOfDays){
        this.nOfDays = nOfDays; 
        
        this.timeOrder =LocalDateTime.now();
        
        this.exDate = timeOrder.plusDays(nOfDays);
    }
    
    //metoda prida kosik
    public void  addToKosik(Beer b, int nBottles){   
        if(b.isInStorage(nBottles)){ 
            this.card.add(b);
            b.takeBottles(nBottles);
        
        }else{
            System.out.println("nedostatek na skladu, na skladu je pouze "+ b.getnOfLitres()+ " lahvi");
        
    }
    }
    //formatuje pocet zadanzch dnu na cas
    
    
    public String  myOrder(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < card.size(); i++){
             sb.append(card.get(i));
        }
        String a = sb.toString();
        return a;
    }

    public LocalDateTime getTimeInOrder() {
        return timeOrder;
    }

    public LocalDateTime getExDate() {
        return exDate;
    }
    
        //metoda vraci jestli je jeste cas na vyriyeni objednvky idealn bz by bylo udelat casovac kolik casu a to je 
    public boolean getTimeToEnd(){
       LocalDateTime a =  LocalDateTime.now();
       return a.isAfter(getExDate());
        
    }
        


    public static void main(String[] args){
        Order o1 = new Order(10);
        System.out.println(o1.getTimeInOrder());
        System.out.println(o1.getExDate());
        o1.getTimeToEnd();
        
    }

   


        
    
    
       
        
}
    
    
    
    
    


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author jan.himmel
 */
public class Order {

    private HashMap<Beer, Integer> card = new HashMap<>();
    private final LocalDateTime timeOrder;
    private int nOfDays;
    private final LocalDateTime exDate;
    public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM dd");

    //nastavi cas objednavky v okamziku jejiho vytvoreni 
    public Order() {

        this.timeOrder = LocalDateTime.now();

        this.exDate = timeOrder.plusDays(nOfDays);
    }

    public LocalDateTime getTimeOrder() {
        return timeOrder;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (Beer beer : card.keySet()) {
            sb.append(i).append(". ");
            sb.append(beer.toString());
            sb.append(card.get(beer));
            sb.append(" lahvi \n");
            i++;
        }
        String a = sb.toString();
        return a;
    }

    public void setnOfDays(int nOfDays) {
        this.nOfDays = nOfDays;
    }

    /**
     * metoda vraci jestli je jeste cas na vyrizeni objednvky
     *
     * @param b vyber co zvolime
     * @param nBottles pocet lahvi
     */
    public String addToCard(Beer b, int nBottles) {
        if (b.isInStorage(nBottles)) {
            if (!isBeerInCard(b)) {
                card.put(b, nBottles);
               
            } else {
                for (Beer beer : card.keySet()) {
                    if (beer == b) {
                        int a = card.get(beer);
                        card.replace(beer, nBottles + a);

                    }
                }
                b.takeBottles(nBottles);
            }
            return "Zbozi pridano do kosiku";
           

        } 
        String mess="nedostatek na skladu, na skladu je pouze " + b.getnOfBottles() + " lahvi";
        return mess;
        
    }
    /**
     * metoda spocita cenu vsech piv v kosiku
     * @return vraci cenu
     */
    public double countPrize(){
        double value=0;
        for (Beer beer : card.keySet()) {
            value  =value + beer.getPrize()*card.get(beer);            
        }
        return value;
    }
    /**
     * metoda odstrani piv z kosiku
     * @param away 
     */
    public void remove(int away) {
        int i = 1;
        for (Beer beer : card.keySet()) {
            if (i == away) {
                card.remove(beer);
            }
            i++;

        }

    }

    public HashMap<Beer, Integer> getCard() {
        return card;
    }

    public LocalDateTime getTimeInOrder() {
        return timeOrder;
    }

    public LocalDateTime getExDate() {
        return exDate;
    }

    /**
     * metoda vraci jestli je jeste cas na vyrizeni objednvky
     *
     * @return metoda vraci true nebo false
     */
    public boolean getTimeToEnd() {
        LocalDateTime a = LocalDateTime.now();
        return a.isAfter(getExDate());

    }


    /*
    public static void main(String[] args){
        Order o = new Order();
        Beer[] br = DataSource.beer;
        for (int i = 0; i < br.length; i++) {
             o.addToCard(br[i], i+2);
            
        }
        System.out.println(o);
        
    }
     */
    /**
     * metoda se pta jestli je pivo uz v kosiku
     * @param b pivo
     * @return true -je/false - neni
     */
    private boolean isBeerInCard(Beer b) {
        for (Beer card1 : card.keySet()) {
            if (card1 == b) {
                return true;
            }
        }
        return false;
    }

}

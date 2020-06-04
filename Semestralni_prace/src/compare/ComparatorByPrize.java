/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compare;


import app.Beer;
import java.util.Comparator;

/**
 *
 * @author jan.himmel
 */
public class ComparatorByPrize implements Comparator<Beer> {

    @Override
    public int compare(Beer o1, Beer o2) {
        if(((Beer)o1).getPrize() > ((Beer)o2).getPrize()){
            return 1;
        }else{
            return -1;
        }
    }
    
}

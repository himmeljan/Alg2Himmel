/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.ArrayList;
import java.util.List;
import utils.BeerInterface;

/**
 *
 * @author Honzik note
 */
public class Orders {
    private List<Order> orders;
 
    public void addOrder(Order o) {
        this.orders.add(o);
    }
    
    
}

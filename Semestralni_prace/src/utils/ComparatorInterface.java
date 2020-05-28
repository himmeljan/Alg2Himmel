/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import app.Beer;

/**
 *
 * @author Honzik note
 */
public interface ComparatorInterface {
    
    boolean compareByName(Beer b1, Beer b2 );
    
    boolean compareByAlcohol(Beer b1, Beer b2);
    
    void ale();
    
    void scout();
    
    void lager();
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import app.Beer;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author jan.himmel
 */
public abstract class Writer {
     public abstract void getOrder(String card, String orderNum) throws IOException;
        
     //public abstract void addOrder(String file);
}

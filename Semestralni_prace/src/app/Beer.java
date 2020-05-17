/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author Honzik note
 */
public class Beer {
    
    private int IBU;
    private int EBC;
    private double ABV;
    private double stupnovitost;
    private String style;
    private String name;

    public Beer(int IBU, int EBC, double ABV, double stupnovitost, String style, String name) {
        this.IBU = IBU;
        this.EBC = EBC;
        this.ABV = ABV;
        this.stupnovitost = stupnovitost;
        this.style = style;
        this.name = name;
    }
    
    
    
}

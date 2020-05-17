/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

/**
 *
 * @author jan.himmel
 */
public abstract class Shape {

    //data
    protected String name = "Geometric object";

    public abstract double computeArea();

    public String getShapeName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return name + ": " + getShapeName();

    }

    public abstract boolean isBigger();

   
    public abstract boolean compareto(Shape s, Shape i);
            
    

}

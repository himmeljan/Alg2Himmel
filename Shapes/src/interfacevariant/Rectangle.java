/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacevariant;


/**
 *
 * @author jan.himmel
 */
public class Rectangle implements Shapeinterface  {
   private double a;
   private double b;
   private double area; //vypocitana

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
        this.area = area();
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }
    private double area(){
       return a*b;
    }

 /*   public double getArea() {
        return area;
    }*/
   @Override
    public double computeArea(){
        return area;
    }

    @Override
    public String toString() {
       // return "Rectangle{" + "a=" + a + ", b=" + b + '}';
     return super.toString() +String.format(" r= .2f%,= .2f% ", a,b);
    }

    @Override
    public boolean isBigger(Shapeinterface o) {
        return (this.area>o.computeArea());
    }
   
   
}

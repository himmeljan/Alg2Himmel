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
public class Rectangle extends Shape  {
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
     return super.toString() +String.format(" S = %.2f", area );
    }

    

    @Override
    public boolean isBigger() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean compareto(Shape s, Shape i) {
        return s.computeArea() < i.computeArea();

    }
   
   
}

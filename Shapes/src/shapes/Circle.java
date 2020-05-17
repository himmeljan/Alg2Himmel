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
public class Circle extends Shape { //typove kompatibilni s shape
    //data
    private double r;
   
    
    
   // public Circle(double r){
        private Circle(double r){
        this.r  =r;       
    }
   /* public Circle(double d){
        this.r  = d/2.0;       
    }*/
    //tovarni metoda - factory metod
    
    public static Circle getIstanceD(double d){
        return new Circle(d/2);
    }
    
    public static Circle getInstanceR(double r){
        return new Circle(r);
    }

    public double getR() {
        return r;
    }

    @Override
    public String toString() {
       // return "Circle{" + "r=" + r + '}';
       return super.toString() +String.format(" S = %.2f", computeArea());
    }
    
    @Override
    public double computeArea(){
        return Math.PI*r*r;
    }
    
    public static void main(String[] args){
        Circle c1 = Circle.getInstanceR(3);
        System.out.println(c1.name);
        System.out.println(c1.getShapeName());
        System.out.println(c1.computeArea());
        System.out.println(c1);
        
    }

    @Override
    public boolean isBigger() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean compareto(Shape s, Shape i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

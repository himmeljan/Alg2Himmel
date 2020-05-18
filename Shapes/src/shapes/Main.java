/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

import java.util.ArrayList;

/**
 *
 * @author jan.himmel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Circle c1 = Circle.getIstanceD(8);
        Rectangle r1 = new Rectangle(2,3);
        Circle c2 = Circle.getInstanceR(2.6);
        
        System.out.println("1. varianta");
        double allArea1 = c1.computeArea() + r1.computeArea() +c2.computeArea();
        System.out.println(allArea1);
        
        System.out.println("2. varianta");
        ArrayList shapes2 = new ArrayList(); // dynamicke pole objektov typu object
        shapes2.add(c1);
        shapes2.add(r1);
        shapes2.add(Circle.getInstanceR(2.6));
        
        double allArea2 =0;
        for (int i=0;i<shapes2.size();i++){
            if(shapes2.get(i) instanceof Circle){
            allArea2 += ((Circle)shapes2.get(i)).computeArea();
            }else if (shapes2.get(i) instanceof Rectangle){
            allArea2 += ((Rectangle)shapes2.get(i)).computeArea();
        }
    }
        System.out.println(allArea2);
        
        System.out.println("3. varianta");
        ArrayList<Shape> shapes3= new ArrayList<>();
        shapes3.add(c1);
        shapes3.add(r1);
        shapes3.add(Circle.getInstanceR(2.6));
        
        //muze osahovat cokoli, co je typov kompatabilni s shape
        double allArea3=0;
        for(Shape shape : shapes3){//for each
        allArea3+= shape.computeArea(); //polzmorfismus
        
    }
        System.out.println(allArea3);
        Shape[] a= new Shape[3];
        
  
        sort(shapes3);
        print(shapes3);
    }
    
    public static ArrayList sort(ArrayList<Shape> a ){
        
        
        for(int i =0; i<a.size();i++){
            for(int j = 1; j<a.size();j++){
                if(a.get(j-1).computeArea() > a.get(j).computeArea()){
                    Shape temp = a.get(j);
                    Shape temp2 = a.get(j-1);                   
                    a.set(j, temp2);
                    a.set(j-1,temp);                    
                    
                }
            }
        }
        return a;
    }
    public static void print(ArrayList<Shape>q){
        for (Shape q1 : q) {
            System.out.println(q1);
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacevariant;


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
        ArrayList<Shapeinterface> shapes3= new ArrayList<>();
        shapes3.add(c1);
        shapes3.add(r1);
        shapes3.add(Circle.getInstanceR(2.6));
        
        //muze osahovat cokoli, co je typov kompatabilni s shapeinterface
        double allArea3=0;
        for(Shapeinterface shape : shapes3){//for each
        allArea3+= shape.computeArea(); //polzmorfismus
        
    }
        System.out.println(allArea3);
    }
    public static void sortByNumber(ArrayList<Shapeinterface> shapes){
        for (int i = 0; i < shapes.length-1; i++) {
            for (int j = 1; j < shapes.length-i; j++) {
                if(array[j-1].isBigger(array[j])){
                    Student temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
    }
}

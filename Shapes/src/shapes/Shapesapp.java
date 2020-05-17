package shapes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import interfacevariant.Shapeinterface;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jan.himmel
 */
public class Shapesapp {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Shape> shapes = new ArrayList<>();

        boolean menu = true;
        while (menu) {

            System.out.println("1. přidej kruh");
            System.out.println("2. přidej obdelník");
            System.out.println("3. přidej čtverec");
            System.out.println("4. vypis obsah všech");
            System.out.println("5. vypis všechny objekty");
            System.out.println("6. serad objekty podle plochy");
            System.out.println("0. konec");

            int choise = sc.nextInt();
            switch (choise) {
                case 1:
                    System.out.println("prumer");
                    double d = sc.nextDouble();
                    Circle c1 = Circle.getIstanceD(d);
                    shapes.add( c1);
                    break;
                case 2:
                    System.out.println("delku a sirku");
                    double a = sc.nextDouble();
                    double b = sc.nextDouble();
                    Rectangle r1 = new Rectangle(a, b);
                    shapes.add(r1);
                    break;

                case 3:
                    System.out.println("delku");
                    double c = sc.nextDouble();
                    Square s1 = new Square(c);
                    shapes.add(s1);
                    break;

                case 4:
                    double allArea3 = 0;
                    for (Shape shape : shapes) {//for each
                        allArea3 += shape.computeArea(); //polzmorfismus
                    }
                    break;

                case 5:
                    for (int i = 0; i < shapes.size(); i++) {//for each
                        System.out.println(shapes.get(i));
                    }
                    break;
                case 6:
                    
                case 0:
                    menu = false;
                default:
                    System.out.println("neplatna varianta");
            }
        }
    }
}

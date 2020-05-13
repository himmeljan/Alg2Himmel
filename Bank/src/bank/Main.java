/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;
import java.util.ArrayList;
/**
 *
 * @author jan.himmel
 */
public class Main {
    
    public static void main(String[]args){
        
        Person p1 = new Person("Pekar");
        Person p2 = new Person("Svecova");
        Company c1 = new Company("Skoda");
        Acount ac1 =p1.addAcount(500);
        Acount ac2 = p1.addAcount(1000);
        Acount ac3 = p2.addAcount(1200);
        Acount ac4 = c1.addAcount(120);
        System.out.println(p1 +" má "+p1.allMoney()+ " penez");
        System.out.println(p2 +" má "+p2.allMoney()+ " penez");
        System.out.println(c1 +" má "+c1.allMoney()+ " penez");
       // System.out.println(a);
      ArrayList<Client> l1= new ArrayList<>();
       l1.add(p1);
       l1.add(p2);
       l1.add(c1);
       
      
       // System.out.println(l1.get(0));
        
    }

   
    
}

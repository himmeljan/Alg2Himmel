/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparingstudents;

/**
 *
 * @author Honzik note
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Student s1 = new Student("jan","Himmel",1912);
        Student s2 = new Student("petr","Bidak",1913);   
        System.out.println(s1.sortName(s2));
        Student[] array = Datasource.loadDataAsArray();
        
    }
    
}

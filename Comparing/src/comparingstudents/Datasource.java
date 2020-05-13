/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparingstudents;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Honzik note
 */
public class Datasource {
    private static Student[] data ={
        new Student("Alice", "Mala", 345),
        new Student("Bob", "Velky", 123),
        new Student("Cyril", "Stredny", 567),
    };
    
    public static Student[] loadDataAsArray(){
        return Arrays.copyOf(data, data.length);
    }
    public static List<Student> loadDalaAsList(){
       return Arrays.asList(data);
    }
}

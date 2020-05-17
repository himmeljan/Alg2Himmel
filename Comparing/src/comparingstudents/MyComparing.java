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
public class MyComparing {
    
    public static void main(String[] args) {
        Student[] students = Datasource.loadDataAsArray();
        print(students);
    }
    
    public static sort(Students[] array){
        for(int i=0;i<array.length-1;i++){
             for(int j=1;j<array.length-i;j++){
            if(array[j-1].isBigger(array)){
        }
    }
    
    
    public static void print(Object[] array){
        for(Object object : array){
            System.out.println(object);
        }
    }
}

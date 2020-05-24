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
       
        Student[] array = Datasource.loadDataAsArray();
        print(array);
        Student []s = sortName(array);
        System.out.println("*******");
        print(s);
        
        
    }
    public static Student[] sortName(Student[] student){
        
        for(int i =0; i< student.length;i++){
            for(int j=1;j<student.length;j++){
                  if(student[j-1].isBigger(student[j])){
                    Student temp  = student[j];
                    student[j] = student[j-1] ;
                    student[j-1] = temp;
                }
            }
        }
        return student;
    }
    public static void print(Student[]a){
        for (Student a1 : a) {
            System.out.println(a1);
        }
    }
}

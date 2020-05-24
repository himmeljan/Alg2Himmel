/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparingstudents;

/**
 *
 * @author jsn.himmel
 */
public class Student implements CompareInterface{
    
    private String firstName;
    private String lastName;
    private int studentNumber;
    private double prumer;
    private double marks[];

 
    public Student(String firstName, String lastName, int studentNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;       
    }
    public String getLastName(){
        return this.lastName;
    }

    public void setMarks(double[] marks) {
        this.marks = marks;
    }
    
   public void prumer(){
       double temp=0;
       for(double m1 : marks){
           temp = temp +m1;
       }
       this.prumer = temp/marks.length;
   }
    
    public void addMark(double mark){
        double[]m = new double[marks.length+1];
        
        System.arraycopy(marks, 0, m, 0, m.length-1);
        m[m.length-1]=mark;
        this.marks = m;
    }
           
        
    
    
    @Override
    public String toString() {
        return String.format("%10s%10s%10d", firstName , lastName ,studentNumber);
    }
    
    
    public static void main(String[]args){
        Student s1 = new Student("jan","Himmel",1912);
        Student s2 = new Student("petr","Zidak",1913);   
        System.out.println(s1.isBigger(s2));
    }

    @Override
    public boolean isBigger(CompareInterface o) {
      return ((Student)o).lastName.charAt(0) < this.lastName.charAt(0);
    }
}

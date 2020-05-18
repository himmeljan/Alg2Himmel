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
        return String.format("%10s%10s%10d%10d", firstName , lastName ,studentNumber, prumer);
    }
    
    public boolean sortName(Student student){
        String abeceda = "abcdefghijklmnopqrstuvwxyz";
        char s2 = student.lastName.charAt(0);
        char s1 = lastName.charAt(0);
        
        System.out.println(s1+" "+s2);
        if (abeceda.indexOf(s1)<abeceda.indexOf(s2)){
            return true;
        }else{
            return false;
        }
       
    }
    public static void main(String[]args){
        Student s1 = new Student("jan","Himmel",1912);
        Student s2 = new Student("petr","Bidak",1913);   
        System.out.println(s1.sortName(s2));
    }
}

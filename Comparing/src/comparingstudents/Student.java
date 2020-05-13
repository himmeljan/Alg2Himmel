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
public class Student {
    
    private String firstName;
    private String lastName;
    private int studentNumber;

    public Student(String firstName, String lastName, int studentumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber =studentumber;
    }

    @Override
    public String toString() {
        return String.format("%10s%10s%10d", firstName , lastName ,studentNumber );
    }
    
    public boolean isBigger(Student student){
}

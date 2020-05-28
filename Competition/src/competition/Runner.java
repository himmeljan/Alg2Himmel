/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package competition;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Honzik note
 */
class Runner implements Comparable<Runner> {

    private int number;
    private String firstName;
    private String lastName;
    private LocalTime startTime;
    private LocalTime finishTime;
    
    public static DateTimeFormatter dtfstart = DateTimeFormatter.ofPattern("HH:mm:ss");
    public static DateTimeFormatter dtffinish = DateTimeFormatter.ofPattern("HH:mm:ss:SSS");

    public Runner(int number, String firstName, String lastName) {
        this.number = number;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return String.format("%-5d %-10s%-10s%-15s%-15s%-15s", number, firstName, lastName,getStartTimeString(),
                getFinishTimeString(),runningTime().format(dtffinish)  );
        
    }
    

    public void setStartTime(String startTime) {
        this.startTime = LocalTime.parse(startTime, dtfstart);
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = LocalTime.parse(finishTime, dtffinish);
    }

    public LocalTime getStartTime() {
        return startTime;
    }
    
    public LocalTime runningTime(){
        return LocalTime.ofNanoOfDay( finishTime.toNanoOfDay() - startTime.toNanoOfDay());
    }
    
    public String getStartTimeString(){
        return startTime.format(dtfstart);
    }
    public String getFinishTimeString(){
        return finishTime.format(dtffinish);
    }

    public LocalTime getFinishTime() {
        return finishTime;
    }
    public static void main(String[]args){
        Runner r = new Runner(101,"Alice","Mala");
        r.setStartTime("09:00:00");
        r.setFinishTime("09:32:01:000");
        System.out.println(r);
    }
    

    

    @Override
    public int compareTo(Runner o) {
        return this.runningTime().compareTo( o.runningTime());
    }
    
}

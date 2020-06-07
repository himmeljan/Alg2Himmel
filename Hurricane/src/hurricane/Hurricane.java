/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hurricane;

/**
 *
 * @author Honzik note
 */
public class Hurricane implements Comparable {

    private int year;
    private String mounth;
    private int pressure;
    private int speed;
    private String name;

    public Hurricane(int year, String mounth, int pressure, int speed, String name) {
        this.year = year;
        this.mounth = mounth;
        this.pressure = pressure;
        this.speed = speed;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Hurricane "+ name+" rok: "+ year + ", mesic: " + mounth + ", tlak: " + pressure + ", rychlost: " + speed;
    }

    public int getYear() {
        return year;
    }

    public String getMounth() {
        return mounth;
    }

    public int getPressure() {
        return pressure;
    }

    public int getSpeed() {
        return speed;
    }
    public double getSpeedKm(){
        double speedKm;
        return speedKm = speed*1.852;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Object o) {
        return this.speed - ((Hurricane)o).speed;
    }
    
    
}

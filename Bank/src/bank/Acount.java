/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

/**
 *
 * @author jan.himmel
 */
public class Acount {

    private double moneyCount;

    private Acount(double moneyCount) {
        this.moneyCount = moneyCount;
    }
    public static Acount emptyA(){
        return new Acount(0);
    }
    public static Acount AwM(double money){ // Awm = acount with money
        return new Acount(money);
    }

    public double getMoneyCount() {
        return moneyCount;
    }

    @Override
    public String toString() {
        return "zůstatek je: " + moneyCount;
    }

    public double pridat(double money) {
        return this.moneyCount = moneyCount + money;
    }

    public double vybrat(double money) {
        if (moneyCount >= money) {
            return this.moneyCount = moneyCount - money;
        } else {
            System.out.println("nedostatečný zůstatek");
            return this.moneyCount;
        }
    }
}

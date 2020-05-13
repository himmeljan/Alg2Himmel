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
public class Company extends Client {
    
    private String name;
    
    public Company(String name) {
      
        this.name = name;
    }

    @Override
    public String toString() {
        return  "firma " + name ;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Honzik note
 */
public class Shop {

    private ArrayList<Beer> beers;
    private HashMap<Order, String> orders;

    public void load(String beerfile) throws FileNotFoundException, IOException {
        //nacitani scanner
        File startFile = new File(beerfile);
        try (Scanner sc = new Scanner(beerfile)) {
            while (sc.hasNext()) {
                String name = sc.next();
                String style = sc.next();
                double stupen = sc.nextDouble();
                double prizePerBottle = sc.nextDouble();
                
                Beer b = new Beer(name,style, stupen, prizePerBottle);
                r.setStartTime(startTime);
                beers.add(b);
                
            }
        }
    }

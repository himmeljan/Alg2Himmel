/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hurricane;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Honzik note
 */
public class Logic {
    public static File dataDirectory = new File(System.getProperty("user.dir") + File.separator + "data");
    private ArrayList<Hurricane> hurricanes =new ArrayList<Hurricane>();

    void load(String hurData) throws FileNotFoundException {
        File file = new File(dataDirectory, hurData);
      
        try(Scanner sc = new Scanner(file)){
            while(sc.hasNext()){
                int year = sc.nextInt();

                String mounth = sc.next();
                int pressure = sc.nextInt();
                int speed = sc.nextInt();
                String name = sc.next();
                
                Hurricane hurricane= new Hurricane(year,mounth,pressure,speed,name);
              
                
                hurricanes.add(hurricane);
            }
        }
        

    }
    void write(String fileName) throws FileNotFoundException, UnsupportedEncodingException, IOException{      
        Collections.sort(hurricanes);
        
        File file = new File(dataDirectory, fileName);
        FileWriter fileWrite = new FileWriter(file,true);
        try(PrintWriter pw = new PrintWriter(fileWrite)){
            for (Hurricane hurricane : hurricanes) {
                pw.println(hurricane);
                pw.print("+");
                
            }
       //   pw.close();
        }
        
            
    }
 

    String showHurricanes(int beginYear, int endYear) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < hurricanes.size(); i++) {
            if(hurricanes.get(i).getYear()>= beginYear && hurricanes.get(i).getYear()<= endYear){
                sb.append(hurricanes.get(i)).append("\n");
            }
        }
        String h = sb.toString();
        return h;
    }

    int getCategory(String name) {
        
        for (Hurricane hurricane : hurricanes) {
            if(hurricane.getName().equals(name)){
                
                double speed = hurricane.getSpeedKm();
                if(speed>119 && speed<=153){
                    return 1;
                }else if(speed>153 && speed<=177){
                    return 2;
                }else if(speed>177 && speed<=208){
                    return 3;
                }else if(speed>208 && speed<=251){
                    return 4;
                }else if(speed>251){
                    return 5;
                }
                        
            }           
                
        }
        return 0;
    }

    
    
    
}

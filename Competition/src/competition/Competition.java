/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package competition;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Scanner;
/**
 *
 * @author Honzik note
 */
public class Competition {
    
    private ArrayList<Runner>runners = new ArrayList<>();
    
    public String getResult() {
        Collections.sort(runners);
        StringBuilder sb = new StringBuilder("");
        int n = 1;
        for (Runner runner : runners) {
            sb.append(String.format("%-2d. %s%n", n, runner));
            n++;
        }
        return sb.toString();
    }

    
    public void load(String startFilepath, String finishFilepath) throws FileNotFoundException, IOException {
        //nacitani scanner
        File startFile = new File(startFilepath);
        try(Scanner inStart = new Scanner(startFile)){ 
            while(inStart.hasNext()){
                int num = inStart.nextInt();
                String firstname = inStart.next();
                String lastname = inStart.next();
                String startTime = inStart.next();
                Runner r = new Runner(num,firstname,lastname);
                r.setStartTime(startTime);
                runners.add(r);
            }
        }
        //nacitani bufferReder 
        File finishFile = new File(finishFilepath);
        try(BufferedReader inFinish = new BufferedReader(new FileReader(finishFile))){
        
        String line;
        while(( (line = inFinish.readLine()) != null) ){ //102 10.0.0.
             String[] parts = line.split("[ ]+");
             try{
                Runner r = findRunner(Integer.parseInt(parts[0]));
                r.setFinishTime(parts[1]);
             }catch(NoSuchElementException e){
                 System.err.print(e.getMessage());
             }
            }
        }
    }
    
    private Runner findRunner(int number){
        for(Runner runner : runners){
            if(runner.getNumber() == number){
                return runner;
            }
        }
        throw new NoSuchElementException("Takovy bezec s cislem" + number + " neexistuje");
    }
    public void saveResult(String resultFilepath) throws IOException{
        System.out.println("454");
        Collections.sort(runners);
        Writer w = null;
        if(resultFilepath.endsWith(".txt")){
            System.out.println("jsem tut");
            w = new TextWriter();
            
        }else if(resultFilepath.endsWith(".dat")){
            //w = new BinaryWriter();
        }else{
            throw new IllegalArgumentException("nepodporovana pripona souboru");
        }
        w.saveResult(resultFilepath,runners);
    }
}

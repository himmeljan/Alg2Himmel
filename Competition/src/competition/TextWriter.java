/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package competition;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author Honzik note
 */
public class TextWriter extends Writer  {

    /**
     *
     * @param resultFilepath
     * @param runners
     * @throws IOException
     */
    @Override
    public void saveResult(String resultFilepath, List<Runner> runners)throws IOException {
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(resultFilepath)))) {
            pw.println("Nove vysledy");
            int n= 1;
            for (Runner runner : runners) {
                pw.print(n+". ");
                pw.println(runner);
                n++;
            }
        }
    }
    
}

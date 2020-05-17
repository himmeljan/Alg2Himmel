/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package competition;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Honzik note
 */
public class BinaryWriter extends Writter {
    public void saveResuls(String resultFilepath, List<Runner> runners) throws IOException{
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(resultFilepath))){
            dos.writeUTF("Nove vysledky");
            int n = 1;
            for(Runner runner : runners){
                dos.writeInt(n);
                dos.writeChar('.');
            }
        }
    }
    
}

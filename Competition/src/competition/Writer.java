/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package competition;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author Honzik note
 */
public abstract class Writer {
    
    public abstract void  saveResult(String resultFilepath, List<Runner> runners) throws IOException;
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.lu.scriptlog;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author johanf
 */
interface ScriptLogLogger {
  
    String fileName = "";
    
    default long getCurrentTime() {
        return System.nanoTime();
    }
    
    default void toFile(BufferedWriter dataDump, String outString) {
        try {
            dataDump.append(outString);
        } catch (IOException ex) {
            Logger.getLogger(ScriptLogLogger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

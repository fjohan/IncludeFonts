/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.lu.scriptlog;

/**
 *
 * @author johanf
 */
interface Logger {
    
    default long getCurrentTime() {
        return System.nanoTime();
    }
    
}

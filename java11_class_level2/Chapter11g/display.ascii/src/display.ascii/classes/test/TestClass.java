/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import displayDiagram.Display;
import displayDiagram.DisplayDetail;
import java.util.StringTokenizer;

/**
 *
 * 
 */
public class TestClass {
    
    public static void main(String[] args) {
        StringTokenizer theBuffer = new StringTokenizer("He who is not contented with what he has"
                + " would not be contented with what he would like to have");
        DisplayDetail[][] theDetails = new DisplayDetail[5][4];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                theDetails[i][j] = new DisplayDetail(theBuffer.nextToken());
            
            }    
        }
        
        Display.outputTextGrid(theDetails);
    }

    
}

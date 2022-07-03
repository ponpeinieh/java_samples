/* Copyright © 2017 Oracle and/or its affiliates. All rights reserved. */

package displayDiagram;



import java.util.Iterator;


public class DisplayLRTree {
    

    
    /* Typical display box
        ------------------    
        |  Doves  Ducks  |
        |     2 - 1      |
        ------------------
    */
    boolean isFinalRound;
    
    String teams;

    String winner;
    
    int teamPaddingNumChars = 1;
    int boxWidth;
    
    static int distBoxToVbar = 8;
    static int distVbarToBox = 3;
    // This sets the column position, colPos
    int distToNextRow;
    int verticalPos;
    int horizontalPos;

    int boxDepth = 5;  // Height of box. Not dynamic but should be used by calling method?

    String score;
    

    //String paddingChar = "#";   // Default is to make padding visible (NOT being used)

    DisplayLRTree(DisplayDetail currGame, int rowNum, int verticalPos, boolean isFinalRound, int longestString, int horizontalPos) { 
        this.boxWidth = (longestString + 2) + teamPaddingNumChars*2;
        //this.boxWidth = longestString + teamPaddingNumChars*2;
        this.horizontalPos = horizontalPos;
        distToNextRow = this.boxWidth + distBoxToVbar + distVbarToBox + 1;
        
        //System.out.println(boxWidth + " : " + distToNextRow + " : " + horizontalPos);
        Iterator<String> gameDetails = currGame.getDetails();
        this.teams = gameDetails.next();
        this.score = gameDetails.next();

        this.isFinalRound = isFinalRound;        

        this.verticalPos = verticalPos;

    }

    
    String getPaddingString(int size, String replaceChar) {
        return new String(new char[size]).replace("\0", replaceChar);
    }
    String getPaddingString(String theString, String replaceChar) {
        return new String(new char[theString.length()]).replace("\0", replaceChar);
    }
    
    private String printTeamRow() {
        
        String teamString = "|" + getPaddingString(teamPaddingNumChars," ") 
                + teams;
        int fillOut = boxWidth - teamString.length() - 1;
        teamString += getPaddingString(fillOut," ");
        return teamString + "|";
    }
    
    private String printScore() {
        
        // TODO 
        // This is from previous code - can be improved a lot
        // Maybe make general as needed several times
        // Also != here but == in other place

        String scoreString = "|    " + score;
        int fillOut = boxWidth - scoreString.length() - 1;
        scoreString += getPaddingString(fillOut," ");
        return scoreString + "|";

    }
    
    void printGameRow(char[][] outputArray, int roundNum, int gameNum, int prevRowPos) {
        
        String theGameRow;
        
        int rowsPrinted = 0;
        int colPos = 0;
        int rowPos;
    
        rowPos = this.verticalPos;
        
        // ** The multiplier here represents the horizontal distance between columns of games
        
        //colPos = roundNum * distToNextRow;    // Was 28
        colPos = this.horizontalPos;
    
        
        // top row
        theGameRow = getPaddingString(boxWidth,"-");
        for (int i = 0; i < theGameRow.length(); i ++) {
            outputArray[rowPos + rowsPrinted][i + colPos] = '-';//theGameRow.toCharArray()[i];
        }
        rowsPrinted++;
        
        // teams row
        theGameRow = printTeamRow();
        for (int i = 0; i < theGameRow.length(); i ++) {
            outputArray[rowPos + rowsPrinted][i + colPos] = theGameRow.toCharArray()[i];
        }
        rowsPrinted++;
        
        // Space row plus connection to bar 
        // ternary to not draw last horizontal bar
        theGameRow = "|" + getPaddingString(boxWidth - 2 ," ") + "|" + getPaddingString((!isFinalRound)?distBoxToVbar:0,"-");
        for (int i = 0; i < theGameRow.length(); i ++) {
            outputArray[rowPos + rowsPrinted][i + colPos] = theGameRow.toCharArray()[i];
        }
 
        
        //Connector from vertical bar
        if (roundNum > 0) {
            theGameRow = getPaddingString(distVbarToBox,"-"); // TODO should be based on column boxWidth
            for (int i = 0; i < theGameRow.length(); i++) {
                outputArray[rowPos + rowsPrinted][colPos - i - 1] = theGameRow.toCharArray()[i];
            }
        }
       
        // the downward bar if the gameNum is odd
        if (gameNum%2 != 0) {
            for (int i = 0; i <= this.verticalPos - prevRowPos; i++) {
                
                outputArray[rowPos + rowsPrinted - i][colPos  + boxWidth + distBoxToVbar] = '|';
                //System.out.print("!!" + (rowPos + rowsPrinted) + " ++ " + (i + colPos);
            }
        }
        rowsPrinted++;
        
        // score row
        theGameRow = printScore();
        for (int i = 0; i < theGameRow.length(); i ++) {
            outputArray[rowPos + rowsPrinted][i + colPos] = theGameRow.toCharArray()[i];
        }
        rowsPrinted++;
        
        // bottom row
        theGameRow = getPaddingString(boxWidth,"-");
        for (int i = 0; i < theGameRow.length(); i ++) {
            outputArray[rowPos + rowsPrinted][i + (colPos)] = theGameRow.toCharArray()[i];
        }
        rowsPrinted++;
    
    }
   
}

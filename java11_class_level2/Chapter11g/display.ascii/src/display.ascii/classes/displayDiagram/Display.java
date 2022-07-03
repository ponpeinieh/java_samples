/* Copyright © 2017 Oracle and/or its affiliates. All rights reserved. */

package displayDiagram;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Display {



        public static void printLRDisplay(List<List<DisplayDetail>> allResults) {

        // Declare the output array parameters
        int arrayWidth = 0, arrayDepth = 0;

        // Iterate through each round and populate a display List of Lists
        ArrayList<List<DisplayLRTree>> allDisplays = new ArrayList<>();
        List<DisplayLRTree> detailRound;
        //List<Game> gameRound = null;

        // First populate all the display data              
        int roundNum = 0; // TODO. These should prob just be *for* loops. Cleaner.

        // ** This determines the vertical distance between the list of games on the left
        // TODO. Not sizing array correctly as > 3 crashes
        
        int minimumInc = 4;
        int verticalAdjustment = minimumInc;
        int horizontalPos = 0;

        for (List<DisplayDetail> currRound : allResults) {
            detailRound = new ArrayList<>();
            DisplayLRTree gameDisplayDetail = null; // Bit dangerous cos depends on if (gameNum) clause to not fail

            // First row is special as it determines array boxDepth
            int topRight = 0; // for first game in the row
            int verticalPos = 0;

            int gameNum = 0;
            int longestString = 0;
            
            // Cycle through first to find longest string in this round
            // TODO shouldn't be necessary to have separate loop here
            for (DisplayDetail currGameResult : currRound) {
                if (currGameResult.longestString > longestString) longestString = currGameResult.longestString;
            }
           // System.out.println("longest " + longestString);
            // Now cycle through to create the box for each game in this round
            
            
            
            for (DisplayDetail currGameResult : currRound) {

                verticalPos += minimumInc;
                //System.out.println("verticalPos " + verticalPos);
                // last parameter indicates if this is last round of tourney
                gameDisplayDetail = new DisplayLRTree(currGameResult, roundNum, verticalPos - verticalAdjustment, (roundNum==allResults.size()-1), longestString, horizontalPos); 
                
                // If top row of a new round, double minimumInc cos it needs to be exactly twice as much for each round
                if (gameNum == 0) {
                    minimumInc *= 2; // double each time gameNum = 0 
                }
                
                detailRound.add(gameDisplayDetail);

                // Figure out array boxDepth. Needs to be for first round to accomodate different team names
                if (roundNum == 0) {
                    arrayDepth += gameDisplayDetail.boxDepth;  // Add for each game in first row
                    if (gameNum != 0) arrayDepth += (((verticalAdjustment - 2)*2)-1);
                }

                gameNum++;
            } 

            // 5 is added cos we really need boxWidth ( and that is 2 + 2 + 1 more than longestString
            horizontalPos += longestString + DisplayLRTree.distBoxToVbar + DisplayLRTree.distVbarToBox + 5;

            arrayWidth += gameDisplayDetail.boxWidth + (roundNum!=0?DisplayLRTree.distVbarToBox + DisplayLRTree.distBoxToVbar + 1:0);   // +1 for vertical bar

            allDisplays.add(detailRound);
            roundNum++;

        }


        // Allow for padding so disnae crash
        // Should be exactly right size!!
        
        //arrayDepth = 70;
        //arrayWidth -= gameDisplayDetail.distVbarToBox;
        
        char[][] outputArray = new char[arrayDepth][arrayWidth];
        for (int i = 0; i < outputArray.length; i++) {
            //for (int i = 0; i < 49 ; i++) {
            for (int j = 0; j < outputArray[i].length; j++) {
                outputArray[i][j] = ' ';
            }
        }

        //System.out.println(arrayDepth + " : " + arrayWidth);

        // Populate the outputArray
        //int incDepth = 16; // minimum vertical distance between games
        int rowPos = 0;
        int prevRowPos = 0;
        roundNum = 0;
        for (List<DisplayLRTree> currRound : allDisplays) {

            // Print the first row
            int gameNum = 0;
            for (Object currDisplay : currRound) {
                DisplayLRTree theDisplayDetail = ((DisplayLRTree) currDisplay);
                rowPos = theDisplayDetail.verticalPos;
                ((DisplayLRTree) currDisplay).printGameRow(outputArray, roundNum, gameNum, prevRowPos);
                prevRowPos = rowPos;
//int topRight = ;
                //System.out.println(((DisplayLRKnockoutDetail)currDisplay).homeTeam + " : " + ((DisplayLRKnockoutDetail)currDisplay).awayTeam);
                gameNum++;
//break;  
            }
//System.out.println(gameNum + " : " + roundNum);
            roundNum++;// += 8;    // This shouldn't be hard-coded. Should be based on space.

        }
        // Check
        //System.out.println("boxDepth " + outputArray.length);
        //System.out.println("length " + outputArray[0].length);

        // Write out the output array
        for (int i = 0; i < outputArray.length; i++) {
            //for (int i = 0; i < 49 ; i++) {

            // Not nec
            for (int j = 0; j < outputArray[i].length; j++) {
                //for (int j = 0; j < 99; j++) {

            }

            String toPrint = new String(outputArray[i]); // Poss don't print last bit of array to exclude horizontal bar?

            System.out.println(toPrint);

        }

    }
       
        public static void outputTextGrid(DisplayDetail[][] dataGrid) {
        
        // It is simple to iterate through the dataGrid and get each item. 
        // However, this outputTextLeagueGrid() method
        // will output a grid using monospaced text and 
	// therefore needs to calculate how wide to make each column.

        // First find the longest item in any column
        int[] stringLength = new int[dataGrid[0].length];   // stringLength givesboxWidthdth for each column
        int totalLength = 0;                                // totalLength helps calculate length needed for horizontal line between columns
        
        for (int i = 0; i < dataGrid[0].length; i++){
            
            int currLongest = 0;
            for (DisplayDetail[] dataGrid1 : dataGrid) {
                int currLength = dataGrid1[i].getDetails().next().length(); // Gets just first item
                if (currLength > currLongest) currLongest = currLength;
            }
            stringLength[i] = currLongest;
            totalLength += currLongest;
        }

        // work out how many extra characters needed for horizontal line between rows
        int numCols = dataGrid[0].length;
        int numExtraCharsPerColum = 3; // One vertical line + space before text and a space after text
        // Create horizontal line of correct length. One extra added to line length for last vertical bar
        String separatorLine = new String(new char[totalLength + (numCols * numExtraCharsPerColum) + 1]).replace("\0", "-"); 
        System.out.println(separatorLine);    
        for (DisplayDetail[] theRow: dataGrid){

            for (int j = 0; j < theRow.length; j++){
                // How many extra chars required to pad out each item
                int extraChars = stringLength[j] - theRow[j].getDetails().next().length();
                // Print out each item in the row    
                System.out.print("| " + theRow[j].getDetails().next() + new String(new char[extraChars]).replace("\0", " ") + " ");

            } 
           
            System.out.print("|");  // Print last item in row
            System.out.println();   // Move to next row
            System.out.println(separatorLine);  // Print howizontal separator line
        }
    }
    

    
    
        private static List<List<DisplayDetail>> flatArrayTo2DListDetails(DisplayDetail[] tempDetail) {

        int numGamesInFirstRound = (tempDetail.length + 1) / 2;
        //int numRounds = (int)(Math.log(teams.length) / Math.log(2));
        int numRounds = (int) (Math.log(numGamesInFirstRound * 2) / Math.log(2));
        //System.out.println("Number of Rounds " + numRounds);
        //System.out.println("Number game in 1 " + numGamesInFirstRound);
        // Create outer array 
        DisplayDetail[][] outerArray = new DisplayDetail[numRounds][];

        int roundNum = 0;
        int indexNum = 0;
        for (int i = numGamesInFirstRound; i > 0; i = i / 2) {

            // Create innerArray
            DisplayDetail[] innerArray = new DisplayDetail[i];
            for (int j = 0; j < i; j++) {

                innerArray[j] = tempDetail[indexNum];
                indexNum++;

            }
            // Add innerArray to outerArray
            outerArray[roundNum] = innerArray;
            roundNum++;
        }

        List<List<DisplayDetail>> newKnGames = Arrays.stream(outerArray).map(Arrays::asList).collect(Collectors.toList());
        return newKnGames;
    } 


    
    
        // Convert Game[] to List<List<GameDisplayDetails>>
    public static void printDataTree ( DisplayDetail[] gameList) {
        
        List<List<DisplayDetail>> gameDetails = flatArrayTo2DListDetails(gameList);
        
        printLRDisplay(gameDetails);

    }
    

    
    
}

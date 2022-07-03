/* Copyright © 2017 Oracle and/or its affiliates. All rights reserved. */

package game;


 class Goal extends SoccerEvent  {
    
    public Goal(){
       
    }
    public String toString() {
        return "GOAL! ";
    }
    

    public SoccerEvent[] getNextFailEvent(){
        SoccerEvent theEvent[] = {new Kickoff()};
        return theEvent;
    }
    public SoccerEvent[] getNextEvents() {
        SoccerEvent theEvent[] = {new Kickoff()};
        return theEvent;
    }
    
    public boolean changePlayer() {
        return false;
    }
    
    public boolean changeTeam() {
        return false;
    }
    

    public void setBallPos(int ballPos) {

        super.ballPos = 100;
    }
    
    public boolean isGoal() {
        return true;
    }
     
}

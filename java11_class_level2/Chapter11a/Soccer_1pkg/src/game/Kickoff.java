/* Copyright © 2017 Oracle and/or its affiliates. All rights reserved. */

package game;


 class Kickoff extends SoccerEvent  {  // Really it's a special Pass
    
    public Kickoff() {

    }

    public String toString() {
        return "Kickoff "; 
    }
    
    public SoccerEvent[] getNextEvents() {
        SoccerEvent theEvent[] = { new ReceivePass()};
        return theEvent;
    }
    
    public boolean changePlayer() {
        return true;
    }
    
    public boolean changeTeam() {
        return true;
    }
    
        // Little bit of a hack maybe as ballPos not used.
    public void setBallPos(int ballPos) {
       //super.setBallPos(50);
       super.ballPos = 50;
    }
    
}

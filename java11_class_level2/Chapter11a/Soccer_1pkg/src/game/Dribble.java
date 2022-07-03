/* Copyright © 2017 Oracle and/or its affiliates. All rights reserved. */

package game;


class Dribble extends SoccerEvent {
    

    public Dribble(){
        
        super();
        
    }

    
    public String toString() {
        return "Dribble ";
    }
    
    public SoccerEvent[] getNextEvents() {
        SoccerEvent theEvent[] = { new Shoot(), new Pass(), new FreeKickToAttackingSide()};
        return theEvent;
    }
    
    public boolean changePlayer() {
        return false;
    }
    
    public boolean changeTeam() {
        return false;
    }
    
}

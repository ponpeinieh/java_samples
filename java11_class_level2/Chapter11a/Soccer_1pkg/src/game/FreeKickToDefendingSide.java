/* Copyright © 2017 Oracle and/or its affiliates. All rights reserved. */

package game;


class FreeKickToDefendingSide extends SoccerEvent {
    
    public FreeKickToDefendingSide(){
        
        super();
        
    }
    
    public String toString() {
        return "Fouled. Free kick to defending side.";
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
    
}

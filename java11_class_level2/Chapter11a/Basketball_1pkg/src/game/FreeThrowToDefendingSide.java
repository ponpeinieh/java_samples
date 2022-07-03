/* Copyright © 2017 Oracle and/or its affiliates. All rights reserved. */

package game;


 class FreeThrowToDefendingSide extends BasketballEvent {
    

    public FreeThrowToDefendingSide(){
        
        super();
        
    }
    
    public String toString() {
        return "Fouled. Possession given to other side";
    }
    
    public BasketballEvent[] getNextEvents() {
        BasketballEvent theEvent[] = { new GainPossession()};
        return theEvent;
    }
    
    public boolean changePlayer() {
        return true;
    }
    
    public boolean changeTeam() {
        return true;
    }
    
}

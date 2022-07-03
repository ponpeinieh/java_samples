/* Copyright © 2017 Oracle and/or its affiliates. All rights reserved. */

package game;


 class Pass extends SoccerEvent  {
    
    public Pass(){
        
        super();
        
    }
    
    public String toString() {
        return "Pass attempt ";
    }
    
    public SoccerEvent[] getNextEvents() {
        SoccerEvent theEvent[] = { new ReceivePass() };
        return theEvent;
    }
    
    public boolean changePlayer() {
        return false;
    }
    
    public boolean changeTeam() {
        return false;
    }
    
}

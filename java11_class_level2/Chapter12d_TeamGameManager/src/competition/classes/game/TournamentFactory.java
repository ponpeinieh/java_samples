/* Copyright © 2017 Oracle and/or its affiliates. All rights reserved. */

package game;

import gameapi.Team;
import gameapi.TournamentType;
import java.util.ServiceLoader;


public class TournamentFactory {
    
    public static TournamentType getTournament(String tourneyType, String gameType, Team[] theTeams) {
        
        TournamentType theTourney = getTournament(tourneyType);
        theTourney.populate(gameType, theTeams);
        
        return theTourney;
  
    }
    
    public static TournamentType getTournament(String name) {
        
        TournamentType theTourney = null;
        ServiceLoader<TournamentType> sl = ServiceLoader.load(TournamentType.class);
        
        for ( TournamentType currTournament: sl) {
            
            if (currTournament.getName().equalsIgnoreCase(name)) {
                  theTourney = currTournament;
                  break;
            }

        }
        
        if (theTourney == null) {
            throw new RuntimeException("No suitable service provider found!");
        } 

        return theTourney;
    }
    
}

/* Copyright © 2017 Oracle and/or its affiliates. All rights reserved. */

package game;

import gameapi.Team;
import gameapi.Game;

import gameapi.GameProvider;
import gameapi.Player;
import java.time.LocalDateTime;
import java.util.ServiceLoader;


public class Factory {
    
    static GameProvider theProvider;
//    static String theGameType = "";
    
    public static GameProvider getProvider(String gameType) {

        //GameProvider theProvider = null;
        //String theGameType = "";

        // TODO Another possibly better approach would be to make GameProvider itself a singleton
        if (theProvider == null || !theProvider.getType().equals(gameType)) {

            ServiceLoader<GameProvider> iter = ServiceLoader.load(GameProvider.class);

            for (GameProvider currProvider: iter){
                //System.out.println(currProvider.getClass() + " : " + currProvider.hashCode());
                if (currProvider.getType().equalsIgnoreCase(gameType)){
                    theProvider = currProvider;

                    return theProvider;

                }
            }
            throw new RuntimeException("No suitable service provider found!");
        }

        return theProvider;
        
    }
    
    public static Team createTeam(String gameType, String teamName, Player[] thePlayers)  {
        theProvider = getProvider(gameType);
        return theProvider.getTeam(teamName.trim(), thePlayers);
    }

    
    public static Game createGame(String gameType, Team homeTeam, Team awayTeam, LocalDateTime dateOfGame) {
        
        theProvider = getProvider(gameType);
        
        return theProvider.getGame(homeTeam, awayTeam, dateOfGame);


    }
    
    public static Player createPlayer(String gameType, String playerName) {
        
        theProvider = getProvider(gameType);
        
        return theProvider.getPlayer(playerName);

    }
}

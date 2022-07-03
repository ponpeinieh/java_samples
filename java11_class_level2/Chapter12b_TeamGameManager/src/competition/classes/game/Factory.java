/* Copyright © 2017 Oracle and/or its affiliates. All rights reserved. */
package game;

import gameapi.Team;
import gameapi.Game;
import gameapi.Player;
import gameapi.GameProvider;
import java.time.LocalDateTime;
import java.util.ServiceLoader;

public class Factory {

    private static GameProvider theProvider = null;

    public static GameProvider getProvider(String gameType) {
        if (theProvider == null || !theProvider.getType().equals(gameType)) {
            ServiceLoader<GameProvider> loader = ServiceLoader.load(GameProvider.class);
            for (var gp : loader) {
                if (gp.getType().equals(gameType)) {
                    theProvider = gp;
                    break;
                }
            }
        }
        if (theProvider == null) {
            throw new RuntimeException("No suitable service provider found  !");
        }
        return theProvider;
    }

    public static Team createTeam(String gameType, String teamName, Player[] thePlayers) {
        GameProvider gp = getProvider(gameType);
        return gp.getTeam(teamName, thePlayers);
    }

    public static Game createGame(String gameType, Team homeTeam, Team awayTeam, LocalDateTime dateOfGame) {
        GameProvider gp = getProvider(gameType);
        return gp.getGame(homeTeam, awayTeam, dateOfGame);
    }

    public static Player createPlayer(String gameType, String playerName) {
        GameProvider gp = getProvider(gameType);
        return gp.getPlayer(playerName);
    }
}

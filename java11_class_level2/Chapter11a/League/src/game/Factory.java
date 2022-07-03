/* Copyright © 2017 Oracle and/or its affiliates. All rights reserved. */

package game;


import java.time.LocalDateTime;


public class Factory {
    
    public static Team createTeam(String gameType, String teamName, Player[] thePlayers) {

        switch (gameType) {

            case "soccer":
                return new SoccerTeam(teamName.
                            trim(), thePlayers);
            case "basketball":
                return new BasketballTeam(teamName.
                            trim(), thePlayers);

            default:
                throw new RuntimeException("Not a valid gametype");
        }

    }
    
    public static Game createGame(String gameType, Team homeTeam, Team awayTeam, LocalDateTime dateOfGame) {

        switch (gameType) {

            case "soccer":
                return new Soccer(homeTeam, awayTeam, dateOfGame);

            case "basketball":
                return new Basketball(homeTeam, awayTeam, dateOfGame);

            default:
                throw new RuntimeException("Not a valid gametype");
        }

    }
    
    public static Player createPlayer(String gameType, String playerName) {

        switch (gameType) {

            case "soccer":
                return new SoccerPlayer(playerName);

            case "basketball":
                return new BasketballPlayer(playerName);

            default:
                throw new RuntimeException("Not a valid gametype");
        }

    }    
}

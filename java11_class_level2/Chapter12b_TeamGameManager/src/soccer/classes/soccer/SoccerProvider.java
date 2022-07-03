/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soccer;

import gameapi.Game;
import gameapi.GameProvider;
import gameapi.Player;
import gameapi.Team;
import java.time.LocalDateTime;

/**
 *
 * @author javat
 */
public class SoccerProvider implements GameProvider {

    @Override
    public Game getGame(Team homeTeam, Team awayTeam,
            LocalDateTime plusDays) {
        return new Soccer(homeTeam, awayTeam, plusDays);
    }

    @Override
    public Player getPlayer(String playerName) {
        return new SoccerPlayer(playerName);
    }

    @Override
    public Team getTeam(String teamName, Player[] players) {
        return new SoccerTeam(teamName, players);
    }

    @Override
    public String getType() {
        return "soccer";
    }

}

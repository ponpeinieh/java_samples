/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basketball;

import gameapi.Game;
import gameapi.GameProvider;
import gameapi.Player;
import gameapi.Team;
import java.time.LocalDateTime;

/**
 *
 * @author javat
 */
public class BasketballProvider implements GameProvider {

    @Override
    public Game getGame(Team homeTeam, Team awayTeam,
            LocalDateTime plusDays) {
        return new Basketball(homeTeam, awayTeam, plusDays);
    }

    @Override
    public Player getPlayer(String playerName) {
        return new BasketballPlayer(playerName);
    }

    @Override
    public Team getTeam(String teamName, Player[] players) {
        return new BasketballTeam(teamName, players);
    }

    @Override
    public String getType() {
        return "basketball";
    }

}

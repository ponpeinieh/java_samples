/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gameapi;

import java.time.LocalDateTime;

/**
 *
 * @author javat
 */
public interface GameProvider {

    Game getGame(Team homeTeam, Team awayTeam, LocalDateTime plusDays);

    Player getPlayer(String playerName);

    Team getTeam(String teamName, Player[] players);

    String getType();
}

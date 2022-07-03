/* Copyright © 2017 Oracle and/or its affiliates. All rights reserved. */
package main;

import database.PlayerDatabase;
import database.PlayerDatabaseException;
import displayDiagram.Display;
import displayDiagram.DisplayDetail;
import league.League;
import java.util.StringTokenizer;
import game.Factory;
import gameapi.Game;
import gameapi.Team;
import gameapi.TournamentType;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import static java.util.stream.Collectors.*;


public class Test {

    public static void main(String[] args) {

        Game[] newGames = storage.JacksonUtil.getGamesFromJSONFile("data", "leagueSoccer02.json");
        // TODO new League is not ideal!! Should be gotten via service - maybe one that creates correct tournament type from game collection
        TournamentType theLeagueCompetition = new League(newGames);

        DisplayDetail[][] dataGrid = getDataGrid(theLeagueCompetition.getGames(), theLeagueCompetition.getTeams());
        Display.outputTextGrid(dataGrid);

        //DisplayDetail[] dataKnockout = getData(theLeagueCompetition.getGames());
        // Team to focus on
        String theTeam = "Magpies";

        //List all the Magpies games, home and away
        System.out.println("Magpies games both home and away.\n");

        Arrays.stream(theLeagueCompetition.getGames())
                .filter(g -> g.getHomeTeam().getTeamName().equals(theTeam) || g.getAwayTeam().getTeamName().equals(theTeam))
                .forEach(g -> System.out.println(g.getHomeTeam() + "/" + g.getAwayTeam() + "/" + g.getScore()));

        // List scorers in Magpies games
        System.out.println("\nScorers in each game listed for each goal they scored. If a name is listed twice they scored two goals.");
        Map<String, List<String>> theGames01
                = Arrays.stream(theLeagueCompetition.getGames())
                        .filter(g -> g.getHomeTeam().getTeamName().equals(theTeam) || g.getAwayTeam().getTeamName().equals(theTeam))
                        .collect(groupingBy(g -> g.getHomeTeam().getTeamName() + ":" + g.getAwayTeam().getTeamName(),
                                flatMapping(g -> Arrays.stream(g.getEvents()),
                                        filtering(e -> e.isGoal() && e.getTheTeam().getTeamName().equals(theTeam),
                                                mapping(g -> g.getThePlayer().getPlayerName(), toList())))));

        System.out.println(theGames01);

        // List scorers in Magpies games
        System.out.println("\nScorers in each game with their number of goals given");

        Map<String, Map<String, Long>> theGames
                = Arrays.stream(theLeagueCompetition.getGames())
                        .filter(g -> g.getHomeTeam().getTeamName().equals(theTeam) || g.getAwayTeam().getTeamName().equals(theTeam))
                        .collect(groupingBy(g -> g.getHomeTeam().getTeamName() + ":" + g.getAwayTeam().getTeamName(),
                                flatMapping(g -> Arrays.stream(g.getEvents()),
                                        filtering(e -> e.isGoal() && e.getTheTeam().getTeamName().equals(theTeam),
                                                groupingBy(g -> g.getThePlayer().getPlayerName(), counting())))));

        System.out.println(theGames + "\n");

        System.out.println("\nTotal goals scored by each player");
        Map<String, Long> theGames03
                = Arrays.stream(theLeagueCompetition.getGames())
                        .collect(
                                flatMapping(g -> Arrays.stream(g.getEvents()),
                                        filtering(e -> e.isGoal() && e.getTheTeam().getTeamName().equals(theTeam),
                                                groupingBy(g -> g.getThePlayer().getPlayerName(), counting()))));

        System.out.println(theGames03 + "\n");

        System.out.println("\nTotal goals scored by each player - different approach with filter not filtering");
        Map<String, Long> theGames04
                = Arrays.stream(theLeagueCompetition.getGames())
                        .flatMap(g -> Arrays.stream(g.getEvents()))
                        .filter(e -> e.isGoal() && e.getTheTeam().getTeamName().equals(theTeam))
                        .collect(groupingBy(g -> g.getThePlayer().getPlayerName(), counting()));

        System.out.println(theGames04 + "\n");

        System.out.println("\nGoals scored by each player - listed per game that they scored in");
        Map<String, List<Long>> theGames06
                = Arrays.stream(theLeagueCompetition.getGames())
                        .filter(g -> g.getHomeTeam().getTeamName().equals(theTeam) || g.getAwayTeam().getTeamName().equals(theTeam))
                        .collect(groupingBy(g -> g.getHomeTeam().getTeamName() + ":" + g.getAwayTeam().getTeamName(),
                                flatMapping(g -> Arrays.stream(g.getEvents()),
                                        filtering(e -> e.isGoal() && e.getTheTeam().getTeamName().equals(theTeam),
                                                groupingBy(g -> g.getThePlayer().getPlayerName(), counting())))))
                        .entrySet().stream() // Set of Map.Entry types
                        .flatMap(p -> p.getValue().entrySet().stream()) // Stream of Entry types
                        .collect(groupingBy(Entry::getKey, mapping(m -> m.getValue(), toList())));

        System.out.println("** " + theGames06);

        // Modify so that it's how many they scored in each game. So that 0 shown if they scored none.
    }

    private static DisplayDetail[][] getDataGrid(Game[] theGames, Team[] theTeams) {

        int numTeams = theTeams.length;

        // Size of grid allow for extra column on the left for list of Teams, and two 
        // extra columns on right for Points and Goals. Also extra column on top for list of
        // Teams.
        DisplayDetail[][] theGrid = new DisplayDetail[numTeams + 1][numTeams + 3];

        int colNum = 0;
        int rowNum = 0;

        // Starting at 0, 0, insert a blank top left corner.
        theGrid[rowNum][colNum] = new DisplayDetail("");

        // Do the first row of Teams (headings);
        for (int i = 0; i < theTeams.length; i++) {

            theTeams[i].setId(i);   // set the Id to the index
            // ternary expression below determines whether to add the full orginal Team class or a simple 
            // DisplayString class
            theGrid[rowNum][colNum + 1] = new DisplayDetail(theTeams[i].getTeamName());
            //theGrid[rowNum][colNum + 1] = theTeams[i];
            colNum++;
        }

        // Add Points and Games columns to the first row (headings)
        theGrid[rowNum][colNum + 1] = new DisplayDetail("League Pts");
        // Getting "Goals" vs "Baskets" from Game (same on all IGames - another approach?)
        theGrid[rowNum][colNum + 2] = new DisplayDetail(theGames[0].getScoreDescriptionString());

        // Add each row of Games for each home team (note all Team IDs will be set by previous for loop
        // Also note rowNum = i + 1; therefore starting on second row.
        for (int i = 0; i < theTeams.length; i++) {
            rowNum = i + 1;

            // Add the home Team to the first column of the current row
            colNum = 0;
            Team currHomeTeam = theTeams[i];
            //theGrid[rowNum][colNum] = currHomeTeam;

            theGrid[rowNum][colNum] = new DisplayDetail(currHomeTeam.getTeamName());
            //theGrid[rowNum][colNum] = theTeams[i];

            // Inner loop through all away teams on current row to add Games
            for (Team currAwayTeam : theTeams) {
                colNum++;   // Could also use traditional for loop here
                if (currHomeTeam != currAwayTeam) {
                    for (Game theGame : theGames) {
                        if (theGame.getHomeTeam().getTeamName().equals(currHomeTeam.getTeamName())
                                && theGame.getAwayTeam().getTeamName().equals(currAwayTeam.getTeamName())) {
                            //theGrid[rowNum][colNum] = theGame;
                            //theGrid[rowNum][colNum] = useOriginalClass?theGame:new DisplayString(theGame.getScore());
                            //theGrid[rowNum][colNum] = theGame;
                            //System.out.println("Setting the score!");
                            theGrid[rowNum][colNum] = new DisplayDetail(theGame.getScore());
                            break;

                        }
                    }
                } else {
                    theGrid[rowNum][colNum] = new DisplayDetail(" X ");    // Mark with X as team doesn't play itself
                }
            }

            // Add last two columns to current row (team points and goals)
            theGrid[rowNum][colNum + 1] = new DisplayDetail(Integer.toString(currHomeTeam.getPointsTotal()));
            theGrid[rowNum][colNum + 2] = new DisplayDetail(Integer.toString(currHomeTeam.getGoalsTotal()));
        }
        return theGrid;
    }

    public static Team[] createTeams(String gameType, String teamNames, int teamSize) throws PlayerDatabaseException {

        PlayerDatabase playerDB = new PlayerDatabase(gameType);

        StringTokenizer teamNameTokens = new StringTokenizer(teamNames, ",");
        Team[] theTeams = new Team[teamNameTokens.countTokens()];
        for (int i = 0; i < theTeams.length; i++) {

            theTeams[i] = Factory.createTeam(gameType, teamNameTokens.nextToken(), playerDB.getTeamPlayers(teamSize));
        }

        return theTeams;
    }

    // Convert array of Game into array of DisplayDetail so display-ascii library can process
    public static DisplayDetail[] getData(Game[] gameList) {

        DisplayDetail[] theDetails = new DisplayDetail[gameList.length];

        for (int i = 0; i < gameList.length; i++) {
            theDetails[i] = new DisplayDetail(gameList[i].getHomeTeam().getTeamName() + " " + gameList[i].getAwayTeam().getTeamName());
            theDetails[i].addDetail(gameList[i].getScore());
        }

        return theDetails;

    }

}

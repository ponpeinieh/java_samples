/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game;


 class BasketballResult implements GameResult {
    
 
    private final Team homeTeam;
    private final Team awayTeam;
    private Team winner;
    private int homeTeamGoals;
    private int awayTeamGoals;
    private boolean isDrawn;
    
 
    @Override
    public boolean isDrawnGame() {
        return isDrawn;
    } 
    
    // Possibly throw Exception here for game not played or drawn game
    @Override
    public Team getWinner()  {
        return this.winner;
    }  
    @Override
    public int getHomeTeamScore(){
        return this.homeTeamGoals;
    }
    @Override
    public int getAwayTeamScore(){
        return this.awayTeamGoals;
    }
   
   // Constructor 
   public BasketballResult(Game currGame) {
        this.homeTeam = currGame.getHomeTeam();  // This might change in later version
        this.awayTeam = currGame.getAwayTeam();
        setGoals(currGame);       
         if (homeTeamGoals == awayTeamGoals){
            this.isDrawn = true;       
        } else if (homeTeamGoals > awayTeamGoals) {
            this.winner = this.homeTeam;
        } else {
            this.winner = this.awayTeam;
        }

    }

    private void setGoals(Game currGame) {
       for (GameEvent currEvent: currGame.getEvents()) {
            if (currEvent instanceof FreeThrowToAttackingSide || currEvent instanceof Basket ) {
                 if (currEvent.getTheTeam().getTeamName().equals(currGame.getHomeTeam().getTeamName())){
                    //System.out.println("I'm a " + this.homeTeam);
                    this.homeTeamGoals += 3; // Could be random based on type of throw
                    
                } else {
                    //System.out.println("I'm a " + this.awayTeam);
                    this.awayTeamGoals += 3;
                    
                }

            }
       }
    } 
    
    @Override
    public String getScore() {
        return homeTeamGoals + " - " + awayTeamGoals;
    }

    /**
     * @return the homeTeam
     */
    @Override
    public Team getHomeTeam() {
        return homeTeam;
    }

    /**
     * @return the awayTeam
     */
    @Override
    public Team getAwayTeam() {
        return awayTeam;
    }
 
}

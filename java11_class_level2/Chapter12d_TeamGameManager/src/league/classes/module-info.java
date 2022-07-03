/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
module league {

    requires competition;
    provides gameapi.TournamentType with league.League;
    
    exports league; // Might be necessary for loading from JSON
}

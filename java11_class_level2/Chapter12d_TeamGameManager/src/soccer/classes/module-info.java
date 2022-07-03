/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
module soccer {
    
    requires competition;

    requires java.logging;
    //exports soccer to competition;
    opens soccer to jackson.databind;
    
    provides gameapi.GameProvider with soccer.SoccerProvider;
}

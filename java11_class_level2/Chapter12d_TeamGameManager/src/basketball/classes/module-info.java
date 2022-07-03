/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
module basketball {
    requires competition;

    requires java.logging;

    opens basketball to jackson.databind;
    
    provides gameapi.GameProvider with basketball.BasketballProvider;
}

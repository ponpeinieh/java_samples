/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2SEModule/module-info.java to edit this template
 */

module soccer {
    requires gameapi;
    requires java.logging;
    opens soccer to jackson.databind;
    provides gameapi.GameProvider with soccer.SoccerProvider;
}

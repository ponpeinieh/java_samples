/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2SEModule/module-info.java to edit this template
 */

module basketball {
    requires gameapi;
    requires java.logging;
    exports basketball to competition;
    opens basketball to jackson.databind;
}

module League {
    requires Basketball;
    requires Soccer;
    requires display.ascii;
    requires java.logging;

    exports game;
    exports main;
    exports utils;

}

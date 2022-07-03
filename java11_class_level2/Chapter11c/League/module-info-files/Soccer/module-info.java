module Soccer {
    requires java.logging;

    requires transitive League;

    exports soccer;
    exports util;

}

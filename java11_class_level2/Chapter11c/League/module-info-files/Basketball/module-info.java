module Basketball {
    requires java.logging;

    requires transitive League;

    exports basketball;
    exports util;

}

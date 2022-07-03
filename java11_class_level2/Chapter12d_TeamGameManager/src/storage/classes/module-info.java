/* Copyright © 2017 Oracle and/or its affiliates. All rights reserved. */

module storage {
    requires jackson.annotations;
    requires jackson.core;
    requires jackson.databind;
    requires transitive competition;    // As Game arrays can be returned by storage
    exports storage;
}

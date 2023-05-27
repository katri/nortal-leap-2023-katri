package com.assignment.nl22w.game.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ResourceImplTest {

    @Test
    void validMapWith_mapIsValid() {
        int nrOfInputRows = 2;
        char[][] map = new char[nrOfInputRows][];
        map[0] = new char[]{'1', '1', '1'};
        map[1] = new char[]{32, 'X', 'X'};

        ResourceImpl resource = new ResourceImpl();
        boolean isMapValid = resource.mapIsValid(map, nrOfInputRows);

        assertTrue(isMapValid);
    }

    @Test
    void invalidMapWith_mapIsValid() {
        int nrOfInputRows = 2;
        char[][] map = new char[nrOfInputRows][];
        map[0] = new char[]{'2', '2', 'y'};
        map[1] = new char[]{32, 'X', 'X'};

        ResourceImpl resource = new ResourceImpl();
        boolean isMapValid = resource.mapIsValid(map, nrOfInputRows);

        assertFalse(isMapValid);
    }
}

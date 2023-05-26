package com.assignment.nl22w.game.impl;

import com.assignment.nl22w.game.Game;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class GameImpl implements Game {

    @Override
    public int escapeFromTheWoods(Resource resource) throws IOException {
        MyResource myResource = (MyResource) resource;

//        char[][] map = myResource.readFile();

        int[] xCoordinates = findX(myResource.getMapFile());


//		System.out.println(-1);
        //		TODO start your journey here

        return -1;
    }

    private int[] findX(char[][] map) {
        int x = 0;
        int y = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 'X') {
                    x = i;
                    y = j;
                }
            }
        }

        return new int[]{x, y};
    }
}

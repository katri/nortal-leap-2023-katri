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


        char[][] updatedMap = updateMapCharacters(myResource.getMapFile());
        myResource.setMapFile(updatedMap);

        char[][] filledMap = fillMap(updatedMap);


        //		TODO start your journey here

        return -1;
    }

    private int[] findStart(char[][] map) {
        int x = 0;
        int y = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == '0') {
                    x = i;
                    y = j;
                }
            }
        }

        return new int[]{x, y};
    }

    private char[][] updateMapCharacters(char[][] mapFile) {
        for (int i = 0; i < mapFile.length; i++) {
            for (int j = 0; j < mapFile[i].length; j++) {
                if (mapFile[i][j] == '1') {
                    mapFile[i][j] = 'B';
                }
                if (mapFile[i][j] == 'X') {
                    mapFile[i][j] = '0';
                }


            }
        }
        return mapFile;
    }

    private char[][] fillMap(char[][] mapFile) {
        int[] startCoordinates = findStart(mapFile);
        int iValue = startCoordinates[0];
        int jValue = startCoordinates[1];
        int value = Character.getNumericValue(mapFile[iValue][jValue]);

        int countOfEmpties = 0;
        for (int i = 0; i < mapFile.length ; i++) {
            for (int j = 0; j <mapFile[i].length ; j++) {
                if (mapFile[i][j] == 32) {
                    countOfEmpties++;
                }
            }
        }

        while (countOfEmpties > 0) {

            for (int i = 0; i < mapFile.length; i++) {
                for (int j = 0; j < mapFile[i].length; j++) {
                    int ourCharValue = Character.getNumericValue(mapFile[i][j]);
                    if (ourCharValue == value
                            && 0 < i && i < mapFile.length
                            && 0 < j && j < mapFile[i].length) {
                        if (mapFile[i - 1][j] == 32) {
                            mapFile[i - 1][j] = Character.forDigit(value+1, 10);
                        }
                        if (mapFile[i + 1][j] == 32) {
                            mapFile[i + 1][j] = Character.forDigit(value+1, 10);
                        }
                        if (mapFile[i][j - 1] == 32) {
                            mapFile[i][j - 1] = Character.forDigit(value+1, 10);
                        }
                        if (mapFile[i][j + 1] == 32) {
                            mapFile[i][j + 1] = Character.forDigit(value+1, 10);
                        }
                    }
                }
            }
            countOfEmpties = 0;
            value++;

            for (int i = 0; i < mapFile.length ; i++) {
                for (int j = 0; j <mapFile[i].length ; j++) {
                    if (mapFile[i][j] == 32) {
                        countOfEmpties++;
                    }
                }
            }
        }


//        fillLeft(mapFile[iValue - 1][jValue], value);
//        fillRight(mapFile);
//        fillTop(mapFile);
//        fillBottom(mapFile);


        return mapFile;
    }


}

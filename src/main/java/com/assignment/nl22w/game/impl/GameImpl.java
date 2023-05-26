package com.assignment.nl22w.game.impl;

import com.assignment.nl22w.game.Game;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class GameImpl implements Game {

    @Override
    public int escapeFromTheWoods(Resource resource) {
        MyResource myResource = (MyResource) resource;
        int[][] updatedMap = myResource.getMapFile();

        int[][] filledMap = fillMap(updatedMap);

        return findResult(filledMap);
    }

    private int findResult(int[][] filledMap) {
        int resultValue = -1;
        List<Integer> edgeNumbers = new ArrayList<>();

        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < filledMap[i].length; j++) {
                if (filledMap[i][j] > resultValue) {
                    edgeNumbers.add(filledMap[i][j]);
                }
            }
        }

        for (int i = filledMap.length - 1; i < filledMap.length; i++) {
            for (int j = 0; j < filledMap[i].length; j++) {
                if (filledMap[i][j] > resultValue) {
                    edgeNumbers.add(filledMap[i][j]);
                }
            }
        }

        for (int i = 1; i < filledMap.length; i++) {
            for (int j = 0; j < 1; j++) {
                if (filledMap[i][j] > resultValue) {
                    edgeNumbers.add(filledMap[i][j]);
                }
            }
            for (int j = filledMap[i].length - 1; j < filledMap[i].length; j++) {
                if (filledMap[i][j] > resultValue) {
                    edgeNumbers.add(filledMap[i][j]);
                }
            }
        }
        return findMin(edgeNumbers);
    }

    private int findMin(List<Integer> edgeNumbers) {

        int minValue = edgeNumbers.get(0);

        for (int i = 0; i < edgeNumbers.size() - 1; i++) {
            if (edgeNumbers.get(i) > edgeNumbers.get(i + 1)) {
                minValue = edgeNumbers.get(i + 1);
            }


        }

        return minValue - 1;
    }

    private int[] findStart(int[][] map) {
        int x = 0;
        int y = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1) {
                    x = i;
                    y = j;
                }
            }
        }

        return new int[]{x, y};
    }

//    private int[][] updateMapCharacters(int[][] mapFile) {
//        for (int i = 0; i < mapFile.length; i++) {
//            for (int j = 0; j < mapFile[i].length; j++) {
//                if (mapFile[i][j] == '1') {
//                    mapFile[i][j] = 'B';
//                }
//                if (mapFile[i][j] == 'X') {
//                    mapFile[i][j] = '0';
//                }
//
//
//            }
//        }
//        return mapFile;
//    }

    private int[][] fillMap(int[][] mapFile) {
        int[] startCoordinates = findStart(mapFile);
        int iValue = startCoordinates[0];
        int jValue = startCoordinates[1];
        int value = 1;

        int countOfEmpties = 0;
        for (int i = 0; i < mapFile.length; i++) {
            for (int j = 0; j < mapFile[i].length; j++) {
                if (mapFile[i][j] == 0) {
                    countOfEmpties++;
                }
            }
        }

        while (countOfEmpties > 0) {

            for (int i = 0; i < mapFile.length; i++) {
                for (int j = 0; j < mapFile[i].length; j++) {
                    int ourCharValue = mapFile[i][j];
                    if (ourCharValue == value
                            && 0 < i && i < mapFile.length
                            && 0 < j && j < mapFile[i].length) {
                        if (mapFile[i - 1][j] == 0) {
                            mapFile[i - 1][j] = value + 1;
                        }
                        if (mapFile[i + 1][j] == 0) {
                            mapFile[i + 1][j] = value + 1;
                        }
                        if (mapFile[i][j - 1] == 0) {
                            mapFile[i][j - 1] = value + 1;
                        }
                        if (mapFile[i][j + 1] == 0) {
                            mapFile[i][j + 1] = value + 1;
                        }
                    }
                }
            }
            countOfEmpties = 0;
            value++;

            for (int i = 0; i < mapFile.length; i++) {
                for (int j = 0; j < mapFile[i].length; j++) {
                    if (mapFile[i][j] == 0) {
                        countOfEmpties++;
                    }
                }
            }
        }

//
////        fillLeft(mapFile[iValue - 1][jValue], value);
////        fillRight(mapFile);
////        fillTop(mapFile);
////        fillBottom(mapFile);
//
//
        return mapFile;
    }
//

}

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
        ResourceImpl resourceImpl = (ResourceImpl) resource;
        resourceImpl.setMapFile();

        int[][] updatedMap = resourceImpl.getMapFile();

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

    private int[][] fillMap(int[][] mapFile) {
        int value = 1;

        int countOfEmpties = getCountOfEmpties(mapFile);

        while (countOfEmpties > 0) {

            for (int i = 0; i < mapFile.length; i++) {
                for (int j = 0; j < mapFile[i].length; j++) {
                    int selectedInt = mapFile[i][j];
                    if (selectedInt == value
                            && 0 < i && i < mapFile.length - 1
                            && 0 < j && j < mapFile[i].length - 1) {
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
            countOfEmpties = getCountOfEmpties(mapFile);
            value++;
        }
        return mapFile;
    }

    private static int getCountOfEmpties(int[][] mapFile) {
        int countOfEmpties = 0;
        for (int[] ints : mapFile) {
            for (int anInt : ints) {
                if (anInt == 0) {
                    countOfEmpties++;
                }
            }
        }
        return countOfEmpties;
    }
}

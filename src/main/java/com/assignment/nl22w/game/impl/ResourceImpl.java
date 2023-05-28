package com.assignment.nl22w.game.impl;

import org.springframework.core.io.Resource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;

public class ResourceImpl implements Resource {

    private int[][] mapFile;

    public int[][] getMapFile() {
        return mapFile;
    }

    public void setMapFile() {
        this.mapFile = readFile();
    }

    public int[][] readFile() {
        char[][] map = new char[11000][];
        int
                nrOfInputRows = 0;

        try {
            File file = new File("src/main/resources/map1.txt");

            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                map[nrOfInputRows] = line.toCharArray();
                nrOfInputRows++;
            }
            scanner.close();
        } catch (FileNotFoundException exception) {
            throw new RuntimeException(exception);
        }

        if (mapIsValid(map, nrOfInputRows)) {
            int[][] newMap = new int[nrOfInputRows][];
            for (int i = 0; i < newMap.length; i++) {
                newMap[i] = new int[map[i].length];
                for (int j = 0; j < map[i].length; j++) {
                    newMap[i][j] = 0;
                }
            }
            for (int i = 0; i < nrOfInputRows; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    if (map[i][j] == '1') {
                        newMap[i][j] = -1;
                    }
                    if (map[i][j] == 'X') {
                        newMap[i][j] = 1;
                    }
                }
            }
            return newMap;
        }
        return null;
    }

    public boolean mapIsValid(char[][] map, int nrOfInputRows) {
        boolean mapIsValid = nrOfInputRows != 0;

        for (int i = 0; i < nrOfInputRows; i++) {
            if (map[i] == null) {
                mapIsValid = false;
                break;
            }
        }

        if (mapIsValid) {
            for (int i = 0; i < nrOfInputRows; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    if (map[i][j] == '1' || map[i][j] == 'X' || map[i][j] == 32) {
                    } else {
                        mapIsValid = false;
                        break;
                    }
                }
            }
        }

        return mapIsValid;
    }

    @Override
    public boolean exists() {
        return false;
    }

    @Override
    public URL getURL() {
        return null;
    }

    @Override
    public URI getURI() {
        return null;
    }

    @Override
    public File getFile() {
        return null;
    }

    @Override
    public long contentLength() {
        return 0;
    }

    @Override
    public long lastModified() {
        return 0;
    }

    @Override
    public Resource createRelative(String relativePath) {
        return null;
    }

    @Override
    public String getFilename() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public InputStream getInputStream() {
        return null;
    }
}
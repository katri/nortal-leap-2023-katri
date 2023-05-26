package com.assignment.nl22w.game.impl;

import org.springframework.core.io.Resource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;

public class MyResource implements Resource {

    private int[][] mapFile;

    public int[][] getMapFile() {
        return mapFile;
    }

    public void setMapFile() {
        this.mapFile = readFile();
    }

    public int[][] readFile() {
        char[][] map = new char[11000][];
        int n = 0;

        try {
            File file = new File("src/main/resources/ee.txt");

            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                map[n] = line.toCharArray();
                n++;
            }
            scanner.close();
        } catch (FileNotFoundException exception) {
            throw new RuntimeException(exception);
        }

        int[][] newMap = new int[n][];
        for (int i = 0; i < newMap.length; i++) {
            newMap[i] = new int[map[i].length];
            for (int j = 0; j < map[i].length; j++) {
                newMap[i][j] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
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
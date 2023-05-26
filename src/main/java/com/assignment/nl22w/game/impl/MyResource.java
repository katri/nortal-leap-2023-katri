package com.assignment.nl22w.game.impl;

import org.springframework.core.io.Resource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;

public class MyResource implements Resource {


    private char[][] mapFile;
    public char[][] getMapFile() {
        return mapFile;
    }

    public void setMapFile(char[][] mapFile) {
        this.mapFile = readFile();
    }

    public char[][] readFile() {
        File file = new File("src/main/resources/map1.txt");

        Scanner scanner;
        try {
            scanner = new Scanner(file);
            char[][] map = new char[1000][];
            int i = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                map[i] = line.toCharArray();
                i++;
            }
            scanner.close();

            char[][] newMap = new char[i][];
            for (int j = 0; j < i; j++) {
                newMap[j] = map[j];
            }
            return newMap;

        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public boolean exists() {
        return false;
    }

    @Override
    public URL getURL() throws IOException {
        return null;
    }

    @Override
    public URI getURI() throws IOException {
        return null;
    }

    @Override
    public File getFile() throws IOException {
        return null;
    }

    @Override
    public long contentLength() throws IOException {
        return 0;
    }

    @Override
    public long lastModified() throws IOException {
        return 0;
    }

    @Override
    public Resource createRelative(String relativePath) throws IOException {
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
    public InputStream getInputStream() throws IOException {
        return null;
    }
}






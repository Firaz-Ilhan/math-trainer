package org.trainer.Statistics;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

//currently stats for add sub mul div exp root ordOfOp
public class Statistics {
    private int[][] currentCollection;
     int[][] tempCollection;
    private final String fileName = "stats.txt";

    private Statistics() throws IOException {
        currentCollection = new int[][] {{0,0},{0,0},{0,0},{0,0},{0,0},{0,0}};
        tempCollection = new int[][] {{0,0},{0,0},{0,0},{0,0},{0,0},{0,0}};
        if(!Files.exists(Paths.get(fileName))){
            createInitialStatFile();
        }
    }

    private void createInitialStatFile() throws IOException {
        FileWriter initial = new FileWriter(fileName);
        initial.write("0 0 0 0 0 0 0 0 0 0 0 0");
        initial.close();
    }

    private void collector(String taskType, boolean result) {
        switch (taskType.toLowerCase()){
            case "addition":
                currentCollection[0][0] =+ 1;
                if (result) {
                    currentCollection[0][1] =+ 1;
                }
                break;
            case "subtraction":
                currentCollection[1][0] =+ 1;
                if (result) {
                    currentCollection[1][1] =+ 1;
                }
                break;
            case "multiplication":
                currentCollection[2][0] =+ 1;
                if (result) {
                    currentCollection[2][1] =+ 1;
                }
                break;
            case "division":
                currentCollection[3][0] =+ 1;
                if (result) {
                    currentCollection[3][1] =+ 1;
                }
                break;
            case "exponent":
                currentCollection[4][0] =+ 1;
                if (result) {
                    currentCollection[4][1] =+ 1;
                }
                break;
            case "root":
                currentCollection[5][0] =+ 1;
                if (result) {
                    currentCollection[5][1] =+ 1;
                }
                break;
            case "orderofoperation":
                currentCollection[6][0] =+ 1;
                if (result) {
                    currentCollection[6][1] =+ 1;
                }
                break;
        }
    }

    protected void statCombiner() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String fileContent = reader.readLine();
        reader.close();
        String[] splitFileContent = fileContent.split(" ");
        int counter = 0;
        StringBuilder toWrite = new StringBuilder();
        for (int i = 0; i < currentCollection.length; i++) {
            toWrite.append(tempCollection[i][0] = currentCollection[i][0] + Integer.parseInt(splitFileContent[counter++]));
            toWrite.append(' ');
            toWrite.append(tempCollection[i][1] = currentCollection[i][1] + Integer.parseInt(splitFileContent[counter++]));
            if(i != currentCollection.length - 1) {
                toWrite.append(' ');
            }
            }
        Files.deleteIfExists(Paths.get(fileName));
        statSaver(toWrite.toString());

    }

    protected void statSaver(String statString) throws IOException {
        FileWriter writer = new FileWriter(fileName,false);
        writer.write(statString);
        writer.close();
        tempCollection = new int[][] {{0,0},{0,0},{0,0},{0,0},{0,0},{0,0}};
    }

    protected void statReset() throws IOException {
        Files.deleteIfExists(Paths.get(fileName));
        createInitialStatFile();
    }

}

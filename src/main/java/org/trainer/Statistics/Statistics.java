package org.trainer.Statistics;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;




public class Statistics {
    private int[][] currentCollection;
    private final String fileName = "stats.txt";

    public static void main(String[] args) throws IOException { //test purposes only
        Statistics test = new Statistics();
        System.out.println(Paths.get("stats.txt"));
        test.collector("AddItIon",true);
        test.statCombiner();
    }

    private Statistics() {
        this.currentCollection = new int[][] {{0,0},{0,0},{0,0},{0,0},{0,0},{0,0}};

    }

    private void collector(String taskType, boolean result) {
        switch (taskType.toLowerCase()){
            case "addition":
                currentCollection[0][0] =+ 1;
                if (result) {
                    currentCollection[0][1] =+ 1;
                }
            case "subtraction":
                currentCollection[1][0] =+ 1;
                if (result) {
                    currentCollection[1][1] =+ 1;
                }
            case "multiplication":
                currentCollection[2][0] =+ 1;
                if (result) {
                    currentCollection[2][1] =+ 1;
                }
            case "division":
                currentCollection[3][0] =+ 1;
                if (result) {
                    currentCollection[3][1] =+ 1;
                }
            case "exponent":
                currentCollection[4][0] =+ 1;
                if (result) {
                    currentCollection[4][1] =+ 1;
                }
            case "root":
                currentCollection[5][0] =+ 1;
                if (result) {
                    currentCollection[5][1] =+ 1;
                }
        }
    }

    protected void statCombiner() throws IOException {
        String fileContent = Files.readString(Paths.get(fileName));
        String[] splitFileContent = fileContent.split(" ");
        int counter = -1;
        StringBuilder toWrite = new StringBuilder();
        for (int i = 0; i < currentCollection.length; i++) {
            toWrite.append(currentCollection[i][0] =+ Integer.parseInt(splitFileContent[counter++]));
            toWrite.append(' ');
            toWrite.append(currentCollection[i][1] =+ Integer.parseInt(splitFileContent[counter++]));
            toWrite.append(' ');
            }
        statSaver(toWrite.toString());

    }

    protected void statSaver(String statString) throws IOException {
        FileWriter writer = new FileWriter(fileName,false);
        writer.write(statString);
        writer.close();
    }

    protected void statReset() throws IOException {
        Files.deleteIfExists(Paths.get(fileName));
    }

}

package org.trainer.Statistics;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

//currently stats for add sub mul div exp root ordOfOp
public class Statistics {
    private int[][] currentCollection;
    private int[][] tempCollection;
    private final String fileName = "stats.txt";
    private String tempStats;

    public Statistics() throws IOException {
        currentCollection = new int[][]{{0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}};
        tempCollection = new int[][]{{0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}};
        if (!Files.exists(Paths.get(fileName))) {
            createInitialStatFile();
        }
    }

    private void createInitialStatFile() throws IOException {
        FileWriter initial = new FileWriter(fileName);
        initial.write("0 0 0 0 0 0 0 0 0 0 0 0 0 0");
        initial.close();
    }

    public void collector(String taskType, boolean result) {
        switch (taskType.toLowerCase()) {
            case "addition":
                currentCollection[0][0] += 1;
                if (result) {
                    currentCollection[0][1] += 1;
                }
                break;
            case "subtraction":
                currentCollection[1][0] += 1;
                if (result) {
                    currentCollection[1][1] += 1;
                }
                break;
            case "multiplication":
                currentCollection[2][0] += 1;
                if (result) {
                    currentCollection[2][1] += 1;
                }
                break;
            case "division":
                currentCollection[3][0] += 1;
                if (result) {
                    currentCollection[3][1] += 1;
                }
                break;
            case "exponent":
                currentCollection[4][0] += 1;
                if (result) {
                    currentCollection[4][1] += 1;
                }
                break;
            case "root":
                currentCollection[5][0] += 1;
                if (result) {
                    currentCollection[5][1] += 1;
                }
                break;
            case "orderofoperation":
                currentCollection[6][0] += 1;
                if (result) {
                    currentCollection[6][1] += 1;
                }
                break;
        }
    }

    private void statCombiner() throws IOException {
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
            if (i != currentCollection.length - 1) {
                toWrite.append(' ');
            }
        }
        tempStats = toWrite.toString();
    }

    public void statSaver() throws IOException { //careful! this deletes the Session Stats. should be called upon ending program?
        statCombiner();
        Files.deleteIfExists(Paths.get(fileName));
        FileWriter writer = new FileWriter(fileName, false);
        writer.write(tempStats);
        writer.close();
        tempCollection = new int[][]{{0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}};
        currentCollection = new int[][]{{0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}};
    }

    private void statReset() throws IOException {
        Files.deleteIfExists(Paths.get(fileName));
        createInitialStatFile();
    }

    private int percentStat(int[][] arr, int pos) {
        if (arr[pos][0] != 0) {
            float percent = ((float) arr[pos][1] / (float) arr[pos][0]) * 100;
            return Math.round(percent);
        } else {
            return 0;
        }
    }

    public String getStats(boolean lifetime) throws IOException {
        int[][] array;
        String whatStats;
        if (lifetime) {
            statCombiner();
            array = tempCollection;
            whatStats = "Lifetime Stats:";
        } else {
            array = currentCollection;
            whatStats = "Current Stats:";
        }

        return whatStats + "\n" +
                "Addition: " + percentStat(array, 0) + "% von " + array[0][0] + "\n" +
                "Subtraction: " + percentStat(array, 1) + "% von " + array[1][0] + "\n" +
                "Multiplication: " + percentStat(array, 2) + "% von " + array[2][0] + "\n" +
                "Division: " + percentStat(array, 3) + "% von " + array[3][0] + "\n" +
                "Exponent: " + percentStat(array, 4) + "% von " + array[4][0] + "\n" +
                "Root: " + percentStat(array, 5) + "% von " + array[5][0] + "\n" +
                "OrderOfOperation: " + percentStat(array, 6) + "% von " + array[6][0];
    }
}

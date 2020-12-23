package org.trainer.statistics;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.trainer.exceptions.IllegalFactoryArgument;
import org.trainer.model.Arithmetic;
import org.trainer.model.Factory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

//currently stats for add sub mul div exp root ordOfOp
public class Statistics {
    private int[][] currentCollection;
    private int[][] tempCollection;
    private final String fileName = "stats.txt";
    private String tempStats;
    private final Logger log = LogManager.getLogger(Statistics.class);

    //for testing
    public static void main(String[] args) throws IllegalFactoryArgument {
        Statistics statCollector = new Statistics();
        Factory f1 = new Factory();
        Scanner scanner = new Scanner(System.in);

        Arithmetic task0 = f1.getArithmetic("addition", "beginner");
        System.out.println(task0.getRenderedTask(task0.getTask()));
        int userInput0 = scanner.nextInt();
        statCollector.collector("addition", task0.checkSolution(task0.getTask(), userInput0));

        Arithmetic task1 = f1.getArithmetic("addition", "beginner");
        System.out.println(task1.getRenderedTask(task1.getTask()));
        int userInput1 = scanner.nextInt();
        statCollector.collector("addition", task1.checkSolution(task1.getTask(), userInput1));
        statCollector.statSaver();
    }

    /**
     * Constructor with creation of the necessary initial forms for file and array.
     */
    public Statistics() {
        currentCollection = new int[][]{{0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}};
        tempCollection = new int[][]{{0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}};
        if (!Files.exists(Paths.get(fileName))) {
            createInitialStatFile();
        }
    }

    /**
     * This method creates the initial File with a set form to match the arrays.
     */
    private void createInitialStatFile() {
        try (FileWriter initial = new FileWriter(fileName)) {
            initial.write("0 0 0 0 0 0 0 0 0 0 0 0 0 0");
            log.info("Creating the default stat file");
        } catch (IOException e1) {
            log.error(e1.toString());
            e1.printStackTrace();
        }
    }

    /**
     * The collector collects information on the solved state after each task.
     * @param taskType String with information of the Type.
     * @param result boolean for solved successfully.
     */
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
        if (result) {
            log.info("Adding a correct answer to statistics\n");
        } else {
            log.info("Adding an incorrect answer to the statistics\n");
        }
    }

    /**
     * Method to give testing information about the current stats.
     * @return giving back the array.
     */
    public int[][] getCurrentCollection() {
        return currentCollection;
    }

    /**
     * The Combiner combines the current stats with the saved stats from the stat file stats.txt.
     */
    private void statCombiner() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String fileContent = reader.readLine();
            reader.close();
            log.info("Current stats: " + fileContent);
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
            log.info("Saved stats:   " + tempStats);
        } catch (IOException e1) {
            log.error(e1.toString());
            e1.printStackTrace();
        }
    }

    /**
     * Saves stats to the stats.txt file and deletes current stats.
     * Calls the {@link #statCombiner}.
     */
    public void statSaver() {
        statCombiner();
        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.write(tempStats);
        } catch (IOException e1) {
            log.error(e1.toString());
            e1.printStackTrace();
        }
        log.info("Saving the current stats to lifetime stats");
        tempCollection = new int[][]{{0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}};
        currentCollection = new int[][]{{0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}};
    }

    /**
     * Deletes the saved stats and creates a new initial File.
     */
    public void statReset() {
        log.info("Resetting the stats");
        createInitialStatFile();
    }

    /**
     * Calculates the percentage of correct answered tasks.
     * @param arr is the array input gathered from the stat file.
     * @param pos is the position of the task type to be calculated.
     * @return returns the rounded percentage.
     */
    public int percentStat(int[][] arr, int pos) {
        if (arr[pos][0] != 0) {
            float percent = ((float) arr[pos][1] / (float) arr[pos][0]) * 100;
            return Math.round(percent);
        } else {
            return 0;
        }
    }

    /**
     * Generates a percentage array to be displayed in the GUI.
     * Calls {@link #percentStat(int[][], int)}.
     * @param lifetime boolean to decide if u want lifetime stats or just current.
     * @return returns an int array containing the percent of solved tasks per type.
     */
    public int[] getPercentStats(boolean lifetime) {

        int[][] array;
        int[] stats = new int[7];
        if (lifetime) {
            statCombiner();
            array = tempCollection;
        } else {
            array = currentCollection;
        }
        for (int position = 0; position < currentCollection.length; position++) {
            stats[position] = percentStat(array, position);
        }
        return stats;
    }

    /**
     * Generates a String showing the stats of lifetime or current stats.
     * @param lifetime decides whether it is all or current stats.
     * @return returns the String.
     */
    public String getStats(boolean lifetime) { //currently only in Main, if not needed delete method
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

        String displayStats = whatStats + "\n" +
                "Addition: " + percentStat(array, 0) + "% von " + array[0][0] + "\n" +
                "Subtraction: " + percentStat(array, 1) + "% von " + array[1][0] + "\n" +
                "Multiplication: " + percentStat(array, 2) + "% von " + array[2][0] + "\n" +
                "Division: " + percentStat(array, 3) + "% von " + array[3][0] + "\n" +
                "Exponent: " + percentStat(array, 4) + "% von " + array[4][0] + "\n" +
                "Root: " + percentStat(array, 5) + "% von " + array[5][0] + "\n" +
                "OrderOfOperation: " + percentStat(array, 6) + "% von " + array[6][0];
        log.info(displayStats);
        return displayStats;
    }
}
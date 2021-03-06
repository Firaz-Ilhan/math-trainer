package org.trainer.statistics;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

//currently stats for add sub mul div exp root orderOfOperation
public class Statistics {
    private final String[] operations = {"Addition", "Subtraction", "Multiplication", "Division", "Exponent", "Root", "Order of Operation"};
    private static final Logger log = LogManager.getLogger(Statistics.class);
    private final String fileName = "stats.txt";
    private int[][] currentCollection;
    private int[][] tempCollection;
    private String tempStats;

    /**
     * Constructor with creation of the necessary initial forms for file and array.
     */
    public Statistics() throws IOException { //Constructor sets everything up needed for Statistics
        createInitialStatArrays();
        if (!Files.exists(Paths.get(fileName))) {
            createInitialStatFile();
        }
    }

    /**
     * This method creates the initial Arrays with operations.length-1
     */
    private void createInitialStatArrays() {
        currentCollection = new int[operations.length][2];  //setting the total task and successful completed tasks
        tempCollection = new int[operations.length][2];     //to 0 for all TaskTypes in operations
        for (int i = 0; i < operations.length; i++) {
            currentCollection[i][0] = 0;
            currentCollection[i][1] = 0;
            tempCollection[i][0] = 0;
            tempCollection[i][1] = 0;
        }
    }

    /**
     * This method creates the initial File with a set form to match the arrays.
     */
    private void createInitialStatFile() throws IOException {
        final FileWriter initial = new FileWriter(fileName, false);
        final StringBuilder initialString = new StringBuilder();
        Stream<String> operationsStream = Stream.of(operations);

        operationsStream //Stream to check how many Actual taskTypes there are in "operations" Array
                .filter(Objects::nonNull)
                .filter(Predicate.not(String::isEmpty))
                .forEach(i -> initialString.append("0 0 ")); //writing the String

        initial.write(initialString.toString());
        initial.close(); //closing the FileWriter
        log.info("Creating the default stat file");
    }

    /**
     * The collector collects information on the solved state after each task is answered.
     *
     * @param taskType String with information of the Type.
     * @param result   boolean for solved successfully.
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
            log.info("Adding a correct answer for " + taskType + ".\n");
        } else {
            log.info("Adding an incorrect answer for " + taskType + ".\n");
        }
    }

    /**
     * Method to give testing information about the current stats.
     *
     * @return giving back the array.
     */
    public int[][] getCurrentCollection() { //returning a copy to make sure the user doesnt get anything of the Original.
        return currentCollection.clone();
    }

    /**
     * Method to give testing information about the temp stats.
     *
     * @return giving back the array.
     */
    public int[][] getTempCollection() { //returning a copy to make sure the user doesnt get anything of the Original.
        return tempCollection.clone();
    }

    /**
     * Method to give testing information about the temp stats.
     *
     * @return giving back the array.
     */
    public String[] getOperationsArray() { //returning a copy to make sure the user doesnt get anything of the Original.
        return operations.clone();
    }

    /**
     * The Combiner combines the current stats with the saved stats from the stat file stats.txt.
     */
    private void statCombiner() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName, StandardCharsets.UTF_8))) {
            String fileContent = reader.readLine();
            reader.close();
            log.info("Current stats: {}", fileContent);
            final String[] splitFileContent = fileContent.split(" "); //splitting stats.txt in the single numbers
            int counter = 0;
            final StringBuilder toWrite = new StringBuilder();
            for (int i = 0; i < currentCollection.length; i++) { //building the new String
                toWrite.append(tempCollection[i][0] = currentCollection[i][0] + Integer.parseInt(splitFileContent[counter++])); //getting the total task information
                toWrite.append(' ');
                toWrite.append(tempCollection[i][1] = currentCollection[i][1] + Integer.parseInt(splitFileContent[counter++])); //getting the successful finished task information
                if (i != currentCollection.length - 1) {
                    toWrite.append(' ');
                }
            }
            tempStats = toWrite.toString();
            log.info("Saved stats:   {}", tempStats);
        } catch (IOException e) {
            log.error(e.toString());
            e.printStackTrace();
        }
    }

    /**
     * Saves stats to the stats.txt file and deletes current stats.
     * Calls the {@link #statCombiner}.
     */
    public void statSaver() throws IOException {
        statCombiner();
        FileWriter writer = new FileWriter(fileName, false);
        writer.write(tempStats); //saving the String set in statCombiner()
        writer.close();
        log.info("Saving the current stats to lifetime stats");
        tempCollection = new int[][]{{0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}}; //resetting the Arrays
        currentCollection = new int[][]{{0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}};
    }

    /**
     * Deletes the saved stats and creates a new initial File.
     */
    public void statReset() throws IOException {
        log.info("Resetting the stats");
        createInitialStatFile(); //forcing the function to be called to overwrite the current stats.txt
    }

    /**
     * Calculates the percentage of correct answered tasks.
     *
     * @param arr is the array input gathered from the stat file.
     * @param pos is the position of the task type to be calculated.
     * @return returns the rounded percentage.
     */
    public int percentStat(int[][] arr, int pos) {
        if (arr[pos][0] == 0) {
            return 100; //base stat is 100% out of 0 calculations solved correctly
        } else {
            float percent = (arr[pos][1] / (float) arr[pos][0]) * 100.0F; //float allows work with decimal stats
            return Math.round(percent);
        }
    }

    /**
     * Generates a percentage array to be displayed in the GUI.
     * Calls {@link #percentStat(int[][], int)}.
     *
     * @return returns an int array containing the percent of solved tasks per type.
     */
    public int[] getPercentStats() {
        int[][] array;
        int[] percentStats = new int[7];
        statCombiner(); //making sure the stats are up toDate
        array = tempCollection;
        for (int position = 0; position < currentCollection.length; position++) {
            percentStats[position] = percentStat(array, position);
        }
        return percentStats.clone();
    }

    /**
     * Generates a String showing the stats of lifetime or current stats.
     *
     * @param lifetime decides whether it is all or current stats.
     * @return returns the String.
     */
    public String getStats(boolean lifetime) { //lifetime is a feature that may be implemented in the future
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

        StringBuilder displayStats = new StringBuilder();
        displayStats.append(whatStats).append("\n");
        for (int i = 0; i < operations.length; i++) { //a for loop to write out stats for every TaskType in operations
            displayStats.append(operations[i]).append(": ").append(percentStat(array, i)).append("% out of ").append(array[i][0]).append(" tasks");
            if (i != operations.length - 1) {
                displayStats.append("\n");
            }
        }
        log.info(displayStats.toString());
        return displayStats.toString();
    }

}


package org.trainer.Statistics;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/**
 * Statistics gonna look like:
 * X =  tasks totally done
 * Y =  tasks solved correctly
 * X Y      X Y         X Y             X Y         X Y         X Y
 * Addition Subtraction Multiplication  Division    Exponent    Root
 */

public class Statistics {
    int[][] currentCollection;

    private Statistics() {
        this.currentCollection = new int[][] {{0,0},{0,0},{0,0},{0,0},{0,0},{0,0}};
        // if file does not exist create file with currentCollection als basic
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
        try(FileReader reader = new FileReader("/idk/idk/idk.txt")){
            //reader
            //String fileContent =
            //String[] splitFileContent = fileContent.split(' ')
            int counter = -1;
            for (int i = 0; i < currentCollection.length; i++) {
                currentCollection[i][0] =+ Integer.parseInt(splitFileContent[counter++]);
                currentCollection[i][1] =+ Integer.parseInt(splitFileContent[counter++]);
            }
            statSaver(currentCollection);
        } catch (FileNotFoundException e) {
            //create File
        }

    }

    protected void statSaver(int[][] statsToSave){
        //delete old file
        //write new file
    }

    protected void statReset(){
        //delete file
    }

}

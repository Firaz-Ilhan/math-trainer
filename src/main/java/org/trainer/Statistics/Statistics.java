package org.trainer.Statistics;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;

public class Statistics {
    ArrayList<String> currentTaskCollection;
    ArrayList<Boolean> currentResultCollection;

    private Statistics() {
        this.currentTaskCollection = new ArrayList<>();
        this.currentResultCollection = new ArrayList<>();
    }

    private void collector(String taskType, boolean result) {
        currentTaskCollection.add(taskType);
        currentResultCollection.add(result);
    }

    protected void statCombiner(){
        //reader
        //add current Collections
        //call statSaver
        statSaver();
    }

    protected void statSaver(){

    }
}

package org.trainer.streams;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WrongAnswer {

    private static final Logger log = LogManager.getLogger(WrongAnswer.class);
    private static final List<String> wrongAnswers = new ArrayList<>();
    public List<String> listAddi = new ArrayList<>();
    public List<String> listSubt = new ArrayList<>();
    public List<String> listMulti = new ArrayList<>();
    public List<String> listDivi = new ArrayList<>();
    public List<String> listExpo2 = new ArrayList<>();
    public List<String> listExpo3 = new ArrayList<>();
    public List<String> listRoot2 = new ArrayList<>();
    public List<String> listRoot3 = new ArrayList<>();
    public List<String> listOrder = new ArrayList<>();

    /**
     * adds the tasks that the user answered incorrectly to the list
     *
     * @param task      the task
     * @param solution  the solution
     * @param userInput the wrong answer from the user
     */
    public void addWrongAnswer(String task, String solution, String userInput) throws IOException {
        wrongAnswers.add(task + "=" + solution + " not " + userInput);
        log.info("Add wrong answer to list");
    }

    /**
     * sorts the wrong answers to the asked exercise categories
     */
    public void sortWrongAnswers() {
        listAddi = wrongAnswers.stream()
                .filter(line -> line.contains("+") && !line.contains("*"))
                .collect(Collectors.toList());
        listSubt = wrongAnswers.stream()
                .parallel()
                .filter(line -> line.contains("-"))
                .collect(Collectors.toList());
        listMulti = wrongAnswers.stream()
                .parallel()
                .filter(line -> line.contains("*") && !line.contains("+"))
                .collect(Collectors.toList());
        listDivi = wrongAnswers.stream()
                .parallel()
                .filter(line -> line.contains("/"))
                .collect(Collectors.toList());
        listExpo2 = wrongAnswers.stream()
                .parallel()
                .filter(line -> line.contains("²"))
                .collect(Collectors.toList());
        listExpo3 = wrongAnswers.stream()
                .parallel()
                .filter(line -> line.contains("³"))
                .collect(Collectors.toList());
        listRoot2 = wrongAnswers.stream()
                .parallel()
                .filter(line -> line.contains("²√"))
                .collect(Collectors.toList());
        listRoot3 = wrongAnswers.stream()
                .parallel()
                .filter(line -> line.contains("³√"))
                .collect(Collectors.toList());
        listOrder = wrongAnswers.stream()
                .parallel()
                .filter(line -> line.contains("+") && line.contains("*"))
                .collect(Collectors.toList());
    }

    /**
     * merges the entries from the lists, one below the other
     *
     * @param list the lists with the wrong answers of the different exercise categories
     * @return the strings of the tasks with the wrong answers
     */
    public String listToString(List<String> list) {
        StringBuilder listString = new StringBuilder();
        for (String s : list) {
            listString.append(s).append("\n");
        }
        return listString.toString();
    }
}



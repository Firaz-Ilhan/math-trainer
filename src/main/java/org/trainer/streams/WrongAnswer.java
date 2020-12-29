package org.trainer.streams;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WrongAnswer {

    private final String fileName = "WrongAnswers.txt";
    private static final Logger log = LogManager.getLogger(WrongAnswer.class);
    public List<String> listAddi = new ArrayList<>();
    public List<String> listMinus = new ArrayList<>();
    public List<String> listMulti = new ArrayList<>();
    public List<String> listDivi = new ArrayList<>();
    public List<String> listExpo2 = new ArrayList<>();
    public List<String> listExpo3 = new ArrayList<>();
    public List<String> listRoot2 = new ArrayList<>();
    public List<String> listRoot3 = new ArrayList<>();
    public List<String> listOrder = new ArrayList<>();

    /**
     * adds the tasks that the user answered incorrectly to the file WrongAnswers.txt
     *
     * @param task the task
     * @param solution the solution
     * @param userInput the wrong answer from the user
     */
    public void addWrongAnswer(String task, String solution, String userInput) {
        try {
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName, StandardCharsets.UTF_8, true)));
            writer.println(task + "=" + solution + " not " + userInput);
            writer.flush();
            writer.close();
            log.info("Writing wrong answer to file " + fileName);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * sorts the wrong answers to the asked exercise categories
     */
    public void sortWrongAnswers() {
        File file = new File(fileName);
        if (file.exists()) {
            try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
                listAddi = stream
                        .filter(line -> line.contains("+"))
                        .filter(line -> !line.contains("*"))
                        .collect(Collectors.toList());
                Stream<String> stream1 = Files.lines(Paths.get(fileName));
                listMinus = stream1
                        .parallel()
                        .filter(line -> line.contains("-"))
                        .collect(Collectors.toList());
                Stream<String> stream2 = Files.lines(Paths.get(fileName));
                listMulti = stream2
                        .parallel()
                        .filter(line -> line.contains("*"))
                        .filter(line -> !line.contains("+"))
                        .collect(Collectors.toList());
                Stream<String> stream3 = Files.lines(Paths.get(fileName));
                listDivi = stream3
                        .parallel()
                        .filter(line -> line.contains("/"))
                        .collect(Collectors.toList());
                Stream<String> stream4 = Files.lines(Paths.get(fileName));
                listExpo2 = stream4
                        .parallel()
                        .filter(line -> line.contains("²"))
                        .collect(Collectors.toList());
                Stream<String> stream5 = Files.lines(Paths.get(fileName));
                listExpo3 = stream5
                        .parallel()
                        .filter(line -> line.contains("³"))
                        .collect(Collectors.toList());
                Stream<String> stream6 = Files.lines(Paths.get(fileName));
                listRoot2 = stream6
                        .parallel()
                        .filter(line -> line.contains("²√"))
                        .collect(Collectors.toList());
                Stream<String> stream7 = Files.lines(Paths.get(fileName));
                listRoot3 = stream7
                        .parallel()
                        .filter(line -> line.contains("³√"))
                        .collect(Collectors.toList());
                Stream<String> stream8 = Files.lines(Paths.get(fileName));
                listOrder = stream8
                        .parallel()
                        .filter(line -> line.contains("+"))
                        .filter(line -> line.contains("*"))
                        .collect(Collectors.toList());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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



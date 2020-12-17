package org.trainer;

import org.junit.Assert;
import org.junit.Test;
import org.trainer.Exercise.Arithmetic;
import org.trainer.Exercise.Factory;
import org.trainer.Statistics.Statistics;
import org.trainer.exceptions.IllegalFactoryArgument;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class StatisticsTest {

    //no clue

    @Test
    public void test_lifetime_stats() throws IOException {
        Statistics statCollector = new Statistics();
        int[][] testCollection  = new int[][]{{0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}};
        BufferedReader reader0 = new BufferedReader(new FileReader("stats.txt"));
        String fileReset = reader0.readLine();
        reader0.close();

        statCollector.collector("addition", true);
        statCollector.collector("addition", false);
        statCollector.statSaver();

        BufferedReader reader1 = new BufferedReader(new FileReader("stats.txt"));
        String actual = reader1.readLine();
        reader1.close();
        String[] splitFileContent = actual.split(" ");
        int counter = 0;
        StringBuilder toWrite = new StringBuilder();
        for (int i = 0; i < splitFileContent.length/2; i++) {
            toWrite.append(testCollection[i][0] += Integer.parseInt(splitFileContent[counter++]));
            toWrite.append(' ');
            toWrite.append(testCollection[i][1] += Integer.parseInt(splitFileContent[counter++]));
            if (i != (splitFileContent.length/2) - 1) {
                toWrite.append(' ');
            }
        }
        String expected = toWrite.toString();
        Assert.assertEquals(expected, actual);

        FileWriter testWriter = new FileWriter("stats.txt", false);
        testWriter.write(fileReset);
        testWriter.close();
    }

    @Test
    public void test_current_stats(){
        Statistics statCollector = new Statistics();
        int[][] testCurrentCollection = new int[][]{{2, 1}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}};
        statCollector.collector("addition", true);
        statCollector.collector("addition", false);
        Assert.assertArrayEquals(statCollector.getCurrentCollection(),testCurrentCollection);

    }

    @Test
    public void test_percentStat(){
        Statistics statsPercent = new Statistics();
        int[][] arr = new int[][]{{2,1},{1,1},{3,1},{3,2}};
        Assert.assertEquals(50,statsPercent.percentStat(arr,0));
        Assert.assertEquals(100,statsPercent.percentStat(arr,1));
        Assert.assertEquals(33,statsPercent.percentStat(arr,2));
        Assert.assertEquals(67,statsPercent.percentStat(arr,3));
    }
}

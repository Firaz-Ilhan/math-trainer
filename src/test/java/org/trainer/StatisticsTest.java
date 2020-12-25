package org.trainer;

import org.junit.Assert;
import org.junit.Test;
import org.trainer.statistics.Statistics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StatisticsTest {

    @Test
    public void test_lifetime_stats() throws IOException {
        Statistics statCollector = new Statistics();
        int[][] testCollection = new int[][]{{0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}};
        BufferedReader reader0 = new BufferedReader(new FileReader("stats.txt"));
        String fileReset = reader0.readLine();
        reader0.close();

        statCollector.collector("addition", true);
        statCollector.collector("addition", false);
        statCollector.statSaver();

        //creating the desired outcome based on what is already in the stat file.
        BufferedReader reader1 = new BufferedReader(new FileReader("stats.txt"));
        String actual = reader1.readLine();
        reader1.close();
        String[] splitFileContent = actual.split(" ");
        int counter = 0;
        StringBuilder toWrite = new StringBuilder();
        for (int i = 0; i < splitFileContent.length / 2; i++) {
            toWrite.append(testCollection[i][0] += Integer.parseInt(splitFileContent[counter++]));
            toWrite.append(' ');
            toWrite.append(testCollection[i][1] += Integer.parseInt(splitFileContent[counter++]));
            if (i != (splitFileContent.length / 2) - 1) {
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
    public void test_current_stats() {
        Statistics statCollector = new Statistics();
        int[][] testCurrentCollection = new int[][]{{2, 1}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}};
        statCollector.collector("addition", true);
        statCollector.collector("addition", false);
        Assert.assertArrayEquals(statCollector.getCurrentCollection(), testCurrentCollection);

    }

    @Test
    public void test_percentStat() {
        Statistics statsPercent = new Statistics();
        int[][] arr = new int[][]{{2, 1}, {1, 1}, {3, 1}, {3, 2}};
        Assert.assertEquals(50, statsPercent.percentStat(arr, 0));
        Assert.assertEquals(100, statsPercent.percentStat(arr, 1));
        Assert.assertEquals(33, statsPercent.percentStat(arr, 2));
        Assert.assertEquals(67, statsPercent.percentStat(arr, 3));
    }

    @Test
    public void test_statReset() throws IOException {
        BufferedReader reader0 = new BufferedReader(new FileReader("stats.txt"));
        String fileReset = reader0.readLine();
        reader0.close();
        Statistics statCollector = new Statistics();

        statCollector.collector("addition", true);
        statCollector.statSaver();
        statCollector.statReset();
        String expected = "0 0 0 0 0 0 0 0 0 0 0 0 0 0";
        BufferedReader reader1 = new BufferedReader(new FileReader("stats.txt"));
        String actual = reader1.readLine();
        reader1.close();
        Assert.assertEquals(expected, actual);

        FileWriter testWriter1 = new FileWriter("stats.txt", false);
        testWriter1.write(fileReset);
        testWriter1.close();
    }
}

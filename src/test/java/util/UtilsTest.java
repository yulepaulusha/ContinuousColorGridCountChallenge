package util;

import exceptions.GridNotFoundException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Yule.Paulusha on 7/9/2022.
 */
public class UtilsTest {
    @Test
    public void analyzeColorGridTest1() {
        String[][] grid = {
                {"red", "blue", "yellow", "purple", "red"},
                {"red", "pink", "orange", "purple", "red"},
                {"red", "red", "red", "red", "red"}
        };

        Set<String> expectedOutput = new HashSet<>(Arrays.asList("red"));
        Assert.assertEquals(Utils.analyzeColorGrid(grid), expectedOutput);
    }

    @Test
    public void analyzeColorGridTest2() {
        String[][] grid = {
                {"red", "blue", "red"}
        };

        Set<String> expectedOutput = new HashSet<>(Arrays.asList("red", "blue"));
        Assert.assertEquals(Utils.analyzeColorGrid(grid), expectedOutput);
    }

    @Test
    public void analyzeColorGridTest3() {
        String[][] grid = {
                {"red", "red", "red"},
                {"red", "blue", "red"}
        };

        Set<String> expectedOutput = new HashSet<>(Arrays.asList("red"));
        Assert.assertEquals(Utils.analyzeColorGrid(grid), expectedOutput);
    }

    @Test(expected = GridNotFoundException.class)
    public void analyzeColorGridTestEmptyGrid() {
        String[][] grid = {};
        Utils.analyzeColorGrid(grid);
    }

    @Test(expected = GridNotFoundException.class)
    public void analyzeColorGridTestNullGrid() {
        String[][] grid = {};
        Utils.analyzeColorGrid(grid);
    }
}

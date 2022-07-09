package util;

import exceptions.GridNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Yule.Paulusha on 7/9/2022.
 */
public class Utils {

    private static Logger logger = LoggerFactory.getLogger(Utils.class);

    /**
     * analyzeColorGrid
     * shows continuous color grid color and number of blocks consist.
     * if more than one color found as maximum blocks, it will show all colors.
     *
     * @throws GridNotFoundException when supplied grid is empty or null.
     */
    public static Set<String> analyzeColorGrid(String[][] grid) {
        int numberOfRows;
        int numberOfColumns;
        try {
            numberOfRows = grid.length;
            numberOfColumns = grid[0].length;
        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
            logger.error("The provided grid either null or either empty. {}", e.getMessage());
            throw new GridNotFoundException("The provided grid either null or either empty.");
        }
        List<Set<String>> gridIndexList = new ArrayList<>();
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                Set<String> gridIndex = new HashSet<>();
                String keyIndex = Integer.toString(i) + Integer.toString(j);
                if (!isAlreadyChecked(gridIndexList, keyIndex)) {
                    traverseGrid(grid, numberOfRows, numberOfColumns, i, j, gridIndex);
                } else {
                    continue;
                }
                gridIndexList.add(gridIndex);
            }
        }

        int maxSetSize = 0;
        //there can be multiple colors with same block size
        maxSetSize = getMaxSetSize(gridIndexList, maxSetSize);
        Set<String> colours = new HashSet<>();
        for (Set<String> set : gridIndexList) {
            if (set.size() == maxSetSize) {
                String color = grid[Character.getNumericValue(set.iterator().next().charAt(0))][Character.getNumericValue(set.iterator().next().charAt(1))];
                boolean add = colours.add(color);
                if (add) {
                    logger.info("Largest continuous color grid found. Color: {}", color);
                    logger.info("Number of blocks found: {}", maxSetSize);
                }
            }
        }
        logger.info("Largest continuous color/s: {}", colours);
        return colours;
    }

    private static int getMaxSetSize(List<Set<String>> list, int maxSetSize) {
        for (Set<String> set : list) {
            if (maxSetSize < set.size()) {
                maxSetSize = set.size();
            }
        }
        return maxSetSize;
    }

    private static boolean isAlreadyChecked(List<Set<String>> list, String key) {
        return list.stream().anyMatch(set -> set.contains(key));
    }

    private static void traverseGrid(String[][] grid, int numberOfRows, int numberOfColumns, int i, int j, Set<String> gridIndexSet) {
        gridIndexSet.add(Integer.toString(i) + Integer.toString(j));
        traverseUp(grid, numberOfRows, numberOfColumns, i, j, gridIndexSet);
        traverseLeft(grid, numberOfRows, numberOfColumns, i, j, gridIndexSet);
        traverseRight(grid, numberOfRows, numberOfColumns, i, j, gridIndexSet);
        traverseDown(grid, numberOfRows, numberOfColumns, i, j, gridIndexSet);
    }

    private static void traverseDown(String[][] grid, int numberOfRows, int numberOfColumns, int i, int j, Set<String> set) {
        int xIndex = i + 1;
        if (
                xIndex < numberOfRows &&
                        grid[i][j].equals(grid[xIndex][j]) &&
                        !set.contains(Integer.toString(xIndex) + Integer.toString(j))

                ) {
            traverseGrid(grid, numberOfRows, numberOfColumns, xIndex, j, set);
        }
    }

    private static void traverseRight(String[][] grid, int numberOfRows, int numberOfColumns, int i, int j, Set<String> set) {
        int yIndex = j + 1;
        if (
                j + 1 < numberOfColumns &&
                        grid[i][j].equals(grid[i][yIndex]) &&
                        !set.contains(Integer.toString(i) + Integer.toString(yIndex))
                ) {
            traverseGrid(grid, numberOfRows, numberOfColumns, i, yIndex, set);
        }
    }

    private static void traverseLeft(String[][] grid, int numberOfRows, int numberOfColumns, int i, int j, Set<String> set) {
        int yIndex = j - 1;
        if (
                yIndex >= 0 &&
                        grid[i][j].equals(grid[i][yIndex]) &&
                        !set.contains(Integer.toString(i) + Integer.toString(yIndex))
                ) {
            traverseGrid(grid, numberOfRows, numberOfColumns, i, yIndex, set);
        }
    }

    private static void traverseUp(String[][] grid, int numberOfRows, int numberOfColumns, int i, int j, Set<String> set) {
        int xIndex = i - 1;
        if (
                xIndex >= 0 &&
                        (grid[i][j].equals(grid[xIndex][j])) &&
                        (!set.contains(Integer.toString(xIndex) + Integer.toString(j)))
                ) {
            traverseGrid(grid, numberOfRows, numberOfColumns, xIndex, j, set);
        }
    }
}

import java.util.Set;

import static util.Utils.analyzeColorGrid;

/**
 * Created by Yule.Paulusha on 7/9/2022.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Start the grid challenge.");
        String[][] grid = {
                {"red", "red", "yellow", "yellow", "red"},
                {"red", "red", "yellow", "blue", "red"},
                {"red", "red", "red", "red", "red"}
        };
        Set<String> colors = analyzeColorGrid(grid);
        System.out.println("Largest continuous color/s: " + colors);
    }
}

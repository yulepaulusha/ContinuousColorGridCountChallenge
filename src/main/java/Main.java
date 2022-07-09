/**
 * Created by Yule.Paulusha on 7/9/2022.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Start grid challenge.");
        String[][] grid = {
                {"1", "2", "3", "4", "5"},
                {"6", "7", "8", "9", "10"},
                {"11", "12", "13", "14", "15"}
        };
        int numberOfRows;
        int numberOfColumns;
        try {
            numberOfRows = grid.length;
            numberOfColumns = grid[0].length;
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException("null/empty grid");
        }
        for (int i =0; i < numberOfRows; i++) {
            for (int j =0; j<numberOfColumns; j++) {
                System.out.print(grid[i][j] + " ");
            }
        }
    }
}

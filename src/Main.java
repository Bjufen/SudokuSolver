import logic.Cell;
import logic.Grid;
import logic.Region;

public class Main {

    public static void main(String[] args) {


        int[] values0 = {
                0, 2, 0, 0, 0, 0, 5, 0, 8,
                9, 0, 5, 6, 0, 0, 3, 0, 2,
                0, 8, 0, 2, 0, 0, 0, 0, 7,
                0, 0, 0, 0, 7, 9, 6, 8, 5,
                5, 9, 8, 1, 0, 2, 7, 0, 0,
                0, 6, 4, 0, 0, 0, 2, 1, 0,
                0, 0, 1, 3, 4, 5, 0, 0, 0,
                0, 0, 9, 0, 0, 6, 8, 5, 1,
                0, 0, 0, 0, 9, 1, 0, 0, 3};

        int[][] board0 = new int[9][9];
        int index = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board0[i][j] = values0[index];
                index++;
            }
        }
        Grid grid = new Grid(board0);


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(grid.getGrid()[i][j].getValue() + " ");
            }
            System.out.println();
        }


        System.out.println(grid.getGrid()[1][1].getPossibleValues());
        System.out.println(grid.getGrid()[0][0].getBlock().getRemainingValues());
        int i = 1;
        for (Region region : grid.getRows()) {
            System.out.println("Row " + i++ + ": ");
            for (Cell cell : region.getValues()) {
                System.out.print(cell.getValue() + " ");
            }
            System.out.println();

        }
        i = 1;
        for (Region region : grid.getCols()) {
            System.out.println("Column " + i++ + ": ");
            for (Cell cell : region.getValues()) {
                System.out.print(cell.getValue() + " ");
            }
            System.out.println();

        }
        i = 1;
        for (Region region : grid.getBlocks()) {
            System.out.println("Block " + i++ + ": ");
            for (Cell cell : region.getValues()) {
                System.out.print(cell.getValue() + " ");
            }
            System.out.println();
        }

        for (int row = 0; row < 9; row++){
            for (int col = 0; col < 9; col++) {
                System.out.println("Row: " + row + " Col: " + col);
                System.out.println(grid.getGrid()[row][col].getPossibleValues());
                System.out.println();
            }
        }
    }
}




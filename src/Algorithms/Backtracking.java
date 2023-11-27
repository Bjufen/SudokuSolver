package Algorithms;

import logic.Cell;
import logic.Grid;
import logic.Region;

import java.util.List;


public class Backtracking {
    static Grid result;
    public static Grid init(int[][] initBoard){
        return new Grid(initBoard);
    }

    public static boolean isSafe(Grid grid, int row, int col, int num) {
        // Check if 'num' is not already placed in current row,
        // current column and current 3x3 box
        return !usedInRow(grid, row, num) &&
                !usedInCol(grid, col, num) &&
                !usedInBlock(grid, (row / 3) * 3 + col / 3, num);
    }

    public static boolean usedInRow(Grid grid, int row, int num) {
        // Check if 'num' is already placed in current row
        return !grid.getRows()[row].getRemainingValues().contains(num);
    }

    public static boolean usedInCol(Grid grid, int col, int num) {
        // Check if 'num' is already placed in current column
        return !grid.getCols()[col].getRemainingValues().contains(num);
    }

    public static boolean usedInBlock(Grid grid, int block, int num) {
        // Check if 'num' is already placed in current 3x3 box
        return !grid.getBlocks()[block].getRemainingValues().contains(num);
    }

    public static boolean solve(Grid grid){
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++) {
                if (grid.getGrid()[i][j].getValue() == 0) {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }
        // No empty space left
        if (isEmpty) {
            return true;
        }

        // Else for each-row backtrack
        List<Integer> possibleValues = grid.getGrid()[row][col].getPossibleValues();
        for (int num : possibleValues){
            Grid copy = grid.createcopyGrid();
            copy.getGrid()[row][col].setValue(num);
            result = new Grid(copy.intValues());
            if (solve(copy.createcopyGrid())) {
                return true;
            }
        }
        return false;
    }

    public static void print(Grid grid){
        for (int row = 0; row < 9; row++){
            for (int col = 0; col < 9; col++) {
                System.out.print(grid.getGrid()[row][col].getValue() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[][] board1 = {
                { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
        };

        Grid grid = init(board1);

        if (solve(grid)) {
            print(result);
        }
        else {
            System.out.println("No solution");
        }
    }


}

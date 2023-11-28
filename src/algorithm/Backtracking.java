package algorithm;

import logic.Grid;

import java.util.List;


public class Backtracking {
    private Grid result;

    public Backtracking(int[][] initBoard) {
        solve(init(initBoard));
    }

    public Backtracking(Grid grid) {
        solve(grid);
    }

    public Grid init(int[][] initBoard) {
        return new Grid(initBoard);
    }

    public boolean solve(Grid grid) {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < 9; i++) {
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
        for (int num : possibleValues) {
            Grid copy = grid.createcopyGrid();
            copy.getGrid()[row][col].setValue(num);
            result = new Grid(copy.intValues());

            if (solve(copy.createcopyGrid())) {
                return true;
            }
        }
        return false;
    }

    public Grid getResult() {
        return result;
    }

    public void setResult(Grid result) {
        this.result = result;
    }
}

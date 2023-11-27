package logic;

import java.util.ArrayList;

public class RowCol {
    private Cell[] values = new Cell[9];
    private ArrayList<Integer> remainingValues;


    public Cell[] getValues() {
        return values;
    }

    public void setValues(Cell[] values) {
        this.values = values;
    }

    public ArrayList<Integer> getRemainingValues() {
        return remainingValues;
    }

    public void setRemainingValues(ArrayList<Integer> remainingValues) {
        this.remainingValues = remainingValues;
    }
}

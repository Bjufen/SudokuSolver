package logic;

import java.util.ArrayList;
import java.util.Arrays;

public class Region {
    private Cell[] values = new Cell[9];
    private int[] intValues = new int[9];
    private ArrayList<Integer> remainingValues;

    public Region() {
        this.remainingValues = new ArrayList<>();
        remainingValues.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

    public void refreshRemainingValues(){
        for (int i = 0; i < 9; i++) {
            if(values[i].getValue() != 0){
                remainingValues.remove(Integer.valueOf(values[i].getValue()));
            }
        }
        refreshCellsPossibleValues();
    }

    public void refreshCellsPossibleValues(){
        for (int i = 0; i < 9; i++) {
            values[i].refreshPossibleValues();
        }
    }
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

    public void setIndividualCell(Cell cell, int index){
        values[index] = cell;
        intValues[index] = cell.getValue();
    }

    public int[] getIntValues() {
        return intValues;
    }

    public void setIntValues(int[] intValues) {
        this.intValues = intValues;
    }
}

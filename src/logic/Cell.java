package logic;

import java.util.ArrayList;
import java.util.Arrays;

public class Cell {
    private int value;
    private ArrayList<Integer> possibleValues;
    private RowCol row, col;
    private Block block;

    public Cell() {
        this.possibleValues = new ArrayList<>();
        possibleValues.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

    }

    public void refreshPossibleValues(){

    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ArrayList<Integer> getPossibleValues() {
        return possibleValues;
    }

    public void setPossibleValues(ArrayList<Integer> possibleValues) {
        this.possibleValues = possibleValues;
    }

    public RowCol getRow() {
        return row;
    }

    public void setRow(RowCol row) {
        this.row = row;
    }

    public RowCol getCol() {
        return col;
    }

    public void setCol(RowCol col) {
        this.col = col;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }
}

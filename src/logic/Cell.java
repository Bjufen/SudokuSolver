package logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Cell {
    private int value;
    private ArrayList<Integer> possibleValues;
    private Region row, col, block;
    private boolean isSet;

    public Cell() {
        this.possibleValues = new ArrayList<>();
        possibleValues.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        this.isSet = false;

    }

    public Cell(int value){
        this.value = value;
        this.possibleValues = new ArrayList<>();
        this.isSet = true;
    }

    public void refreshPossibleValues() {
        if(isSet)
            return;
        for (Cell cell : row.getValues()) {
            if (possibleValues.contains(cell.getValue())) {
                possibleValues.remove(Integer.valueOf(cell.getValue()));
            }
        }
        for (Cell cell : col.getValues()) {
            if (possibleValues.contains(cell.getValue())) {
                possibleValues.remove(Integer.valueOf(cell.getValue()));
            }
        }
        for (Cell cell : block.getValues()) {
            if (possibleValues.contains(cell.getValue())) {
                possibleValues.remove(Integer.valueOf(cell.getValue()));
            }
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        if(possibleValues.contains(value)) {
            this.value = value;
            possibleValues.clear();
            removeValueRegions();
            refreshPossibleValuesRegions();
            setSet(true);
        }
    }

    public Set<Integer> getAllValues(){
        Set<Integer> temp = new HashSet<>();
        for (Cell cell : row.getValues()) {
            if (cell.getValue() != 0) {
                temp.add(cell.getValue());
            }
        }
        for (Cell cell : col.getValues()) {
            if (cell.getValue() != 0) {
                temp.add(cell.getValue());
            }
        }
        for (Cell cell : block.getValues()) {
            if (cell.getValue() != 0) {
                temp.add(cell.getValue());
            }
        }
        return temp;
    }

    public void refreshPossibleValuesRegions(){
        row.refreshRemainingValues();
        col.refreshRemainingValues();
        block.refreshRemainingValues();
    }

    public void removeValueRegions(){
        removeValueRow();
        removeValueCol();
        removeValueBlock();
    }

    public void removeValueRow(){
        ArrayList<Integer> temp;
        temp = row.getRemainingValues();
        temp.remove(Integer.valueOf(value));
        row.setRemainingValues(temp);
    }

    public void removeValueCol(){
        ArrayList<Integer> temp;
        temp = col.getRemainingValues();
        temp.remove(Integer.valueOf(value));
        col.setRemainingValues(temp);
    }

    public void removeValueBlock(){
        ArrayList<Integer> temp;
        temp = block.getRemainingValues();
        temp.remove(Integer.valueOf(value));
        block.setRemainingValues(temp);
    }

    public ArrayList<Integer> getPossibleValues() {
        return possibleValues;
    }

    public void setPossibleValues(ArrayList<Integer> possibleValues) {
        this.possibleValues = possibleValues;
    }

    public Region getRow() {
        return row;
    }

    public void setRow(Region row) {
        this.row = row;
    }

    public Region getCol() {
        return col;
    }

    public void setCol(Region col) {
        this.col = col;
    }

    public Region getBlock() {
        return block;
    }

    public void setBlock(Region block) {
        this.block = block;
    }

    public boolean isSet() {
        return isSet;
    }

    public void setSet(boolean set) {
        isSet = set;
    }
}

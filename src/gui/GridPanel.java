package gui;

import algorithm.Backtracking;
import logic.Grid;

import javax.swing.*;
import java.awt.*;

public class GridPanel extends JPanel {

    private static final int GRID_SIZE = 9;
    private DisplayPanel displayPanel;
    private JTextField[][] gridCells = new JTextField[GRID_SIZE][GRID_SIZE];
    private Grid grid;
    private boolean validInput = true;


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
    public GridPanel(DisplayPanel displayPanel) {

        this.displayPanel = displayPanel;
        setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));



        // Calculate the preferred size for the text fields
        int preferredSize = Math.min(getPreferredSize().width / GRID_SIZE, getPreferredSize().height / GRID_SIZE);

        // Create and add text fields to the panel
        int index = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                JTextField textBox = new TextBox(preferredSize);
                gridCells[i][j] = textBox;
                add(textBox);
                if (board1[i][j] != 0) {
                    textBox.setText(Integer.toString(board1[i][j]));
                }
                index++;
            }
        }
    }


    public void solve() {
        setGrid();
        if(!validInput){
            validInput = true;
            return;
        }
        Backtracking backtracking = new Backtracking(grid);
        grid = backtracking.getResult();
        refreshBoard();
        getDisplayPanel().getMenuPanel().disableSolveButton();
    }

    public void refreshBoard(){
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++){
                if(grid.getGrid()[i][j].getValue() != 0)
                    gridCells[i][j].setText(Integer.toString(grid.getGrid()[i][j].getValue()));
            }
        }


        repaint();
    }

    public void clearGrid(){
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++){
                gridCells[i][j].setText("");
            }
        }
        repaint();
        getDisplayPanel().getMenuPanel().enableSolveButton();
    }

    public DisplayPanel getDisplayPanel() {
        return displayPanel;
    }

    public void setDisplayPanel(DisplayPanel displayPanel) {
        this.displayPanel = displayPanel;
    }

    public JTextField[][] getGridCells() {
        return gridCells;
    }

    public void setGridCells(JTextField[][] gridCells) {
        this.gridCells = gridCells;
    }

    public Grid getGrid() {
        return grid;
    }

    private int[][] getIntValues(){
        int[][] values = new int[GRID_SIZE][GRID_SIZE];
        for(int i = 0; i < GRID_SIZE; i++){
            for(int j = 0; j < GRID_SIZE; j++){
                String value = gridCells[i][j].getText();
                if(value.equals("")){
                    values[i][j] = 0;
                }else{
                    try {
                        values[i][j] = Integer.parseInt(value);
                    }
                    catch (NumberFormatException e){
                        JOptionPane.showMessageDialog(this.getParent(), "Not a valid input");
                        validInput = false;
                        break;
                    }
                }
            }
        }
        return values;
    }

    public void setGrid() {
        this.grid = new Grid(getIntValues());
    }

}

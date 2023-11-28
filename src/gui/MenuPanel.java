package gui;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    private DisplayPanel displayPanel;
    private JButton solveButton, clearButton;

    public MenuPanel(DisplayPanel displayPanel) {
        this.displayPanel = displayPanel;
        JPanel buttonPanel = new JPanel();
        solveButton = new JButton("Solve");
        clearButton = new JButton("Clear");

        solveButton.addActionListener(e -> solve());
        clearButton.addActionListener(e -> clearGrid());

        buttonPanel.add(solveButton);
        buttonPanel.add(clearButton);

        add(buttonPanel, BorderLayout.CENTER);
    }


    public void enableSolveButton(){
        solveButton.setEnabled(true);
    }

    public void disableSolveButton(){
        solveButton.setEnabled(false);
    }


    private void solve() {
        displayPanel.getGridPanel().solve();
    }

    private void clearGrid() {
        displayPanel.getGridPanel().clearGrid();
    }

}

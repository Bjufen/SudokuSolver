//Yusuf Shehadeh, 7395116
package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame extends JFrame {
    private DisplayPanel displayPanel;
    private MenuPanel menuPanel;


    public Frame() {
        super("Sudoku Solver");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        setMinimumSize(new Dimension(595, 450));
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        displayPanel = new DisplayPanel();
        menuPanel = new MenuPanel(displayPanel);
        displayPanel.setMenuPanel(menuPanel);

        add(displayPanel, BorderLayout.CENTER);
        add(menuPanel, BorderLayout.SOUTH);

        setVisible(true);
    }


}
package gui;

import logic.Grid;

import javax.swing.*;
import java.awt.*;

class DisplayPanel extends JPanel {
    private static final int SIZE = 9;
    private MenuPanel menuPanel;
    private GridPanel gridPanel;

    private JPanel north, south, east, west;

    public DisplayPanel() {
        setLayout(new BorderLayout());

        north = new JPanel();
        north.setPreferredSize(new Dimension(100, 100));
        add(north, BorderLayout.NORTH);

        south = new JPanel();
        south.setPreferredSize(new Dimension(100, 100));
        add(south, BorderLayout.SOUTH);

        east = new JPanel();
        east.setPreferredSize(new Dimension(100, 100));
        add(east, BorderLayout.EAST);

        west = new JPanel();
        west.setPreferredSize(new Dimension(100, 100));
        add(west, BorderLayout.WEST);



        gridPanel = new GridPanel(this);
        add(gridPanel, BorderLayout.CENTER);


    }



    public MenuPanel getMenuPanel() {
        return menuPanel;
    }

    public void setMenuPanel(MenuPanel menuPanel) {
        this.menuPanel = menuPanel;
    }

    public GridPanel getGridPanel() {
        return gridPanel;
    }

    public void setGridPanel(GridPanel gridPanel) {
        this.gridPanel = gridPanel;
    }
}

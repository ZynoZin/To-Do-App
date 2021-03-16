package com.zynozin;

import javax.swing.*;
import java.awt.*;

public class BarPanel extends JPanel {
    private CommandBarPanel commandBarPanel;
    private CommandsLabel menuLabel;

    public BarPanel() {
        menuLabel = new CommandsLabel("Menu");
        commandBarPanel = new CommandBarPanel();
        this.setLayout(new BorderLayout());
        this.add(commandBarPanel, BorderLayout.EAST);
        this.add(menuLabel, BorderLayout.WEST);
        this.setOpaque(true);
        this.setPreferredSize(new Dimension(MyFrame.WIDTH, 46));
        this.setBackground(new Color(37, 37, 37));
    }
}

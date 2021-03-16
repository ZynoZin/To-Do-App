package com.zynozin;

import javax.swing.*;
import java.awt.*;

public class BarPanel extends JPanel {
    private CommandBarPanel commandBarPanel;

    public BarPanel(){

        commandBarPanel  = new CommandBarPanel();
        this.setLayout(new BorderLayout());
        this.add(commandBarPanel, BorderLayout.EAST);

        this.setOpaque(true);
        this.setPreferredSize(new Dimension(WIDTH, 46));
        this.setBackground(new Color(200, 27, 10));
    }
}

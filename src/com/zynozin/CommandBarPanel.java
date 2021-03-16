package com.zynozin;

import javax.swing.*;
import java.awt.*;

public class CommandBarPanel extends JPanel {
    private ImageIcon closeIcon = new ImageIcon("images/close.png");
    private ImageIcon hideIcon = new ImageIcon("images/hide.png");
    private ImageIcon maximizeIcon = new ImageIcon("images/maximize.png");
    private CommandsLabel hideLabel;
    private CommandsLabel closeLabel;
    private CommandsLabel maximizeLabel;

    public CommandBarPanel() {
        hideLabel = new CommandsLabel("hide", hideIcon);
        closeLabel = new CommandsLabel("close", closeIcon);
        maximizeLabel = new CommandsLabel("maximize", maximizeIcon);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        this.add(hideLabel);
        //this.add(maximizeLabel);
        this.add(closeLabel);
        this.setOpaque(true);
        this.setBackground(new Color(37, 37, 37));

    }
}

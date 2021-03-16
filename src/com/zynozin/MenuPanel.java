package com.zynozin;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {
    private JLabel signature = new JLabel();
    private Font signatureFont = Main.getFontforApp(11f, "fonts/Montserrat-ThinItalic.ttf");
    private MenuCommands menuCommands;

    public MenuPanel() {
        menuCommands = new MenuCommands();
        signature.setText("Created by Zyno");
        signature.setFont(signatureFont);
        signature.setForeground(Color.white);
        this.setLayout(new BorderLayout());
        this.add(menuCommands, BorderLayout.NORTH);
        this.add(signature, BorderLayout.SOUTH);
        this.setOpaque(true);
        this.setPreferredSize(new Dimension(178, MyFrame.HEIGHT));
        this.setBackground(new Color(64, 64, 64));
    }
}

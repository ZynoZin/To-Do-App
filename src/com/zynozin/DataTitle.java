package com.zynozin;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class DataTitle extends JLabel {
    private Font dataTitleFont = Main.getFontforApp(16f, "fonts/Roboto-Regular.ttf");
    private final int WIDTH = 108;
    private final int HEIGHT = 30;

    public DataTitle(int r, int g, int b, String title) {
        this.setBackground(new Color(r, g, b));
        this.setOpaque(true);
        this.setText(title);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setFont(dataTitleFont);
        this.setForeground(Color.WHITE);
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setVerticalAlignment(SwingConstants.CENTER);


    }
}

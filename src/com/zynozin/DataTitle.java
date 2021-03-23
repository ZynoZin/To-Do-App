package com.zynozin;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class DataTitle extends JLabel {
    private Font dataTitleFont = Main.getFontforApp(16f, "fonts/Roboto-Regular.ttf");
    private final int WIDTH = 108;
    private final int HEIGHT = 30;

    public DataTitle(String title, Boolean hasBorder) {
        this.setBackground(new Color(37, 37, 37));
        this.setOpaque(true);
        this.setText(title);
        if (hasBorder.equals(true))
            this.setBorder(new MatteBorder(0, 0, 1, 0, Color.WHITE));
        this.setPreferredSize(new Dimension(360, HEIGHT));
        this.setFont(dataTitleFont);
        this.setForeground(Color.WHITE);
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setVerticalAlignment(SwingConstants.CENTER);


    }

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

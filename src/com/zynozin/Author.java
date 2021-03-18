package com.zynozin;

import javax.swing.*;
import java.awt.*;

public class Author extends JLabel {
    private final int HEIGHT = 20;
    private Font authorFont = Main.getFontforApp(12f, "fonts/Montserrat-Bold.ttf");

    public Author(String text) {
        this.setVerticalAlignment(SwingConstants.TOP);
        this.setPreferredSize(new Dimension(Quotes.WIDTH, HEIGHT));
        this.setOpaque(true);
        this.setForeground(new Color(255, 255, 255, 150));
        this.setBackground(new Color(37, 37, 37));
        this.setText(text);
        this.setFont(authorFont);
    }

}

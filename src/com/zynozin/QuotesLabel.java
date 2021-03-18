package com.zynozin;

import javax.swing.*;
import java.awt.*;

public class QuotesLabel extends JLabel {
    private final int HEIGHT = 30;
    private Font quoteFont = Main.getFontforApp(24f, "fonts/Caveat-Regular.ttf");

    public QuotesLabel(String text) {
        this.setPreferredSize(new Dimension(Quotes.WIDTH, HEIGHT));
        this.setOpaque(true);
        this.setForeground(new Color(255, 255, 255, 150));
        this.setBackground(new Color(37, 37, 37));
        this.setText(text);
        this.setFont(quoteFont);

    }
}

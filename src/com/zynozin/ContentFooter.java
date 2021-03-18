package com.zynozin;

import javax.swing.*;
import java.awt.*;

public class ContentFooter extends JPanel {
    private final int WIDTH = 1120;
    public static final int HEIGHT = 65;
    public static Quotes quotes;
    private Date date;

    public ContentFooter() {
        quotes = new Quotes();
        date = new Date();
        this.setLayout(new BorderLayout());
        this.add(quotes, BorderLayout.WEST);
        this.add(date, BorderLayout.EAST);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setOpaque(true);
        this.setBackground(new Color(37, 37, 37));
    }
}

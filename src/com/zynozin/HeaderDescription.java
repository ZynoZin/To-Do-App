package com.zynozin;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class HeaderDescription extends JLabel {

    private Font descriptionFont = Main.getFontforApp(15f, "fonts/Montserrat-Light.ttf");

    public HeaderDescription(String text) {
        this.setText(text);
        this.setForeground(Color.white);
        this.setOpaque(true);
        this.setBorder(new EmptyBorder(0, 0, 0, 200));
        this.setPreferredSize(new Dimension(1000, 60));

        this.setBackground(new Color(37, 37, 37));
        this.setFont(descriptionFont);
    }
}

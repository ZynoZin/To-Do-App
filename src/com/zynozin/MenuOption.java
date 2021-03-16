package com.zynozin;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MenuOption extends JLabel {
    private Font menuOptionFont = Main.getFontforApp(14f, "fonts/Montserrat-Medium.ttf");

    public MenuOption(String text) {
        this.setPreferredSize(new Dimension(178, 37));
        this.setText(text);
        this.setForeground(Color.white);
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setVerticalAlignment(SwingConstants.CENTER);
        this.setFont(menuOptionFont);

    }
}

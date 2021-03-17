package com.zynozin;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class HeaderTitle extends JLabel {
    private Font headerFont = Main.getFontforApp(36f, "fonts/Montserrat-Light.ttf");

    public HeaderTitle(String text) {
        this.setText(text);
        this.setForeground(Color.white);
        this.setOpaque(true);

        this.setPreferredSize(new Dimension(970, 50));
        this.setBackground(new Color(37, 37, 37));
        this.setFont(headerFont);
    }
}

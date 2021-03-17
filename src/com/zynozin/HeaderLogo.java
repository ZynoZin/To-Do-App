package com.zynozin;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class HeaderLogo extends JLabel {
    private ImageIcon imageIcon;

    public HeaderLogo(String path) {
        this.imageIcon = new ImageIcon(path);
        this.setIcon(imageIcon);
        this.setBorder(new EmptyBorder(26, 105, 99, 3));
    }
}

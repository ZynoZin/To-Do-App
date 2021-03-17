package com.zynozin;

import javax.swing.*;
import java.awt.*;

public class ContentHeader extends JPanel {
    private final int WIDTH = MyFrame.WIDTH;
    private final int HEIGHT = 166;
    private HeaderLogo headerLogo;
    private HeaderText headerText;
    public boolean isVisible = false;

    public ContentHeader(String path, String description, String title) {
        headerText = new HeaderText(description, title);
        headerLogo = new HeaderLogo(path);
        this.setLayout(new BorderLayout());
        this.setOpaque(true);
        this.add(headerLogo, BorderLayout.WEST);
        this.add(headerText, BorderLayout.CENTER);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.DARK_GRAY));
        this.setBackground(new Color(37, 37, 37));
    }

    public Boolean getVisible() {
        return this.isVisible;
    }

}

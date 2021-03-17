package com.zynozin;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class HeaderText extends JPanel {
    private HeaderTitle headerTitle;
    private HeaderDescription headerDescription;
    private JLabel hr = new JLabel();

    public HeaderText(String description, String title) {
        hr.setBackground(Color.LIGHT_GRAY);
        hr.setOpaque(true);
        hr.setLayout(null);
        hr.setPreferredSize(new Dimension(250, 1));
        headerTitle = new HeaderTitle(title);
        headerDescription = new HeaderDescription(description);
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setOpaque(true);
        this.add(headerTitle);
        this.add(hr);
        this.add(headerDescription);
        this.setBorder(new EmptyBorder(10, 0, 0, 0));
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(new Color(37, 37, 37));
    }
}


package com.zynozin;

import javax.swing.*;
import java.awt.*;

public class ContentCategory extends JPanel {
    private DataTitle dataTitle;


    public ContentCategory(String title, int r, int g, int b) {
        dataTitle = new DataTitle(r, g, b, title);
        this.setPreferredSize(new Dimension(373, 425));
        this.setLayout(new FlowLayout());
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 9));
        dataTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(dataTitle);

        this.setBackground(new Color(37, 37, 37));
        this.setOpaque(true);
    }
}

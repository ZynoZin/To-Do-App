package com.zynozin;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class ContentDataLabel extends JLabel {
    public ContentDataArea contentDataArea;
    private JPanel mainCommands;
    private ImageIcon trashIcon = new ImageIcon("images/delete.png");
    private ImageIcon rightIcon = new ImageIcon("images/rightArrow.png");
    private ImageIcon leftIcon = new ImageIcon("images/leftArrow.png");
    private ContentDataCommands delete;
    public ContentDataCommands right;
    public ContentDataCommands left;
    public String currentCategory = "next category";

    public ContentDataLabel() {
        contentDataArea = new ContentDataArea();
        delete = new ContentDataCommands(trashIcon, "delete task", this);
        right = new ContentDataCommands(rightIcon, "right", this);
        left = new ContentDataCommands(leftIcon, "left", this);
        mainCommands = new JPanel();
        mainCommands.setOpaque(false);
        mainCommands.setLayout(new BorderLayout());
        mainCommands.add(delete, BorderLayout.WEST);
        mainCommands.add(right, BorderLayout.EAST);
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(37, 37, 37));
        this.add(contentDataArea, BorderLayout.CENTER);
        this.add(mainCommands, BorderLayout.EAST);
        this.add(left, BorderLayout.WEST);
        left.setVisible(false);
        this.setBorder(new MatteBorder(0, 0, 1, 0, Color.DARK_GRAY));
        this.setOpaque(true);
        this.setPreferredSize(new Dimension(330, 68));

    }

    public void initIcons(ContentDataLabel contentDataLabel) {
        if (contentDataLabel.currentCategory.equals("next category")) {
            contentDataLabel.left.initPlace("next category");
            contentDataLabel.right.initPlace("next category");
            contentDataLabel.right.setVisible(true);
            contentDataLabel.left.setVisible(false);
        } else if (contentDataLabel.currentCategory.equals("in progress category")) {
            contentDataLabel.left.initPlace("in progress category");
            contentDataLabel.right.initPlace("in progress category");
            contentDataLabel.left.setVisible(true);
            contentDataLabel.right.setVisible(true);
        } else if (contentDataLabel.currentCategory.equals("completed category")) {
            contentDataLabel.left.initPlace("completed category");
            contentDataLabel.right.initPlace("completed category");
            contentDataLabel.right.setVisible(false);
            contentDataLabel.left.setVisible(true);
        }
    }

}

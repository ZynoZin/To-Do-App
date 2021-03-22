package com.zynozin;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TasksLabel extends JLabel {
    public TasksArea tasksArea;
    private JPanel mainCommands;
    private ImageIcon trashIcon = new ImageIcon("images/delete.png");
    private ImageIcon rightIcon = new ImageIcon("images/rightArrow.png");
    private ImageIcon leftIcon = new ImageIcon("images/leftArrow.png");
    private TaskCommands delete;
    public TaskCommands right;
    public TaskCommands left;
    public String currentCategory = "next category";

    public TasksLabel() {
        tasksArea = new TasksArea();
        delete = new TaskCommands(trashIcon, "delete task", this);
        right = new TaskCommands(rightIcon, "right", this);
        left = new TaskCommands(leftIcon, "left", this);
        mainCommands = new JPanel();
        mainCommands.setOpaque(false);
        mainCommands.setLayout(new BorderLayout());
        mainCommands.add(delete, BorderLayout.WEST);
        mainCommands.add(right, BorderLayout.EAST);
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(37, 37, 37));
        this.add(tasksArea, BorderLayout.CENTER);
        this.add(mainCommands, BorderLayout.EAST);
        this.add(left, BorderLayout.WEST);
        left.setVisible(false);
        this.setBorder(new MatteBorder(0, 0, 1, 0, Color.DARK_GRAY));
        this.setOpaque(true);
        this.setPreferredSize(new Dimension(330, 68));

    }

    public void initIcons(TasksLabel tasksLabel) {
        if (tasksLabel.currentCategory.equals("next category")) {
            tasksLabel.left.initPlace("next category");
            tasksLabel.right.initPlace("next category");
            tasksLabel.right.setVisible(true);
            tasksLabel.left.setVisible(false);
        } else if (tasksLabel.currentCategory.equals("in progress category")) {
            tasksLabel.left.initPlace("in progress category");
            tasksLabel.right.initPlace("in progress category");
            tasksLabel.left.setVisible(true);
            tasksLabel.right.setVisible(true);
        } else if (tasksLabel.currentCategory.equals("completed category")) {
            tasksLabel.left.initPlace("completed category");
            tasksLabel.right.initPlace("completed category");
            tasksLabel.right.setVisible(false);
            tasksLabel.left.setVisible(true);
        }
    }

}

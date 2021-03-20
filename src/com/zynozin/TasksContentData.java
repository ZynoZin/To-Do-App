package com.zynozin;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TasksContentData extends JLabel {
    private final int WIDTH = 1120;
    private final int HEIGHT = 1000;
    public static ContentCategory nextCategory;
    public static ContentCategory inProgressCategory;
    public static ContentCategory completedCategory;
    public static NewTask newTask;
    public static List<TasksLabel> lastTasksSave = new ArrayList<TasksLabel>();

    public TasksContentData() {
        nextCategory = new ContentCategory("Next Up", 204, 0, 0);
        inProgressCategory = new ContentCategory("In Progress", 212, 179, 0);
        completedCategory = new ContentCategory("Completed", 3, 174, 0);
        newTask = new NewTask();
        nextCategory.add(newTask);
        this.setLayout(new GridLayout());
        this.add(nextCategory);
        this.add(inProgressCategory);
        this.add(completedCategory);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setOpaque(true);
        this.setBorder(new EmptyBorder(40, 0, 0, 0));
        this.setBackground(new Color(37, 37, 37));
    }
}
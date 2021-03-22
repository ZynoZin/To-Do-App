package com.zynozin;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

    public TasksContentData() throws IOException {
        nextCategory = new ContentCategory("Next Up", 204, 0, 0);
        inProgressCategory = new ContentCategory("In Progress", 212, 179, 0);
        completedCategory = new ContentCategory("Completed", 3, 174, 0);
        newTask = new NewTask("taskslist");
        this.setLayout(new GridLayout());
        this.add(nextCategory);
        this.add(inProgressCategory);
        this.add(completedCategory);
        writeSavedElements();
        nextCategory.add(newTask);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setOpaque(true);
        this.setBorder(new EmptyBorder(40, 0, 0, 0));
        this.setBackground(new Color(37, 37, 37));
    }

    public void writeSavedElements() throws IOException {
        BufferedReader next = new BufferedReader(new FileReader("files/nextUp.txt"));
        BufferedReader inProgress = new BufferedReader(new FileReader("files/inProgress.txt"));
        BufferedReader completed = new BufferedReader(new FileReader("files/completed.txt"));
        String nextLine = next.readLine();
        String inProgressLine = inProgress.readLine();
        String completedLine = completed.readLine();
        try {
            while (nextLine != null) {
                TasksLabel tasksLabel = new TasksLabel();
                tasksLabel.tasksArea.setText(nextLine);
                tasksLabel.initIcons(tasksLabel);
                nextCategory.add(tasksLabel);
                lastTasksSave.add(tasksLabel);
                nextLine = next.readLine();
            }
            while (inProgressLine != null) {
                TasksLabel tasksLabel = new TasksLabel();
                tasksLabel.tasksArea.setText(inProgressLine);
                tasksLabel.currentCategory = "in progress category";
                tasksLabel.initIcons(tasksLabel);
                inProgressCategory.add(tasksLabel);
                lastTasksSave.add(tasksLabel);
                inProgressLine = inProgress.readLine();
            }
            while (completedLine != null) {
                TasksLabel tasksLabel = new TasksLabel();
                tasksLabel.tasksArea.setText(completedLine);
                tasksLabel.currentCategory = "completed category";
                tasksLabel.initIcons(tasksLabel);
                completedCategory.add(tasksLabel);
                lastTasksSave.add(tasksLabel);
                completedLine = completed.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            next.close();
        }

    }
}

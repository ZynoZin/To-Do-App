package com.zynozin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TaskCommands extends JLabel implements MouseListener {
    private String title;
    private TasksLabel tasksLabel;
    public Boolean isInNext = true;
    public Boolean isInProgress = false;
    public Boolean isInCompleted = false;


    public TaskCommands(ImageIcon icon, String title, TasksLabel tasksLabel) {
        this.title = title;
        this.tasksLabel = tasksLabel;
        setIcon(icon);
        addMouseListener(this);
        setPreferredSize(new Dimension(30, 65));
        setHorizontalAlignment(SwingConstants.CENTER);

    }

    private void removeElement(TasksLabel tasksLabel) {
        for (TasksLabel temp : TasksContentData.lastTasksSave) {
            if (temp == tasksLabel) {
                TasksContentData.lastTasksSave.remove(temp);
                break;
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (title == "delete") {
            tasksLabel.setVisible(false);
        } else if (title == "right" && isInNext == true) {
            tasksLabel.setVisible(false);
            TasksContentData.inProgressCategory.add(tasksLabel);
            tasksLabel.currentCategory = "in progress category";
            tasksLabel.setVisible(true);
            tasksLabel.left.setVisible(true);
            tasksLabel.left.isInNext = false;
            tasksLabel.right.isInNext = false;
            tasksLabel.left.isInProgress = true;
            tasksLabel.right.isInProgress = true;
            tasksLabel.left.isInCompleted = false;
            tasksLabel.right.isInCompleted = false;
        } else if (title == "right" && isInProgress == true) {
            tasksLabel.setVisible(false);
            TasksContentData.completedCategory.add(tasksLabel);
            tasksLabel.currentCategory = "completed category";
            tasksLabel.setVisible(true);
            tasksLabel.right.setVisible(false);
            tasksLabel.left.isInNext = false;
            tasksLabel.right.isInNext = false;
            tasksLabel.left.isInProgress = false;
            tasksLabel.right.isInProgress = false;
            tasksLabel.left.isInCompleted = true;
            tasksLabel.right.isInCompleted = true;

        } else if (title == "left" && isInProgress == true) {
            tasksLabel.setVisible(false);
            TasksContentData.newTask.setVisible(false);
            TasksContentData.nextCategory.add(tasksLabel);
            tasksLabel.currentCategory = "next category";
            TasksContentData.nextCategory.add(TasksContentData.newTask);
            tasksLabel.setVisible(true);
            TasksContentData.newTask.setVisible(true);
            tasksLabel.left.setVisible(false);
            tasksLabel.left.isInNext = true;
            tasksLabel.right.isInNext = true;
            tasksLabel.left.isInProgress = false;
            tasksLabel.right.isInProgress = false;
            tasksLabel.left.isInCompleted = false;
            tasksLabel.right.isInCompleted = false;

        } else if (title == "left" && isInCompleted == true) {
            tasksLabel.setVisible(false);
            TasksContentData.inProgressCategory.add(tasksLabel);
            tasksLabel.currentCategory = "in progress category";
            tasksLabel.setVisible(true);
            tasksLabel.right.setVisible(true);
            tasksLabel.left.isInNext = false;
            tasksLabel.right.isInNext = false;
            tasksLabel.left.isInProgress = true;
            tasksLabel.right.isInProgress = true;
            tasksLabel.left.isInCompleted = false;
            tasksLabel.right.isInCompleted = false;

        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {

        setOpaque(true);
        setBackground(new Color(121, 121, 121));


    }

    @Override
    public void mouseExited(MouseEvent e) {

        setBackground(new Color(37, 37, 37));
    }
}

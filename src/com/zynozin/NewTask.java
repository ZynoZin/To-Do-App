package com.zynozin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class NewTask extends JLabel implements MouseListener {
    private Font newFont = Main.getFontforApp(18f, "fonts/Montserrat-Regular.ttf");
    String title;

    public NewTask(String title) {
        this.title = title;
        setBackground(new Color(37, 37, 37));
        setOpaque(true);
        setText("+ New");
        setForeground(Color.LIGHT_GRAY);
        if (title == "taskslist")
            this.setPreferredSize(new Dimension(320, 30));
        else if (title == "checklist")
            this.setPreferredSize(new Dimension(900, 30));
        this.addMouseListener(this);
        setFont(newFont);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (title == "taskslist") {
            TasksLabel tasksLabel = new TasksLabel();
            this.setVisible(false);
            TasksContentData.nextCategory.add(tasksLabel);
            this.setVisible(true);
            TasksContentData.nextCategory.add(this);
            //adding new tasksLabels to the array to save them later
            TasksContentData.lastTasksSave.add(tasksLabel);
        } else if (title == "checklist") {
            ChecklistPanel.CheckList checkList = new ChecklistPanel.CheckList();
            this.setVisible(false);
            MainContent.checklistPanel.add(checkList);
            MainContent.checklistPanel.add(this);
            this.setVisible(true);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setBackground(Color.DARK_GRAY);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setBackground(new Color(37, 37, 37));
    }
}

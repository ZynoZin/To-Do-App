package com.zynozin;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TasksLabel extends JLabel implements MouseListener {
    private TasksArea tasksArea;
    private JLabel hr = new JLabel();

    public TasksLabel() {
        tasksArea = new TasksArea();
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(37, 37, 37));
        this.add(tasksArea, BorderLayout.WEST);
        this.setBorder(new MatteBorder(0, 0, 1, 0, Color.DARK_GRAY));
        this.setOpaque(true);
        this.setPreferredSize(new Dimension(330, 65));
        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        this.setVisible(false);
        ContentData.inProgressCategory.add(this);
        this.setVisible(true);

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {


    }

    @Override
    public void mouseExited(MouseEvent e) {


    }

}

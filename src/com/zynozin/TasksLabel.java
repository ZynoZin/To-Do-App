package com.zynozin;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TasksLabel extends JLabel implements MouseListener {
    public TasksArea tasksArea;
    private JLabel hr = new JLabel();
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
        delete = new TaskCommands(trashIcon, "delete", this);
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

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println(tasksArea.getText());
    }
}

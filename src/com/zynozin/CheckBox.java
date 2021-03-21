package com.zynozin;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CheckBox extends JLabel implements MouseListener {
    private ImageIcon checkedIcon = new ImageIcon("images/checked.png");
    public Boolean isChecked;
    CheckList checkList;

    public CheckBox(CheckList checkList) {
        setPreferredSize(new Dimension(20, 5));
        setBorder(new MatteBorder(2, 2, 2, 2, Color.LIGHT_GRAY));
        setOpaque(true);
        this.checkList = checkList;
        setBackground(new Color(37, 37, 37));
        addMouseListener(this);
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (isChecked == false) {
            setIcon(checkedIcon);
            checkList.textField.setForeground(Color.DARK_GRAY);
            checkList.textField.setEditable(false);
            isChecked = true;
        } else if (isChecked == true) {
            setIcon(null);
            isChecked = false;
            checkList.textField.setForeground(Color.WHITE);
            checkList.textField.setEditable(true);
        }


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
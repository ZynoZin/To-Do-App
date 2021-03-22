package com.zynozin;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CheckBox extends JLabel implements MouseListener {
    private ImageIcon checkedIcon = new ImageIcon("images/checked.png");
    public Boolean isChecked;
    ListOfItems listOfItems;

    public CheckBox(ImageIcon imageIcon) {
        setPreferredSize(new Dimension(20, 5));
        setOpaque(true);
        setIcon(imageIcon);
        setBackground(new Color(37, 37, 37));

    }

    public CheckBox(ListOfItems listOfItems) {
        setPreferredSize(new Dimension(20, 5));
        setBorder(new MatteBorder(2, 2, 2, 2, Color.LIGHT_GRAY));
        setOpaque(true);
        this.listOfItems = listOfItems;
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
            listOfItems.textField.setForeground(Color.DARK_GRAY);
            listOfItems.textField.setEditable(false);
            isChecked = true;
        } else if (isChecked == true) {
            setIcon(null);
            isChecked = false;
            listOfItems.textField.setForeground(Color.WHITE);
            listOfItems.textField.setEditable(true);
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
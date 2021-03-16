package com.zynozin;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class CommandsLabel extends JLabel implements MouseListener {
    private ImageIcon maximizeIcon = new ImageIcon("images/maximize.png");
    private ImageIcon minimizeIcon = new ImageIcon("images/minimize.png");
    private String title;
    private Font menuFont = Main.getFontforApp(18f, "fonts/Montserrat-Bold.ttf");

    public CommandsLabel(String text) {
        this.setText(text);
        this.setForeground(new Color(233, 233, 233));
        this.setOpaque(true);
        this.setPreferredSize(new Dimension(178, 46));
        this.setBackground(new Color(64, 64, 64));
        this.setFont(menuFont);
        this.setBorder(new EmptyBorder(0, 10, 0, 0));

    }

    public CommandsLabel(String title, ImageIcon icon) {
        this.title = title;
        this.setIcon(icon);
        this.addMouseListener(this);
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setPreferredSize(new Dimension(55, 46));

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (title == "close") {
            Main.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Main.frame.dispose();
            System.exit(0);
        }
        if (title == "hide") {
            Main.frame.setExtendedState(JFrame.ICONIFIED);
        } else {
            if (title == "maximize") {
                Main.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                this.setIcon(minimizeIcon);
                this.title = "minimize";
            } else if (title == "minimize") {
                Main.frame.setExtendedState(JFrame.NORMAL);
                this.setIcon(maximizeIcon);
                this.title = "maximize";
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (title == "close") {
            this.setOpaque(true);
            this.setBackground(Color.RED);
        } else {
            this.setOpaque(true);
            this.setBackground(new Color(121, 121, 121));
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {

        this.setBackground(new Color(37, 37, 37));
    }
}

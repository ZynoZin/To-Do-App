package com.zynozin;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultStyledDocument;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

import java.awt.event.KeyEvent;

import components.DocumentSizeFilter;

public class TasksArea extends JTextArea {
    private Font tasksFont = Main.getFontforApp(18f, "fonts/Vinson-Bold.ttf");
    private DefaultStyledDocument doc = new DefaultStyledDocument();


    public TasksArea() {
        doc.setDocumentFilter(new DocumentSizeFilter(60));
        this.setBackground(new Color(250, 37, 37));
        this.setLineWrap(true);
        this.setWrapStyleWord(true);
        this.setOpaque(false);
        this.setBounds(4, 4, 300, 50);
        this.setBorder(new EmptyBorder(7, 5, 0, 5));
        this.setFont(tasksFont);
        this.setForeground(Color.WHITE);
        this.setDocument(doc);

    }


}
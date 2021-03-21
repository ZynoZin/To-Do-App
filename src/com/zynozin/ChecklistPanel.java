package com.zynozin;

import components.DocumentSizeFilter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.text.DefaultStyledDocument;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ChecklistPanel extends JPanel {
    private final int WIDTH = 1120;
    private final int HEIGHT = 10000;
    private NewTask newTask;
    public static List<CheckList> lastChecklistSave = new ArrayList<CheckList>();
    private ImageIcon checkedIcon = new ImageIcon("images/checked.png");

    public ChecklistPanel() throws IOException {
        newTask = new NewTask("checklist");
        setBackground(new Color(37, 37, 37));
        setOpaque(true);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setLayout(new FlowLayout(FlowLayout.LEFT));
        writeSavedElements();
        add(newTask);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 15));
        setBorder(new EmptyBorder(50, 100, 0, 0));

    }

    public void writeSavedElements() throws IOException {
        BufferedReader check = new BufferedReader(new FileReader("files/checklist.txt"));
        BufferedReader icon = new BufferedReader(new FileReader("files/checklistIcon.txt"));
        String checkLine = check.readLine();
        String iconLine;
        try {
            while (checkLine != null) {
                iconLine = icon.readLine();
                CheckList checkList = new CheckList(iconLine);
                checkList.textField.setText(checkLine);
                this.add(checkList);
                lastChecklistSave.add(checkList);
                checkLine = check.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            check.close();
        }

    }


}

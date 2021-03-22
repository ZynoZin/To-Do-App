package com.zynozin;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ItemsPanel extends JPanel {
    private final int WIDTH = 1120;
    private final int HEIGHT = 10000;
    private NewTask newTask;
    public static List<ListOfItems> lastChecklistSave = new ArrayList<ListOfItems>();
    public static List<ListOfItems> lastIdeaListSave = new ArrayList<ListOfItems>();
    private ImageIcon checkedIcon = new ImageIcon("images/checked.png");

    public ItemsPanel(String type) throws IOException {
        newTask = new NewTask("idea");
        setBackground(new Color(37, 37, 37));
        setOpaque(true);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        writeSavedElements(type);
        setLayout(new FlowLayout(FlowLayout.CENTER, 100, 20));
        add(newTask);
        setBorder(new EmptyBorder(50, 35, 0, 0));

    }

    public ItemsPanel() throws IOException {
        newTask = new NewTask("checklist");
        setBackground(new Color(37, 37, 37));
        setOpaque(true);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setLayout(new FlowLayout(FlowLayout.CENTER, 100, 20));
        writeSavedElements("checklist");
        add(newTask);
        setBorder(new EmptyBorder(50, 35, 0, 0));

    }

    public void writeSavedElements(String type) throws IOException {
        if (type.equals("checklist")) {
            BufferedReader check = new BufferedReader(new FileReader("files/checklist.txt"));
            BufferedReader icon = new BufferedReader(new FileReader("files/checklistIcon.txt"));
            String checkLine = check.readLine();
            String iconLine;
            try {
                while (checkLine != null) {
                    iconLine = icon.readLine();
                    ListOfItems listOfItems = new ListOfItems(iconLine);
                    listOfItems.textField.setText(checkLine);
                    this.add(listOfItems);
                    lastChecklistSave.add(listOfItems);
                    checkLine = check.readLine();
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                check.close();
            }
        } else if (type.equals("idea")) {
            BufferedReader idea = new BufferedReader(new FileReader("files/ideas.txt"));
            String ideaLine = idea.readLine();
            try {
                while (ideaLine != null) {
                    ListOfItems listOfItems = new ListOfItems(1);
                    listOfItems.textField.setText(ideaLine);
                    this.add(listOfItems);
                    lastIdeaListSave.add(listOfItems);
                    ideaLine = idea.readLine();
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                idea.close();
            }
        }


    }


}

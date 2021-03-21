package com.zynozin;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MainContent extends JPanel {
    private final int WIDTH = 1122;
    private final int HEIGHT = 654;

    public static ContentHeader[] contentHeaders = {
            new ContentHeader("images/tasks.png", "A simple Tasks list template that can help you organize your daily tasks smoothly.", "Tasks List."),
            new ContentHeader("images/project.png", "Have a project idea in mind? Just write it down here and come back to it later.", "Project Ideas."),
            new ContentHeader("images/groceries.png", "Organize your daily life by listing all the groceries you need to get.", "Grocery List."),
            new ContentHeader("images/checklist.png", "Write some actions that won't take much of your time.", "Checklist."),
            new ContentHeader("images/journal.png", "Started or finished from reading a book? State it here so you can keep track of it.", "Reading Journal."),
            new ContentHeader("images/notes.png", "If you have anything you would like to write and save, just write it here!", "Notes."),
            new ContentHeader("images/wishlist.png", "You want to get something but you can't at the moment? Write it here so you remember it later.", "Wishlist."),

    };
    private ContentHeader contentHeader = contentHeaders[0];
    private ContentFooter contentFooter;
    private TasksContentData contentData;
    public static NotesPanel notesPanel;
    public static ChecklistPanel checklistPanel;
    public static ModernScrollPane tasksContentScrollPane;
    public static ModernScrollPane checklistScrollPane;

    public MainContent() throws IOException {
        contentFooter = new ContentFooter();
        contentData = new TasksContentData();
        notesPanel = new NotesPanel();
        checklistPanel = new ChecklistPanel();
        tasksContentScrollPane = new ModernScrollPane(contentData);
        checklistScrollPane = new ModernScrollPane(checklistPanel);
        this.setLayout(new BorderLayout());
        this.add(contentHeader, BorderLayout.NORTH);
        initVisibility();
        writeSavedElements();
        this.add(contentFooter, BorderLayout.SOUTH);
        this.setOpaque(true);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(new Color(37, 37, 37));
    }

    public void initVisibility() {
        this.add(tasksContentScrollPane, BorderLayout.CENTER);
    }

    public void setContentHeader(ContentHeader contentHeader) {
        this.contentHeader.setVisible(false);
        this.contentHeader = contentHeader;
        this.add(this.contentHeader, BorderLayout.NORTH);
        this.contentHeader.setVisible(true);
    }

    private void writeSavedElements() throws IOException {
        BufferedReader notes = new BufferedReader(new FileReader("files/notes.txt"));
        String notesLine = notes.readLine();
        try {
            StringBuilder sb = new StringBuilder();
            while (notesLine != null) {
                sb.append(notesLine);
                sb.append(System.lineSeparator());
                notesLine = notes.readLine();
            }
            notesPanel.notesArea.setText(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            notes.close();
        }

    }

    public ContentHeader getContentHeader() {
        return contentHeader;
    }

}

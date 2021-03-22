package com.zynozin;

import components.DocumentSizeFilter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.text.DefaultStyledDocument;
import java.awt.*;

public class ListOfItems extends JLabel {
    public JTextField textField;
    public CheckBox checklistBox;
    public CheckBox ideaBox;
    private Font projectsFont = Main.getFontforApp(18f, "fonts/Montserrat-Light.ttf");
    private DefaultStyledDocument doc = new DefaultStyledDocument();
    private TaskCommands delete;
    public static ImageIcon trashIcon = new ImageIcon("images/delete.png");
    public static ImageIcon checkedIcon = new ImageIcon("images/checked.png");
    public static ImageIcon ideaIcon = new ImageIcon("images/idea.png");
    public static ImageIcon wishIcon = new ImageIcon("images/wish.png");

    public ListOfItems(ImageIcon imageIcon) {
        textField = new JTextField();
        ideaBox = new CheckBox(imageIcon);
        textField.setOpaque(false);
        textField.setBackground(new Color(37, 37, 37));
        textField.setPreferredSize(new Dimension(600, 10));
        textField.setBorder(new EmptyBorder(0, 5, 0, 5));
        textField.setForeground(Color.WHITE);
        textField.setFont(projectsFont);
        textField.setCaretColor(Color.WHITE);
        doc.setDocumentFilter(new DocumentSizeFilter(80));
        textField.setDocument(doc);
        delete = new TaskCommands(trashIcon, "delete checklist", this);
        setOpaque(false);
        setBackground(new Color(37, 37, 37));
        setBorder(new MatteBorder(0, 0, 1, 0, Color.DARK_GRAY));
        setOpaque(true);
        setPreferredSize(new Dimension(900, 30));
        setLayout(new BorderLayout());
        add(textField, BorderLayout.CENTER);
        add(ideaBox, BorderLayout.WEST);
        add(delete, BorderLayout.EAST);
    }

    public ListOfItems(String state) {
        textField = new JTextField();
        checklistBox = new CheckBox(this);
        textField.setOpaque(false);
        textField.setBackground(new Color(37, 37, 37));
        textField.setPreferredSize(new Dimension(600, 10));
        textField.setBorder(new EmptyBorder(0, 5, 0, 5));
        textField.setForeground(Color.WHITE);
        textField.setFont(projectsFont);
        textField.setCaretColor(Color.WHITE);
        doc.setDocumentFilter(new DocumentSizeFilter(80));
        textField.setDocument(doc);
        if (state.equals("true")) {
            checklistBox.setIcon(checkedIcon);
            this.textField.setForeground(Color.DARK_GRAY);
            this.textField.setEditable(false);
            checklistBox.isChecked = true;
        } else {
            checklistBox.isChecked = false;
        }
        delete = new TaskCommands(trashIcon, "delete checklist", this);
        setOpaque(false);
        setBackground(new Color(37, 37, 37));
        setBorder(new MatteBorder(0, 0, 1, 0, Color.DARK_GRAY));
        setOpaque(true);
        setPreferredSize(new Dimension(900, 25));
        setLayout(new BorderLayout());
        add(textField, BorderLayout.CENTER);
        add(checklistBox, BorderLayout.WEST);
        add(delete, BorderLayout.EAST);
    }
}
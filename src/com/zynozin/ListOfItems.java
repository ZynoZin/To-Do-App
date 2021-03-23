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
    private final DefaultStyledDocument doc = new DefaultStyledDocument();
    private ContentDataCommands delete;
    public static ImageIcon trashIcon = new ImageIcon("images/delete.png");
    public static ImageIcon checkedIcon = new ImageIcon("images/checked.png");
    public static ImageIcon ideaIcon = new ImageIcon("images/idea.png");
    public static ImageIcon wishIcon = new ImageIcon("images/wish.png");
    public static ImageIcon bookIcon = new ImageIcon("images/book.png");

    public ListOfItems(ImageIcon imageIcon, String deleteTitle, float size, int maxChars, int textWidth, int listWidth, Boolean hasIcon, Boolean hasDelete) {
        textField = new JTextField();
        projectsFont = Main.getFontforApp(size, "fonts/Montserrat-Light.ttf");
        ideaBox = new CheckBox(imageIcon);
        textField.setOpaque(false);
        textField.setBackground(new Color(37, 37, 37));
        textField.setPreferredSize(new Dimension(textWidth, 10));
        textField.setBorder(new EmptyBorder(0, 5, 0, 5));
        textField.setForeground(Color.WHITE);
        textField.setFont(projectsFont);
        textField.setCaretColor(Color.WHITE);
        doc.setDocumentFilter(new DocumentSizeFilter(maxChars));
        textField.setDocument(doc);
        delete = new ContentDataCommands(trashIcon, deleteTitle, this);
        setOpaque(false);
        setBackground(new Color(37, 37, 37));
        setBorder(new MatteBorder(0, 0, 1, 0, Color.DARK_GRAY));
        setOpaque(true);
        setPreferredSize(new Dimension(listWidth, 30));
        setLayout(new BorderLayout());
        add(textField, BorderLayout.CENTER);
        if (hasIcon.equals(true))
            add(ideaBox, BorderLayout.WEST);
        if (hasDelete.equals(true))
            add(delete, BorderLayout.EAST);

    }


    public ListOfItems(String state, String title) {
        projectsFont = Main.getFontforApp(18f, "fonts/Montserrat-Light.ttf");
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
        delete = new ContentDataCommands(trashIcon, title, this);
        setOpaque(false);
        setBackground(new Color(37, 37, 37));
        setBorder(new MatteBorder(0, 0, 1, 0, Color.DARK_GRAY));
        setOpaque(true);
        if (title.equals("checklist"))
            setPreferredSize(new Dimension(900, 25));
        else
            setPreferredSize(new Dimension(250, 25));
        setLayout(new BorderLayout());
        add(textField, BorderLayout.CENTER);
        add(checklistBox, BorderLayout.WEST);
        add(delete, BorderLayout.EAST);
    }
}
package com.zynozin;

import components.DocumentSizeFilter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.text.DefaultStyledDocument;
import java.awt.*;

public class CheckList extends JLabel {
    public JTextField textField;
    public CheckBox checkBox;
    private Font projectsFont = Main.getFontforApp(18f, "fonts/Montserrat-Light.ttf");
    private DefaultStyledDocument doc = new DefaultStyledDocument();
    private TaskCommands delete;
    private ImageIcon trashIcon = new ImageIcon("images/delete.png");
    private ImageIcon checkedIcon = new ImageIcon("images/checked.png");


    public CheckList(String state) {
        textField = new JTextField();
        checkBox = new CheckBox(this);

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
            checkBox.setIcon(checkedIcon);
            this.textField.setForeground(Color.DARK_GRAY);
            this.textField.setEditable(false);
            checkBox.isChecked = true;
        } else {
            checkBox.isChecked = false;
        }
        delete = new TaskCommands(trashIcon, "delete checklist", this);
        setOpaque(false);
        setBackground(new Color(37, 37, 37));
        setBorder(new MatteBorder(0, 0, 1, 0, Color.DARK_GRAY));
        setOpaque(true);
        setPreferredSize(new Dimension(900, 25));
        setLayout(new BorderLayout());
        add(textField, BorderLayout.CENTER);
        add(checkBox, BorderLayout.WEST);
        add(delete, BorderLayout.EAST);
    }
}
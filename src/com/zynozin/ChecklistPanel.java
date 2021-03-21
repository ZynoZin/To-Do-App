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
                iconLine = icon.readLine().trim();
                CheckList checkList = new CheckList();
                checkList.textField.setText(checkLine);
                if (iconLine == "true") {
                    checkList.checkBox.setIcon(checkedIcon);

                }

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

    public static class CheckList extends JLabel {
        public JTextField textField;
        public CheckBox checkBox;
        private Font projectsFont = Main.getFontforApp(18f, "fonts/Montserrat-Light.ttf");
        private DefaultStyledDocument doc = new DefaultStyledDocument();
        private TaskCommands delete;
        private ImageIcon trashIcon = new ImageIcon("images/delete.png");

        public CheckList() {
            textField = new JTextField();
            checkBox = new CheckBox();
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
            setPreferredSize(new Dimension(900, 25));
            setLayout(new BorderLayout());
            add(textField, BorderLayout.CENTER);
            add(checkBox, BorderLayout.WEST);
            add(delete, BorderLayout.EAST);
        }
    }

    public static class CheckBox extends JLabel implements MouseListener {
        private ImageIcon checkedIcon = new ImageIcon("images/checked.png");
        public Boolean isChecked;

        public CheckBox() {
            setPreferredSize(new Dimension(20, 5));
            setBorder(new MatteBorder(2, 2, 2, 2, Color.LIGHT_GRAY));
            setOpaque(false);
            isChecked = false;
            setBackground(new Color(37, 37, 37));
            addMouseListener(this);
        }


        public void setBoxIcon() {
            isChecked = true;
            setIcon(checkedIcon);

        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (isChecked == false) {
                setIcon(checkedIcon);
                isChecked = true;
            } else if (isChecked == true) {
                setIcon(null);
                isChecked = false;
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
}

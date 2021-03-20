package com.zynozin;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class NotesPanel extends JPanel {
    private final int WIDTH = 1120;
    private final int HEIGHT = 425;
    private ModernScrollPane modernScrollPane;
    public NotesArea notesArea;

    public NotesPanel() {
        notesArea = new NotesArea();
        modernScrollPane = new ModernScrollPane(notesArea);
        modernScrollPane.setBorder(new MatteBorder(3, 3, 3, 3, Color.darkGray));
        setBackground(new Color(37, 37, 37));
        setOpaque(true);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setLayout(new FlowLayout());
        add(modernScrollPane);
    }


    public class NotesArea extends JTextArea {
        private Font notesFont = Main.getFontforApp(18f, "fonts/Montserrat-Light.ttf");

        public NotesArea() {
            this.setBackground(new Color(20, 20, 20));
            this.setLineWrap(true);
            this.setCaretColor(Color.WHITE);
            this.setWrapStyleWord(true);
            this.setOpaque(true);
            this.setBounds(20, 20, 1000, 1000);
            this.setPreferredSize(new Dimension(1000, 455));
            this.setBorder(new EmptyBorder(7, 5, 0, 5));
            this.setFont(notesFont);
            this.setForeground(Color.WHITE);
        }
    }
}

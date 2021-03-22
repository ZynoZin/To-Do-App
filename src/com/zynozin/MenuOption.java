package com.zynozin;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuOption extends JLabel implements MouseListener {
    private Font menuOptionFont = Main.getFontforApp(14f, "fonts/Montserrat-Medium.ttf");
    private String title;

    public MenuOption(String text) {
        this.setPreferredSize(new Dimension(178, 37));
        this.title = text;
        this.setText(text);
        this.setForeground(Color.white);
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setVerticalAlignment(SwingConstants.CENTER);
        this.setFont(menuOptionFont);
        this.addMouseListener(this);

    }

    public void setEverythingNotVisible() {
        MainContent.tasksContentScrollPane.setVisible(false);
        MainContent.notesPanel.setVisible(false);
        MainContent.ideaScrollPane.setVisible(false);
        MainContent.checklistScrollPane.setVisible(false);
        MainContent.wishlistScrollPane.setVisible(false);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (title.equals("Tasks List")) {
            MyFrame.mainContent.setContentHeader(MainContent.contentHeaders[0]);
            ContentFooter.quotes.setQuote(Quotes.quotesLabel[0]);
            ContentFooter.quotes.setAuthor(Quotes.authors[0]);
            setEverythingNotVisible();
            MyFrame.mainContent.add(MainContent.tasksContentScrollPane, BorderLayout.CENTER);
            MainContent.tasksContentScrollPane.setVisible(true);
        } else if (title.equals("Project Ideas")) {
            MyFrame.mainContent.setContentHeader(MainContent.contentHeaders[1]);
            ContentFooter.quotes.setQuote(Quotes.quotesLabel[1]);
            ContentFooter.quotes.setAuthor(Quotes.authors[1]);
            setEverythingNotVisible();
            MyFrame.mainContent.add(MainContent.ideaScrollPane, BorderLayout.CENTER);
            MainContent.ideaScrollPane.setVisible(true);
        } else if (title.equals("Grocery List")) {
            MyFrame.mainContent.setContentHeader(MainContent.contentHeaders[2]);
            ContentFooter.quotes.setQuote(Quotes.quotesLabel[2]);
            ContentFooter.quotes.setAuthor(Quotes.authors[2]);
            setEverythingNotVisible();
        } else if (title.equals("Checklist")) {
            MyFrame.mainContent.setContentHeader(MainContent.contentHeaders[3]);
            ContentFooter.quotes.setQuote(Quotes.quotesLabel[3]);
            ContentFooter.quotes.setAuthor(Quotes.authors[3]);
            setEverythingNotVisible();
            MyFrame.mainContent.add(MainContent.checklistScrollPane, BorderLayout.CENTER);
            MainContent.checklistScrollPane.setVisible(true);
        } else if (title.equals("Reading Journal")) {
            MyFrame.mainContent.setContentHeader(MainContent.contentHeaders[4]);
            ContentFooter.quotes.setQuote(Quotes.quotesLabel[4]);
            ContentFooter.quotes.setAuthor(Quotes.authors[4]);
            setEverythingNotVisible();
        } else if (title.equals("Notes")) {
            MyFrame.mainContent.setContentHeader(MainContent.contentHeaders[5]);
            ContentFooter.quotes.setQuote(Quotes.quotesLabel[5]);
            ContentFooter.quotes.setAuthor(Quotes.authors[5]);
            setEverythingNotVisible();
            MyFrame.mainContent.add(MainContent.notesPanel, BorderLayout.CENTER);
            MainContent.notesPanel.setVisible(true);
        } else if (title.equals("Wishlist")) {
            MyFrame.mainContent.setContentHeader(MainContent.contentHeaders[6]);
            ContentFooter.quotes.setQuote(Quotes.quotesLabel[6]);
            ContentFooter.quotes.setAuthor(Quotes.authors[6]);
            setEverythingNotVisible();
            MyFrame.mainContent.add(MainContent.wishlistScrollPane, BorderLayout.CENTER);
            MainContent.wishlistScrollPane.setVisible(true);
        }
        this.setBackground(new Color(44, 44, 44));

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {

        this.setOpaque(true);
        this.setBackground(new Color(121, 121, 121));
    }

    @Override
    public void mouseExited(MouseEvent e) {

        this.setBackground(new Color(64, 64, 64));


    }
}

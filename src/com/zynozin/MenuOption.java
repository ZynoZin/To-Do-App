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


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (title == "Tasks List") {
            MyFrame.mainContent.setContentHeader(MainContent.contentHeaders[0]);
            ContentFooter.quotes.setQuote(Quotes.quotesLabel[0]);
            ContentFooter.quotes.setAuthor(Quotes.authors[0]);
        } else if (title == "Project Ideas") {
            MyFrame.mainContent.setContentHeader(MainContent.contentHeaders[1]);
            ContentFooter.quotes.setQuote(Quotes.quotesLabel[1]);
            ContentFooter.quotes.setAuthor(Quotes.authors[1]);
        } else if (title == "Grocery List") {
            MyFrame.mainContent.setContentHeader(MainContent.contentHeaders[2]);
            ContentFooter.quotes.setQuote(Quotes.quotesLabel[2]);
            ContentFooter.quotes.setAuthor(Quotes.authors[2]);
        } else if (title == "Checklist") {
            MyFrame.mainContent.setContentHeader(MainContent.contentHeaders[3]);
            ContentFooter.quotes.setQuote(Quotes.quotesLabel[3]);
            ContentFooter.quotes.setAuthor(Quotes.authors[3]);
        } else if (title == "Reading Journal") {
            MyFrame.mainContent.setContentHeader(MainContent.contentHeaders[4]);
            ContentFooter.quotes.setQuote(Quotes.quotesLabel[4]);
            ContentFooter.quotes.setAuthor(Quotes.authors[4]);
        } else if (title == "Notes") {
            MyFrame.mainContent.setContentHeader(MainContent.contentHeaders[5]);
            ContentFooter.quotes.setQuote(Quotes.quotesLabel[5]);
            ContentFooter.quotes.setAuthor(Quotes.authors[5]);
        } else if (title == "Wishlist") {
            MyFrame.mainContent.setContentHeader(MainContent.contentHeaders[6]);
            ContentFooter.quotes.setQuote(Quotes.quotesLabel[6]);
            ContentFooter.quotes.setAuthor(Quotes.authors[6]);
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

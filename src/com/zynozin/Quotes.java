package com.zynozin;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Quotes extends JPanel {
    public static final int WIDTH = 790;

    public static QuotesLabel[] quotesLabel = {
            new QuotesLabel("“ The secret of getting ahead is getting started.”"),
            new QuotesLabel("“ Everything you can imagine is real.”"),
            new QuotesLabel("“ The secret of your future is hidden in your daily routine.”"),
            new QuotesLabel("“ Nothing will work unless you do.”"),
            new QuotesLabel("“ A reader lives a thousand lives before he dies. The man who never reads lives only one.”"),
            new QuotesLabel("“ Write it. Shoot it. Publish it. Crochet it, sauté it, whatever. MAKE.”"),
            new QuotesLabel("“ Some people want it to happen, some wish it would happen, others make it happen.”")


    };
    public static Author[] authors = {
            new Author("― Mark Twain."),
            new Author("― Pablo Picasso."),
            new Author("― Mike Murdock."),
            new Author("― Maya Angelou."),
            new Author("― George R.R. Martin"),
            new Author("― Joss Whedon."),
            new Author("― Michael Jordan"),
    };
    private QuotesLabel quote = quotesLabel[0];
    private Author author = authors[0];

    public Quotes() {
        this.setPreferredSize(new Dimension(WIDTH, ContentFooter.HEIGHT));
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(quote);
        this.add(author);
        this.setBorder(new EmptyBorder(0, 4, 2, 0));
        this.setOpaque(true);
        this.setBackground(new Color(37, 37, 37));

    }

    public void setQuote(QuotesLabel quote) {
        this.quote.setVisible(false);
        this.quote = quote;
        this.add(this.quote);
        this.quote.setVisible(true);
    }

    public void setAuthor(Author author) {
        this.author.setVisible(false);
        this.author = author;
        this.add(this.author);
        this.author.setVisible(true);
    }
}

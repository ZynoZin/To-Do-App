package com.zynozin;

import javax.swing.*;
import java.awt.*;

public class MenuCommands extends JPanel {
    private MenuOption tasksList = new MenuOption("Tasks List");
    private MenuOption projectIdeas = new MenuOption("Project Ideas");
    private MenuOption groceryList = new MenuOption("Grocery List");
    private MenuOption checkList = new MenuOption("Checklist");
    private MenuOption readingJournal = new MenuOption("Reading Journal");
    private MenuOption notes = new MenuOption("Notes");
    private MenuOption wishList = new MenuOption("Wish List");

    public MenuCommands() {
        this.setPreferredSize(new Dimension(178, 300));
        this.setOpaque(false);
        this.setLayout(new FlowLayout());
        this.add(tasksList);
        this.add(projectIdeas);
        this.add(groceryList);
        this.add(checkList);
        this.add(readingJournal);
        this.add(notes);
        this.add(wishList);
    }
}

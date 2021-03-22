package com.zynozin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class NewTask extends JLabel implements MouseListener {
    private Font newFont = Main.getFontforApp(18f, "fonts/Montserrat-Regular.ttf");
    String title;

    public NewTask(String title) {
        this.title = title;
        setBackground(new Color(37, 37, 37));
        setOpaque(true);
        setText("+ New");
        setForeground(Color.LIGHT_GRAY);
        if (title.equals("taskslist"))
            this.setPreferredSize(new Dimension(320, 30));
        else if (title.equals("grocery list vegetables") || title.equals("grocery list fruits") ||
                title.equals("grocery list drinks") || title.equals("grocery list other"))
            this.setPreferredSize(new Dimension(250, 30));
        else
            this.setPreferredSize(new Dimension(900, 30));
        this.addMouseListener(this);
        setFont(newFont);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (title.equals("taskslist")) {
            ContentDataLabel contentDataLabel = new ContentDataLabel();
            this.setVisible(false);
            ContentDataPanel.nextCategory.add(contentDataLabel);
            ContentDataPanel.nextCategory.add(this);
            this.setVisible(true);
            ContentDataPanel.lastTasksSave.add(contentDataLabel);
        } else if (title.equals("grocery list vegetables")) {
            ListOfItems vegetablesList = new ListOfItems("false", "grocery list");
            this.setVisible(false);
            ContentDataPanel.vegetablesCategory.add(vegetablesList);
            ContentDataPanel.vegetablesCategory.add(this);
            this.setVisible(true);
            ContentDataPanel.lastVegetablesListSave.add(vegetablesList);
        } else if (title.equals("grocery list fruits")) {
            ListOfItems fruitsList = new ListOfItems("false", "grocery list");
            this.setVisible(false);
            ContentDataPanel.fruitsCategory.add(fruitsList);
            ContentDataPanel.fruitsCategory.add(this);
            this.setVisible(true);
            ContentDataPanel.lastFruitsListSave.add(fruitsList);
        } else if (title.equals("grocery list drinks")) {
            ListOfItems drinksList = new ListOfItems("false", "grocery list");
            this.setVisible(false);
            ContentDataPanel.drinksCategory.add(drinksList);
            ContentDataPanel.drinksCategory.add(this);
            this.setVisible(true);
            ContentDataPanel.lastDrinksListSave.add(drinksList);
        } else if (title.equals("grocery list other")) {
            ListOfItems otherList = new ListOfItems("false", "grocery list");
            this.setVisible(false);
            ContentDataPanel.otherCategory.add(otherList);
            ContentDataPanel.otherCategory.add(this);
            this.setVisible(true);
            ContentDataPanel.lastOtherListSave.add(otherList);
        } else if (title.equals("checklist")) {
            ListOfItems checklistItems = new ListOfItems("false", "taskslist");
            this.setVisible(false);
            MainContent.checklistPanel.add(checklistItems);
            MainContent.checklistPanel.add(this);
            this.setVisible(true);
            ItemsPanel.lastChecklistSave.add(checklistItems);
        } else if (title.equals("idea")) {
            ListOfItems ideaItems = new ListOfItems(ListOfItems.ideaIcon);
            this.setVisible(false);
            MainContent.ideaPanel.add(ideaItems);
            MainContent.ideaPanel.add(this);
            this.setVisible(true);
            ItemsPanel.lastIdeaListSave.add(ideaItems);
        } else if (title.equals("wishlist")) {
            ListOfItems wishItems = new ListOfItems(ListOfItems.wishIcon);
            this.setVisible(false);
            MainContent.wishlistPanel.add(wishItems);
            MainContent.wishlistPanel.add(this);
            this.setVisible(true);
            ItemsPanel.lastWishlistSave.add(wishItems);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setBackground(Color.DARK_GRAY);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setBackground(new Color(37, 37, 37));
    }
}

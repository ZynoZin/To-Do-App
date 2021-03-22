package com.zynozin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ContentDataCommands extends JLabel implements MouseListener {
    private String title;
    private ContentDataLabel contentDataLabel;
    private ListOfItems listOfItems;
    public Boolean isInNext = true;
    public Boolean isInProgress = false;
    public Boolean isInCompleted = false;

    public ContentDataCommands(ImageIcon icon, String title, ListOfItems listOfItems) {
        this.title = title;
        this.listOfItems = listOfItems;
        setIcon(icon);
        addMouseListener(this);
        setPreferredSize(new Dimension(30, 65));
        setHorizontalAlignment(SwingConstants.CENTER);

    }

    public void initPlace(String currentCategroy) {
        if (currentCategroy.equals("next category")) {
            this.isInNext = true;
            this.isInProgress = false;
            this.isInCompleted = false;
        } else if (currentCategroy.equals("in progress category")) {
            this.isInNext = false;
            this.isInProgress = true;
            this.isInCompleted = false;
        } else if (currentCategroy.equals("completed category")) {
            this.isInNext = false;
            this.isInProgress = false;
            this.isInCompleted = true;
        }
    }

    public ContentDataCommands(ImageIcon icon, String title, ContentDataLabel contentDataLabel) {
        this.title = title;
        this.contentDataLabel = contentDataLabel;
        setIcon(icon);
        addMouseListener(this);
        setPreferredSize(new Dimension(30, 65));
        setHorizontalAlignment(SwingConstants.CENTER);

    }

    private void removeTasksElement(ContentDataLabel contentDataLabel) {
        for (ContentDataLabel temp : ContentDataPanel.lastTasksSave) {
            if (temp.equals(contentDataLabel)) {
                ContentDataPanel.lastTasksSave.remove(temp);
                break;
            }
        }
    }

    private void removeVegetablesListElement(ListOfItems listOfItems) {
        for (ListOfItems vegetable : ContentDataPanel.lastVegetablesListSave) {
            if (vegetable.equals(listOfItems)) {
                ContentDataPanel.lastVegetablesListSave.remove(vegetable);
                break;
            }
        }
    }

    private void removeFruitsListElement(ListOfItems listOfItems) {
        for (ListOfItems fruit : ContentDataPanel.lastFruitsListSave) {
            if (fruit.equals(listOfItems)) {
                ContentDataPanel.lastVegetablesListSave.remove(fruit);
                break;
            }
        }
    }

    private void removeDrinksListElement(ListOfItems listOfItems) {
        for (ListOfItems drink : ContentDataPanel.lastDrinksListSave) {
            if (drink.equals(listOfItems)) {
                ContentDataPanel.lastVegetablesListSave.remove(drink);
                break;
            }
        }
    }

    private void removeOtherListElement(ListOfItems listOfItems) {
        for (ListOfItems other : ContentDataPanel.lastOtherListSave) {
            if (other.equals(listOfItems)) {
                ContentDataPanel.lastVegetablesListSave.remove(other);
                break;
            }
        }
    }

    private void removeChecklistElement(ListOfItems listOfItems) {
        for (ListOfItems check : ItemsPanel.lastChecklistSave) {
            if (check.equals(listOfItems)) {
                ItemsPanel.lastChecklistSave.remove(check);
                break;
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (title.equals("delete task")) {
            contentDataLabel.setVisible(false);
            removeTasksElement(contentDataLabel);
        } else if (title.equals("right") && isInNext.equals(true)) {
            contentDataLabel.setVisible(false);
            ContentDataPanel.inProgressCategory.add(contentDataLabel);
            contentDataLabel.currentCategory = "in progress category";
            contentDataLabel.setVisible(true);
            contentDataLabel.left.setVisible(true);
            contentDataLabel.left.isInNext = false;
            contentDataLabel.right.isInNext = false;
            contentDataLabel.left.isInProgress = true;
            contentDataLabel.right.isInProgress = true;
            contentDataLabel.left.isInCompleted = false;
            contentDataLabel.right.isInCompleted = false;
        } else if (title.equals("right") && isInProgress.equals(true)) {
            contentDataLabel.setVisible(false);
            ContentDataPanel.completedCategory.add(contentDataLabel);
            contentDataLabel.currentCategory = "completed category";
            contentDataLabel.setVisible(true);
            contentDataLabel.right.setVisible(false);
            contentDataLabel.left.isInNext = false;
            contentDataLabel.right.isInNext = false;
            contentDataLabel.left.isInProgress = false;
            contentDataLabel.right.isInProgress = false;
            contentDataLabel.left.isInCompleted = true;
            contentDataLabel.right.isInCompleted = true;

        } else if (title.equals("left") && isInProgress.equals(true)) {
            contentDataLabel.setVisible(false);
            ContentDataPanel.newTask.setVisible(false);
            ContentDataPanel.nextCategory.add(contentDataLabel);
            contentDataLabel.currentCategory = "next category";
            ContentDataPanel.nextCategory.add(ContentDataPanel.newTask);
            contentDataLabel.setVisible(true);
            ContentDataPanel.newTask.setVisible(true);
            contentDataLabel.left.setVisible(false);
            contentDataLabel.left.isInNext = true;
            contentDataLabel.right.isInNext = true;
            contentDataLabel.left.isInProgress = false;
            contentDataLabel.right.isInProgress = false;
            contentDataLabel.left.isInCompleted = false;
            contentDataLabel.right.isInCompleted = false;

        } else if (title.equals("left") && isInCompleted.equals(true)) {
            contentDataLabel.setVisible(false);
            ContentDataPanel.inProgressCategory.add(contentDataLabel);
            contentDataLabel.currentCategory = "in progress category";
            contentDataLabel.setVisible(true);
            contentDataLabel.right.setVisible(true);
            contentDataLabel.left.isInNext = false;
            contentDataLabel.right.isInNext = false;
            contentDataLabel.left.isInProgress = true;
            contentDataLabel.right.isInProgress = true;
            contentDataLabel.left.isInCompleted = false;
            contentDataLabel.right.isInCompleted = false;

        } else if (title.equals("delete checklist")) {
            listOfItems.setVisible(false);
            removeChecklistElement(listOfItems);
        } else if (title.equals("grocery list vegetables")) {
            listOfItems.setVisible(false);
            removeVegetablesListElement(listOfItems);
        } else if (title.equals("grocery list fruits")) {
            listOfItems.setVisible(false);
            removeFruitsListElement(listOfItems);
        } else if (title.equals("grocery list drinks")) {
            listOfItems.setVisible(false);
            removeDrinksListElement(listOfItems);
        } else if (title.equals("grocery list other")) {
            listOfItems.setVisible(false);
            removeOtherListElement(listOfItems);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {

        setOpaque(true);
        setBackground(new Color(121, 121, 121));


    }

    @Override
    public void mouseExited(MouseEvent e) {

        setBackground(new Color(37, 37, 37));
    }
}

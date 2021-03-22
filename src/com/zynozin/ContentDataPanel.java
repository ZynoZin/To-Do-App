package com.zynozin;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContentDataPanel extends JPanel {
    private final int WIDTH = 1120;
    private final int HEIGHT = 1000;
    public static ContentCategory nextCategory;
    public static ContentCategory inProgressCategory;
    public static ContentCategory completedCategory;
    public static ContentCategory vegetablesCategory;
    public static ContentCategory fruitsCategory;
    public static ContentCategory drinksCategory;
    public static ContentCategory otherCategory;
    public static NewTask newTask;
    public static NewTask newVegetable;
    public static NewTask newFruit;
    public static NewTask newDrink;
    public static NewTask newOther;
    public static List<ContentDataLabel> lastTasksSave = new ArrayList<ContentDataLabel>();
    public static List<ListOfItems> lastVegetablesListSave = new ArrayList<ListOfItems>();
    public static List<ListOfItems> lastFruitsListSave = new ArrayList<ListOfItems>();
    public static List<ListOfItems> lastDrinksListSave = new ArrayList<ListOfItems>();
    public static List<ListOfItems> lastOtherListSave = new ArrayList<ListOfItems>();


    public ContentDataPanel(String type) throws IOException {
        this.setLayout(new GridLayout());
        addProperPanels(type);
        writeSavedElements(type);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setOpaque(true);
        this.setBorder(new EmptyBorder(40, 0, 0, 0));
        this.setBackground(new Color(37, 37, 37));
    }

    public void addProperPanels(String type) {
        if (type.equals("taskslist")) {
            nextCategory = new ContentCategory("Next Up", 204, 0, 0);
            inProgressCategory = new ContentCategory("In Progress", 212, 179, 0);
            completedCategory = new ContentCategory("Completed", 3, 174, 0);
            newTask = new NewTask(type);
            this.add(nextCategory);
            this.add(inProgressCategory);
            this.add(completedCategory);
        } else if (type.equals("grocery list")) {
            vegetablesCategory = new ContentCategory("Vegetables", 3, 174, 0);
            fruitsCategory = new ContentCategory("Fruits", 204, 0, 0);
            drinksCategory = new ContentCategory("Drinks", 63, 197, 255);
            otherCategory = new ContentCategory("Other", 255, 132, 18);
            newVegetable = new NewTask("grocery list vegetables");
            newFruit = new NewTask("grocery list fruits");
            newDrink = new NewTask("grocery list drinks");
            newOther = new NewTask("grocery list other");
            this.add(vegetablesCategory);
            this.add(fruitsCategory);
            this.add(drinksCategory);
            this.add(otherCategory);

        }
    }

    public void writeSavedElements(String type) throws IOException {
        if (type.equals("taskslist")) {
            BufferedReader next = new BufferedReader(new FileReader("files/nextUp.txt"));
            BufferedReader inProgress = new BufferedReader(new FileReader("files/inProgress.txt"));
            BufferedReader completed = new BufferedReader(new FileReader("files/completed.txt"));
            String nextLine = next.readLine();
            String inProgressLine = inProgress.readLine();
            String completedLine = completed.readLine();
            try {
                while (nextLine != null) {
                    ContentDataLabel contentDataLabel = new ContentDataLabel();
                    contentDataLabel.contentDataArea.setText(nextLine);
                    contentDataLabel.initIcons(contentDataLabel);
                    nextCategory.add(contentDataLabel);
                    lastTasksSave.add(contentDataLabel);
                    nextLine = next.readLine();
                }
                while (inProgressLine != null) {
                    ContentDataLabel contentDataLabel = new ContentDataLabel();
                    contentDataLabel.contentDataArea.setText(inProgressLine);
                    contentDataLabel.currentCategory = "in progress category";
                    contentDataLabel.initIcons(contentDataLabel);
                    inProgressCategory.add(contentDataLabel);
                    lastTasksSave.add(contentDataLabel);
                    inProgressLine = inProgress.readLine();
                }
                while (completedLine != null) {
                    ContentDataLabel contentDataLabel = new ContentDataLabel();
                    contentDataLabel.contentDataArea.setText(completedLine);
                    contentDataLabel.currentCategory = "completed category";
                    contentDataLabel.initIcons(contentDataLabel);
                    completedCategory.add(contentDataLabel);
                    lastTasksSave.add(contentDataLabel);
                    completedLine = completed.readLine();
                }
                nextCategory.add(newTask);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                next.close();
            }
        } else if (type.equals("grocery list")) {
            BufferedReader vegetables = new BufferedReader(new FileReader("files/vegetables.txt"));
            BufferedReader vegetablesIcon = new BufferedReader(new FileReader("files/vegetablesIcon.txt"));
            BufferedReader fruits = new BufferedReader(new FileReader("files/fruits.txt"));
            BufferedReader fruitsIcon = new BufferedReader(new FileReader("files/fruitsIcon.txt"));
            BufferedReader drinks = new BufferedReader(new FileReader("files/drinks.txt"));
            BufferedReader drinksIcon = new BufferedReader(new FileReader("files/drinksIcon.txt"));
            BufferedReader other = new BufferedReader(new FileReader("files/other.txt"));
            BufferedReader otherIcon = new BufferedReader(new FileReader("files/otherIcon.txt"));
            String vegetablesLine = vegetables.readLine();
            String vegetablesLineIcon;
            String fruitsLine = fruits.readLine();
            String fruitsLineIcon;
            String drinksLine = drinks.readLine();
            String drinksLineIcon;
            String otherLine = other.readLine();
            String otherLineIcon;
            try {
                while (vegetablesLine != null) {
                    vegetablesLineIcon = vegetablesIcon.readLine();
                    ListOfItems listOfItems = new ListOfItems(vegetablesLineIcon, "grocery list vegetables");
                    listOfItems.textField.setText(vegetablesLine);
                    vegetablesCategory.add(listOfItems);
                    lastVegetablesListSave.add(listOfItems);
                    vegetablesLine = vegetables.readLine();
                }
                while (fruitsLine != null) {
                    fruitsLineIcon = fruitsIcon.readLine();
                    ListOfItems listOfItems = new ListOfItems(fruitsLineIcon, "grocery list fruits");
                    listOfItems.textField.setText(fruitsLine);
                    fruitsCategory.add(listOfItems);
                    lastFruitsListSave.add(listOfItems);
                    fruitsLine = fruits.readLine();
                }
                while (drinksLine != null) {
                    drinksLineIcon = drinksIcon.readLine();
                    ListOfItems listOfItems = new ListOfItems(drinksLineIcon, "grocery list drinks");
                    listOfItems.textField.setText(drinksLine);
                    drinksCategory.add(listOfItems);
                    lastDrinksListSave.add(listOfItems);
                    drinksLine = drinks.readLine();
                }
                while (otherLine != null) {
                    otherLineIcon = otherIcon.readLine();
                    ListOfItems listOfItems = new ListOfItems(otherLineIcon, "grocery list other");
                    listOfItems.textField.setText(otherLine);
                    otherCategory.add(listOfItems);
                    lastOtherListSave.add(listOfItems);
                    otherLine = other.readLine();
                }
                vegetablesCategory.add(newVegetable);
                fruitsCategory.add(newFruit);
                drinksCategory.add(newDrink);
                otherCategory.add(newOther);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                vegetables.close();
                vegetablesIcon.close();
                fruits.close();
                fruitsIcon.close();
                drinks.close();
                drinksIcon.close();
                other.close();
                otherIcon.close();
            }
        }


    }
}

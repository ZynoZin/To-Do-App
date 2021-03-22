package com.zynozin;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;

public class CommandsLabel extends JLabel implements MouseListener {
    private ImageIcon maximizeIcon = new ImageIcon("images/maximize.png");
    private ImageIcon minimizeIcon = new ImageIcon("images/minimize.png");
    private String title;
    private Font menuFont = Main.getFontforApp(18f, "fonts/Montserrat-Bold.ttf");

    public CommandsLabel(String text) {
        this.setText(text);
        this.setForeground(new Color(233, 233, 233));
        this.setOpaque(true);
        this.setPreferredSize(new Dimension(178, 46));
        this.setBackground(new Color(64, 64, 64));
        this.setFont(menuFont);
        this.setBorder(new EmptyBorder(0, 10, 0, 0));

    }

    public CommandsLabel(String title, ImageIcon icon) {
        this.title = title;
        this.setIcon(icon);
        this.addMouseListener(this);
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setPreferredSize(new Dimension(55, 46));

    }

    private void saveTasksElements() throws IOException {

        // Write the content in file
        BufferedWriter nextWriter = new BufferedWriter(new FileWriter("files/nextUp.txt"));
        BufferedWriter inProgressWriter = new BufferedWriter(new FileWriter("files/inProgress.txt"));
        BufferedWriter completedWriter = new BufferedWriter(new FileWriter("files/completed.txt"));
        BufferedWriter notesWriter = new BufferedWriter(new FileWriter("files/notes.txt"));
        BufferedWriter checkWriter = new BufferedWriter(new FileWriter("files/checklist.txt"));
        BufferedWriter vegetablesWriter = new BufferedWriter(new FileWriter("files/vegetables.txt"));
        BufferedWriter fruitsWriter = new BufferedWriter(new FileWriter("files/fruits.txt"));
        BufferedWriter drinksWriter = new BufferedWriter(new FileWriter("files/drinks.txt"));
        BufferedWriter otherWriter = new BufferedWriter(new FileWriter("files/other.txt"));
        BufferedWriter checkIconWriter = new BufferedWriter(new FileWriter("files/checklistIcon.txt"));
        BufferedWriter vegetablesIconWriter = new BufferedWriter(new FileWriter("files/vegetablesIcon.txt"));
        BufferedWriter fruitsIconWriter = new BufferedWriter(new FileWriter("files/fruitsIcon.txt"));
        BufferedWriter drinksIconWriter = new BufferedWriter(new FileWriter("files/drinksIcon.txt"));
        BufferedWriter otherIconWriter = new BufferedWriter(new FileWriter("files/otherIcon.txt"));
        BufferedWriter ideaWriter = new BufferedWriter(new FileWriter("files/ideas.txt"));
        BufferedWriter wishWriter = new BufferedWriter(new FileWriter("files/wishes.txt"));
        try {
            int i = 0;
            for (ContentDataLabel tskLabel : ContentDataPanel.lastTasksSave) {
                String lineContent = tskLabel.contentDataArea.getText();
                if (tskLabel.currentCategory == "next category") {
                    nextWriter.write(lineContent.replace("\n", " ").replace("\r", " "));
                    nextWriter.newLine();
                } else if (tskLabel.currentCategory == "in progress category") {
                    inProgressWriter.write(lineContent.replace("\n", " ").replace("\r", " "));
                    inProgressWriter.newLine();
                } else if (tskLabel.currentCategory == "completed category") {
                    completedWriter.write(lineContent.replace("\n", " ").replace("\r", " "));
                    completedWriter.newLine();
                }
            }
            for (ListOfItems listOfItems : ItemsPanel.lastChecklistSave) {
                String checkContent = listOfItems.textField.getText();
                String checkIcon = listOfItems.checklistBox.isChecked.toString();
                checkWriter.write(checkContent);
                checkIconWriter.write(checkIcon);
                checkWriter.newLine();
                checkIconWriter.newLine();
            }
            for (ListOfItems listOfItems : ContentDataPanel.lastVegetablesListSave) {
                String vegetablesContent = listOfItems.textField.getText();
                String vegetablesIcon = listOfItems.checklistBox.isChecked.toString();
                vegetablesWriter.write(vegetablesContent);
                vegetablesIconWriter.write(vegetablesIcon);
                vegetablesWriter.newLine();
                vegetablesIconWriter.newLine();
            }
            for (ListOfItems listOfItems : ContentDataPanel.lastFruitsListSave) {
                String fruitsContent = listOfItems.textField.getText();
                String fruitsIcon = listOfItems.checklistBox.isChecked.toString();
                fruitsWriter.write(fruitsContent);
                fruitsIconWriter.write(fruitsIcon);
                fruitsWriter.newLine();
                fruitsIconWriter.newLine();
            }
            for (ListOfItems listOfItems : ContentDataPanel.lastDrinksListSave) {
                String drinksContent = listOfItems.textField.getText();
                String drinksIcon = listOfItems.checklistBox.isChecked.toString();
                drinksWriter.write(drinksContent);
                drinksIconWriter.write(drinksIcon);
                drinksWriter.newLine();
                drinksIconWriter.newLine();
            }
            for (ListOfItems listOfItems : ContentDataPanel.lastOtherListSave) {
                String otherContent = listOfItems.textField.getText();
                String otherIcon = listOfItems.checklistBox.isChecked.toString();
                otherWriter.write(otherContent);
                otherIconWriter.write(otherIcon);
                otherWriter.newLine();
                otherIconWriter.newLine();
            }
            for (ListOfItems ideaItems : ItemsPanel.lastIdeaListSave) {
                String ideaContent = ideaItems.textField.getText();
                ideaWriter.write(ideaContent);
                ideaWriter.newLine();
            }
            for (ListOfItems wishItems : ItemsPanel.lastWishlistSave) {
                String wishContent = wishItems.textField.getText();
                wishWriter.write(wishContent);
                wishWriter.newLine();
            }
            String notesContent = MainContent.notesPanel.notesArea.getText();
            notesWriter.write(notesContent);
            nextWriter.close();
            inProgressWriter.close();
            completedWriter.close();
            notesWriter.close();
            checkWriter.close();
            checkIconWriter.close();
            ideaWriter.close();
            wishWriter.close();
            vegetablesWriter.close();
            fruitsWriter.close();
            drinksWriter.close();
            otherWriter.close();
            vegetablesIconWriter.close();
            fruitsIconWriter.close();
            drinksIconWriter.close();
            otherIconWriter.close();
        } catch (IOException e) {
            // Cxception handling
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (title == "close") {
            try {
                saveTasksElements();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            ContentDataPanel.lastTasksSave.clear();
            Main.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Main.frame.dispose();
            System.exit(0);
        }
        if (title == "hide") {
            Main.frame.setExtendedState(JFrame.ICONIFIED);
        }/* else {
            if (title == "maximize") {
                Main.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                this.setIcon(minimizeIcon);
                this.title = "minimize";
            } else if (title == "minimize") {
                Main.frame.setExtendedState(JFrame.NORMAL);
                this.setIcon(maximizeIcon);
                this.title = "maximize";
            }

        }
        */
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (title == "close") {
            this.setOpaque(true);
            this.setBackground(Color.RED);
        } else {
            this.setOpaque(true);
            this.setBackground(new Color(121, 121, 121));
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {

        this.setBackground(new Color(37, 37, 37));
    }
}

package com.zynozin;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyFrame extends  JFrame{
    public static final int WIDTH = 1300;
    public static final int HEIGHT = 700;
    private FrameDragListener frameDragListener = new FrameDragListener(this);
    private BarPanel barPanel;
    public MyFrame(){
        barPanel = new BarPanel();
        this.addMouseListener(frameDragListener);
        this.addMouseMotionListener(frameDragListener);
        this.setLayout(new BorderLayout());
        this.add(barPanel, BorderLayout.NORTH);
        this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(new Color(37, 37, 37, 254));
        this.setSize(WIDTH, HEIGHT);

        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    private class FrameDragListener extends MouseAdapter {

        private final JFrame frame;
        private Point mouseDownCompCoords = null;

        public FrameDragListener(JFrame frame) {
            this.frame = frame;
        }

        public void mouseReleased(MouseEvent e) {
            mouseDownCompCoords = null;
        }

        public void mousePressed(MouseEvent e) {
            mouseDownCompCoords = e.getPoint();
        }

        public void mouseDragged(MouseEvent e) {
            if (mouseDownCompCoords.x >= 0 && mouseDownCompCoords.x <= WIDTH) {
                if (mouseDownCompCoords.y >= 0 && mouseDownCompCoords.y <= 46) {
                    Point currCoords = e.getLocationOnScreen();
                    frame.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
                }
            }

        }
    }
}

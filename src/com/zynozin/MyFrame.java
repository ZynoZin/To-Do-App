package com.zynozin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyFrame extends JFrame {
    public static final int WIDTH = 1300;
    public static final int HEIGHT = 700;
    private FrameDragListener frameDragListener = new FrameDragListener(this);
    private BarPanel barPanel;
    Dimension dimMax = Toolkit.getDefaultToolkit().getScreenSize();
    private MenuPanel menuPanel;

    public MyFrame() {
        barPanel = new BarPanel();
        menuPanel = new MenuPanel();
        /*
        ComponentResizer cr = new ComponentResizer();
        cr.registerComponent(this);
        cr.setSnapSize(new Dimension(10, 10));
        this.setMaximumSize(new Dimension(dimMax.width - 500, dimMax.height - 500));
        this.setMinimumSize(new Dimension(WIDTH, HEIGHT));

         */
        this.addMouseListener(frameDragListener);
        this.addMouseMotionListener(frameDragListener);
        this.setLayout(new BorderLayout());
        this.add(barPanel, BorderLayout.NORTH);
        this.add(menuPanel, BorderLayout.WEST);
        this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(new Color(37, 37, 37, 254));
        this.setSize(WIDTH, HEIGHT);
        this.getRootPane().setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
        this.setVisible(true);
        this.pack();
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

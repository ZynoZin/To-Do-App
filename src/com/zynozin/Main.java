package com.zynozin;

import java.awt.*;
import java.awt.font.TextAttribute;
import java.io.File;
import java.io.IOException;
import java.util.Collections;

public class Main {
    public static MyFrame frame;

    public static void main(String[] args) throws IOException {
        frame = new MyFrame();
    }

    public static Font getFontforApp(float size, String path) {
        Font font = null;
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File(path)).deriveFont(Font.BOLD, size);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(path)));
        } catch (IOException | FontFormatException e) {
        }
        return font;
    }
}

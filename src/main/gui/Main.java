package main.gui;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public Main() {

        setSize(1600, 800);
        setPreferredSize(new Dimension(1600, 800));

        pack();
        setLocationRelativeTo(null);
        DrawPanel p = new DrawPanel();


        this.add(p);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Main();
    }
}

package gui;

import main.LightEmitter;
import main.Material;
import main.PhongModel;
import main.Vector;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DrawPanel extends JPanel {

    private Vector observer;
    private LightEmitter ls;
    private Material material;
    private Material material2;
    private Material material3;
    private ArrayList<Material> am;
    private int r = 150;

    public DrawPanel() {
        am = new ArrayList<>();
        material = new Material(0.2, 0.4, 0.3, 70, Color.BLUE);
        material2 = new Material(0.1, 0.6, 0.75, 50, Color.RED);
        material3 = new Material(0.3, 0.7, 0.4, 20, Color.YELLOW);
        setSize(1600, 800);
        setPreferredSize(new Dimension(1600, 800));
        setBackground(Color.GRAY);
        setVisible(true);
        this.setFocusable(true);

        observer = new Vector(-50, -50, 220);
        ls = new LightEmitter(0.7, new Vector(200, 180, -450), 0.9);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        draw(material, 200, g);
        draw(material2, 600, g);
        draw(material3, 1000, g);
    }

        private void draw(Material m, int s, Graphics g) {
            Vector normal;
            for(int i = -r; i <= r; i++) {
                double x = i + 0.5;
                for(int j = -2*r; j <= 2*r; j++) {
                    double y = j/2.0 + 0.5;
                    if(x*x + y*y <= r*r) {
                        double z = Math.sqrt(r * r - x * x - y * y);
                        normal = new Vector(2*x, 2*y, 2*z);
                        double il = PhongModel.getLight(observer,  normal, ls,  m);
                        Color color = m.getColor();
                        g.setColor(new Color(Math.min((int) (color.getRed()* il), 255),
                                Math.min((int)(color.getGreen()* il), 255),
                                Math.min((int)(color.getBlue()* il), 255))
                        );
                        g.drawRect(i + r + s, (j/2) + r + 200, 1, 1);
                    }
                }
            }
        }
    }

package main;

import java.awt.*;

public class Material {
    private double ka;
    private double kd;
    private double ks;

    private double n;
    private Color color;

    public Material(double ka, double kd, double ks, double n, Color color) {
        this.ka = ka;
        this.kd = kd;
        this.ks = ks;

        this.n = n;
        this.color = color;
    }

    public double getKa() {
        return ka;
    }
    public double getKd() {
        return kd;
    }
    public double getKs() {
        return ks;
    }

    public double getN() {
        return n;
    }

    public Color getColor() {
        return color;
    }
}

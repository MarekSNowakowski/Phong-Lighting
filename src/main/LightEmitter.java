package main;

public class LightEmitter {
    private double illumination;
    private double ambient;
    private Vector vector;

    public LightEmitter(double ambient, Vector v, double illumination)
    {
        this.ambient = ambient;
        this.vector = v;
        this.illumination = illumination;
    }

    public Vector getVector() {
        return vector;
    }

    public double getAmbient() {
        return ambient;
    }

    public double getIllumination() {
        return illumination;
    }
}

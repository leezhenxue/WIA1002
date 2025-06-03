package LabTest1;

public class Cone implements Geometric {
    private double r;
    private double h;

    Cone(double r, double h) {
        this.r = r;
        this.h = h;
    }

    @Override
    public double calculateVolume() {
        double V = (1.0 / 3.0) * Math.PI * r * r * h;
        return V;
    }

    @Override
    public double calculateSurfaceArea() {
        double S = Math.PI * r * (r + Math.sqrt(r*r*h*h));
        return S;
    }
}

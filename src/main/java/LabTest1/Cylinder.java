package LabTest1;

public class Cylinder implements Geometric {
    private double r;
    private double h;

    Cylinder(double r, double h) {
        this.r = r;
        this.h = h;
    }

    @Override
    public double calculateVolume() {
        double V = Math.PI * r * r * h;
        return V;
    }

    @Override
    public double calculateSurfaceArea() {
        double S = 2 * Math.PI * r * r + 2 * Math.PI * r * h;
        return S;
    }

}

package LabTest1;

public class Sphere implements Geometric {
    private double r;

    Sphere(double r) {
        this.r = r;
    }

    @Override
    public double calculateVolume() {
        double V = (4.0 / 3) * Math.PI * Math.pow(r, 3);
        return V;
    }

    @Override
    public double calculateSurfaceArea() {
        double S = 4 * Math.PI * r * r;
        return S;
    }
}

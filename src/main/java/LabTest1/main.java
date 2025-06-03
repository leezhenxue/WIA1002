package LabTest1;

public class main {
    public static void main(String[] args) {
        Sphere sphere = new Sphere(5);
        Cylinder cylinder = new Cylinder(5, 10);
        Cone cone = new Cone(5, 10);

        System.out.printf("%s%.4f\n", "Sphere Volume: ", sphere.calculateVolume());
        System.out.printf("%s%.4f\n","Sphere Surface Area: ", sphere.calculateSurfaceArea());
        System.out.printf("%s%.4f\n","Cylinder Volume: ", cylinder.calculateVolume());
        System.out.printf("%s%.4f\n","Cylinder Surface Area: ", cylinder.calculateSurfaceArea());
        System.out.printf("%s%.4f\n","Cone Volume: ", cone.calculateVolume());
        System.out.printf("%s%.4f\n","Cone Surface Area: ", cone.calculateSurfaceArea());
    }
}

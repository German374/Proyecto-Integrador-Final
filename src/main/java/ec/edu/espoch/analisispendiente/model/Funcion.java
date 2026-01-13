package ec.edu.espoch.analisispendiente.model;

public class Funcion {
    private double a;
    private double b;
    private double c;

    public Funcion(double a, double b) {
        this.a = a;
        this.b = b;
        this.c = 0;
    }

    public Funcion(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() { return a; }
    public double getB() { return b; }
    public double getC() { return c; }
}












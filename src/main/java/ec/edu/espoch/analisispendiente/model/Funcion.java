package ec.edu.espoch.analisispendiente.model;

public class Funcion {

    private double a, b, c;
    private String tipo;

    // Constructor para función lineal
    public Funcion(double a, double b) {
        this.a = a;
        this.b = b;
        this.c = 0;
        this.tipo = "Función Lineal";
    }

    // Constructor para función cuadrática
    public Funcion(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.tipo = "Función Cuadrática";
    }

    public double getA(){ 
        return a; 
    }
    public double getB() {
        return b; 
    }
    public double getC() {
        return c; 
    }
    public String getTipo() {
        return tipo; 
    }

    // Método estático para crear objetos según el tipo de función
    public static Funcion crearFuncion(String tipoFuncion, double a, double b, double c) {
        if ("Función Cuadrática".equals(tipoFuncion)) {
            return new Funcion(a, b, c);
        } else {
            return new Funcion(a, b);
        }
    }
}














package ec.edu.espoch.analisispendiente.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import ec.edu.espoch.analisispendiente.App;

public class SecondaryController {

    @FXML
    private TextArea txtCalculo;

    @FXML
    private void volverAPrimary() throws Exception {
        App.cambiarVista("Primary");
    }

    private String tipoFuncion;
    private double a, b, c;

    public void recibirDatos(String tipoFuncion, double a, double b, double c) {
        this.tipoFuncion = tipoFuncion;
        this.a = a;
        this.b = b;
        this.c = c;

        mostrarCalculo();
    }

    private void mostrarCalculo() {
        StringBuilder sb = new StringBuilder();

        sb.append("Valores ingresados: a = ").append(a)
                .append(", b = ").append(b)
                .append(", c = ").append(c).append("\n\n");

        if ("Función Lineal".equals(tipoFuncion)) {
            double pendiente = a;
            sb.append("Función Lineal: f(x) = ").append(a).append("x + ").append(b).append("\n");
            sb.append("Primera derivada: f'(x) = ").append(pendiente).append("\n");
            sb.append("Segunda derivada: f''(x) = 0\n");
            sb.append("Pendiente indica que la función es ");
            sb.append(pendiente > 0 ? "creciente" : (pendiente < 0 ? "decreciente" : "constante")).append("\n");
        } else {
            double derivada1 = 2 * a * 0 + b;
            double derivada2 = 2 * a;
            double puntoCritico = -b / (2 * a);
            String tipoExtremo = derivada2 > 0 ? "mínimo" : "máximo";

            sb.append("Función Cuadrática: f(x) = ").append(a).append("x² + ").append(b).append("x + ").append(c).append("\n");
            sb.append("Primera derivada: f'(x) = ").append(derivada1).append(" + 2*").append(a).append("x\n");
            sb.append("Segunda derivada: f''(x) = ").append(derivada2).append("\n");
            sb.append("Punto crítico: x = ").append(puntoCritico).append("\n");
            sb.append("La función tiene un ").append(tipoExtremo).append(" en el punto crítico.\n");
            sb.append("Pendiente en x = 0: ").append(derivada1).append("\n");
        }

        txtCalculo.setText(sb.toString());
    }

    @FXML
    private void volver() throws Exception {
        App.cambiarVista("Primary");
    }
}





















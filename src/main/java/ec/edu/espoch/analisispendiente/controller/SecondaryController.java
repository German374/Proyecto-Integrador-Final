package ec.edu.espoch.analisispendiente.controller;

import ec.edu.espoch.analisispendiente.App;
import ec.edu.espoch.analisispendiente.model.Funcion;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class SecondaryController {

    @FXML
    private TextArea txtCalculo;

    private Funcion funcion;
    private String tipoFuncion;

    public void recibirDatos(Funcion funcion, String tipoFuncion) {
        this.funcion = funcion;
        this.tipoFuncion = tipoFuncion;
        mostrarCalculo();
    }

    private void mostrarCalculo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Valores ingresados: a = ").append(funcion.getA())
          .append(", b = ").append(funcion.getB())
          .append(", c = ").append(funcion.getC()).append("\n\n");

        if ("Función Lineal".equals(tipoFuncion)) {
            double pendiente = funcion.getA();
            sb.append("Función Lineal: f(x) = ").append(funcion.getA()).append("x + ").append(funcion.getB()).append("\n");
            sb.append("Primera derivada: f'(x) = ").append(pendiente).append("\n");
            sb.append("Segunda derivada: f''(x) = 0\n");
            sb.append("Pendiente indica que la función es ");
            sb.append(pendiente > 0 ? "creciente" : (pendiente < 0 ? "decreciente" : "constante")).append("\n");
        } else {
            double derivada1 = 2 * funcion.getA() * 0 + funcion.getB();
            double derivada2 = 2 * funcion.getA();
            double puntoCritico = -funcion.getB() / (2 * funcion.getA());
            String tipoExtremo = derivada2 > 0 ? "mínimo" : "máximo";

            sb.append("Función Cuadrática: f(x) = ").append(funcion.getA()).append("x² + ").append(funcion.getB())
              .append("x + ").append(funcion.getC()).append("\n");
            sb.append("Primera derivada: f'(x) = ").append(derivada1).append(" + 2*").append(funcion.getA()).append("x\n");
            sb.append("Segunda derivada: f''(x) = ").append(derivada2).append("\n");
            sb.append("Punto crítico: x = ").append(puntoCritico).append("\n");
            sb.append("La función tiene un ").append(tipoExtremo).append(" en el punto crítico.\n");
            sb.append("Pendiente en x = 0: ").append(derivada1).append("\n");
        }

        txtCalculo.setText(sb.toString());
    }

    @FXML
    private void volverAPrimary() throws Exception {
        App.cambiarVista("Primary");
    }
}






















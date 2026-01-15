package ec.edu.espoch.analisispendiente.controller;

import ec.edu.espoch.analisispendiente.App;
import ec.edu.espoch.analisispendiente.model.Funcion;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class SecondaryController {

    @FXML
    private TextArea txtCalculo;

    public void recibirDatos(Funcion funcion) {
        txtCalculo.setText(funcion.generarCalculo());
    }

    @FXML
    private void volverAPrimary() throws Exception {
        App.cambiarVista("Primary");
    }
}

























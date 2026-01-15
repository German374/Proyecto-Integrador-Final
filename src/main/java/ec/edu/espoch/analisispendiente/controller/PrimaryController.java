package ec.edu.espoch.analisispendiente.controller;

import ec.edu.espoch.analisispendiente.model.Funcion;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class PrimaryController {

    @FXML
    private ComboBox<String> cbTipoFuncion;

    @FXML
    private TextField txtA;
    
    @FXML
    private TextField txtB;
    
    @FXML
    private TextField txtC;

    @FXML
    private TextArea txtAnalisis;

    private double a, b, c;
    private String tipoFuncion;

    private final String PASSWORD = "1234";


    @FXML
    public void initialize() {

        cbTipoFuncion.setItems(
            FXCollections.observableArrayList(
                "Función Lineal",
                "Función Cuadrática"
            )
        );

        txtA.setDisable(true);
        txtB.setDisable(true);
        txtC.setDisable(true);

        cbTipoFuncion.setOnAction(e -> seleccionarFuncion());
    }


    @FXML
    private void seleccionarFuncion() {

        tipoFuncion = cbTipoFuncion.getValue();

        txtA.setDisable(false);
        txtB.setDisable(false);
        txtC.setDisable(!"Función Cuadrática".equals(tipoFuncion));
    }


    @FXML
    private void analizarFuncion() {

        try {

            a = Double.parseDouble(txtA.getText());
            b = Double.parseDouble(txtB.getText());
            c = txtC.isDisabled() ? 0 : Double.parseDouble(txtC.getText());


            Funcion funcion = Funcion.crearFuncion(tipoFuncion, a, b, c);


            txtAnalisis.setText(funcion.analizarFuncion());

        } catch (NumberFormatException e) {
            txtAnalisis.setText("Error: ingrese valores numéricos válidos.");
        }
    }


    @FXML
    private void verCalculo() throws Exception {

        Funcion funcion = Funcion.crearFuncion(tipoFuncion, a, b, c);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ec/edu/espoch/analisispendiente/view/Secondary.fxml"));

        Scene scene = new Scene(loader.load());
        SecondaryController controller = loader.getController();

        controller.recibirDatos(funcion);

        Stage stage = (Stage) txtAnalisis.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    private void limpiar() {

        TextInputDialog dialog = new TextInputDialog();
        dialog.setHeaderText("Ingrese la contraseña para limpiar");

        dialog.showAndWait().ifPresent(pass -> {

            if (pass.equals(PASSWORD)) {

                txtA.clear();
                txtB.clear();
                txtC.clear();
                txtAnalisis.clear();

                cbTipoFuncion.setValue(null);

                txtA.setDisable(true);
                txtB.setDisable(true);
                txtC.setDisable(true);

            } else {
                txtAnalisis.setText("Contraseña incorrecta.");
            }
        });
    }
}































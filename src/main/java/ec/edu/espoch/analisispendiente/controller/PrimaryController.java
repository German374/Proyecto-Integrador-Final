package ec.edu.espoch.analisispendiente.controller;

import ec.edu.espoch.analisispendiente.App;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;

public class PrimaryController {

    @FXML
    private ComboBox<String> cbTipoFuncion;

    @FXML
    private TextField txtA, txtB, txtC;

    @FXML
    private TextArea txtAnalisis;

    private double a, b, c;
    private String tipoFuncion;
    private final String PASSWORD = "1234";

    @FXML
    public void initialize() {
        cbTipoFuncion.setItems(FXCollections.observableArrayList(
                "Función Lineal",
                "Función Cuadrática"
        ));

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

            String analisis;
            String tipoRuta = "";
            String inclinacion = "";
            String esfuerzo = "";

            if (b == 0) {
                analisis = "La ruta es vertical (b = 0), por lo que no se puede definir una pendiente ni realizar el análisis de inclinación.";
            } else {
                double m = -a / b;

                if (m > 0) {
                    tipoRuta = "ascendente";
                } else if (m < 0) {
                    tipoRuta = "descendente";
                } else {
                    tipoRuta = "plana";
                }

                if (Math.abs(m) < 0.3) {
                    inclinacion = "suave";
                    esfuerzo = "bajo";
                } else if (Math.abs(m) <= 0.7) {
                    inclinacion = "moderada";
                    esfuerzo = "medio";
                } else {
                    inclinacion = "empinada";
                    esfuerzo = "alto";
                }

                analisis = "Con los valores ingresados (a = " + a + ", b = " + b + ", c = " + c +
                        "), se obtiene una pendiente " + m +
                        ", lo que indica un trayecto " + tipoRuta +
                        " con una inclinación " + inclinacion + ". Debido a esta característica, " +
                        "el recorrido requiere un esfuerzo " + esfuerzo + " y un mayor control, " +
                        "por lo que la ruta debe ser evaluada con precaución para el ingreso.";
            }

            txtAnalisis.setText(analisis);

        } catch (NumberFormatException e) {
            txtAnalisis.setText("Error: ingrese valores numéricos válidos.");
        }
    }

    // ===== CORRECCIÓN: verCalculo ahora pasa datos al SecondaryController =====
    @FXML
    private void verCalculo() throws Exception {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("/ec/edu/espoch/analisispendiente/view/Secondary.fxml"));
        Scene scene = new Scene(loader.load());

        // Obtener el controller de Secondary
        SecondaryController controller = loader.getController();
        controller.recibirDatos(tipoFuncion, a, b, c);

        // Mostrar la escena
        App.primaryStage.setScene(scene);
        App.primaryStage.show();
    }
    // =======================================================================

    @FXML
    private void verCalculoDetallado() {
        Stage stage = new Stage();
        stage.setTitle("Cálculo Detallado");

        double m = (b != 0) ? -a / b : 0;

        String tipoRuta = "";
        if (b == 0) {
            tipoRuta = "vertical";
        } else if (m > 0) {
            tipoRuta = "ascendente";
        } else if (m < 0) {
            tipoRuta = "descendente";
        } else {
            tipoRuta = "plana";
        }

        String inclinacion = "";
        String esfuerzo = "";
        if (Math.abs(m) < 0.3) {
            inclinacion = "suave";
            esfuerzo = "bajo";
        } else if (Math.abs(m) <= 0.7) {
            inclinacion = "moderada";
            esfuerzo = "medio";
        } else {
            inclinacion = "empinada";
            esfuerzo = "alto";
        }

        VBox root = new VBox(10);
        root.setPadding(new Insets(15));
        root.getChildren().addAll(
                new Label("Tipo de función: " + tipoFuncion),
                new Label("Valor de a: " + a),
                new Label("Valor de b: " + b),
                new Label("Valor de c: " + c),
                new Label("Pendiente m: " + m),
                new Label("Tipo de ruta: " + tipoRuta),
                new Label("Inclinación: " + inclinacion),
                new Label("Esfuerzo requerido: " + esfuerzo)
        );

        Scene scene = new Scene(root, 350, 250);
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
























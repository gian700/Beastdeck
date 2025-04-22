package es.ies.puerto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class QuizController {

    private int opcionesCorrectas;

    @FXML
    private Button opcion1;

    @FXML
    private Button opcion2;

    @FXML
    private Button opcion3;

    @FXML
    private Button opcion4;

    @FXML
    private TextField pregunta;
    
    @FXML
    private Button siguiente;

    private List<Button> botones;

    @FXML
    protected void initialize() {
        botones = new ArrayList<>(Arrays.asList(opcion1,opcion2,opcion3,opcion4));
    }

    @FXML
    protected void pulsar(ActionEvent event){
        Button boton = (Button) event.getSource();
        if (boton.getStyle() != "") {
            boton.setStyle(null);
            return;
        }
        if (BotonesPulsados()==2) {
            return;
        }
        boton.setStyle("-fx-background-color: #19e66b");
    }

    private int BotonesPulsados(){
        int pulsados = 0;
        for (Button button : botones) {
            if (button.getStyle() != "") {
                pulsados++;
            }
        }
        return pulsados;
    }

}

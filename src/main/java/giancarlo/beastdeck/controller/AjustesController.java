package giancarlo.beastdeck.controller;

import java.util.ArrayList;
import java.util.List;

import giancarlo.beastdeck.config.ConfigManager;
import giancarlo.beastdeck.controller.abstracta.AbstractController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class AjustesController extends AbstractController{

    @FXML
    private ComboBox comboIdioma;

    @FXML 
    private Button  volverBoton;

    @FXML
    public void initialize() {
        List<String> idiomas = new ArrayList<>();
        idiomas.add("Español");
        idiomas.add("Ingles");
        comboIdioma.getItems().addAll(idiomas);
        if (ConfigManager.ConfigProperties.getProperty("ajustesBoton") == null) {return;}
        volverBoton.setText(ConfigManager.ConfigProperties.getProperty("volver"));
        comboIdioma.setPromptText(ConfigManager.ConfigProperties.getProperty("idioma"));
    }

    @FXML
    protected void cambiarIdioma() {
        String path = "src/main/resources/idiomas/"+comboIdioma.getValue().toString()+".properties";

        ConfigManager.ConfigProperties.setPath(path);
        volverBoton.setText(ConfigManager.ConfigProperties.getProperty("volver"));
        comboIdioma.setPromptText(ConfigManager.ConfigProperties.getProperty("idioma"));

    }

    @FXML
    protected void volver() {
        cambiarPagina(volverBoton, "inicio");
    }

}

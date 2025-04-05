package giancarlo.beastdeck.controller;

import giancarlo.beastdeck.config.ConfigManager;
import giancarlo.beastdeck.controller.abstracta.AbstractController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class InicioController extends AbstractController{
    @FXML
    private Button ajustesBoton;

    @FXML
    private Button newRunBoton;

    @FXML
    private Button coleccionBoton;

    @FXML
    private Button logrosBroton;

    @FXML
    private Button usuarioBoton;

    @FXML
    public void initialize() {
        if (ConfigManager.ConfigProperties.getProperty("ajustesBoton") == null) {
            return;
        }
        ajustesBoton.setText(ConfigManager.ConfigProperties.getProperty("ajustesBoton"));
        newRunBoton.setText(ConfigManager.ConfigProperties.getProperty("newRunBoton"));
        coleccionBoton.setText(ConfigManager.ConfigProperties.getProperty("coleccionBoton"));
        logrosBroton.setText(ConfigManager.ConfigProperties.getProperty("logrosBroton"));
        usuarioBoton.setText(ConfigManager.ConfigProperties.getProperty("usuarioBoton"));
    }

    @FXML
    public void ajustesClick(){
        cambiarPagina(ajustesBoton, "ajustes");
    }

    @FXML
    public void newRunClick(){
        cambiarPagina(newRunBoton, "combate");
    }

    @FXML
    public void coleccionClick(){
        cambiarPagina(coleccionBoton, "coleccion");
    }

    @FXML
    public void logrosClick(){
        cambiarPagina(logrosBroton,"logros");
    }

    @FXML
    public void usuariosClick(){
        cambiarPagina(usuarioBoton, "usuarios");
    }
}

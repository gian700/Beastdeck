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
    protected void initialize() {
        ConfigManager.ConfigProperties.setPath(ConfigManager.ConfigProperties.getPath());
        ajustesBoton.setText(ConfigManager.ConfigProperties.getProperty("ajustes"));
        newRunBoton.setText(ConfigManager.ConfigProperties.getProperty("newRun"));
        coleccionBoton.setText(ConfigManager.ConfigProperties.getProperty("coleccion"));
        logrosBroton.setText(ConfigManager.ConfigProperties.getProperty("logros"));
        usuarioBoton.setText(ConfigManager.ConfigProperties.getProperty("usuario"));
    }

    @FXML
    protected void ajustesClick(){
        cambiarPagina(ajustesBoton, "ajustes");
    }

    @FXML
    protected void newRunClick(){

        cambiarPagina(newRunBoton, "mapa");
    }

    @FXML
    protected void coleccionClick(){
        cambiarPagina(coleccionBoton, "coleccion");
    }

    @FXML
    protected void logrosClick(){
        cambiarPagina(logrosBroton,"logros");
    }

    @FXML
    protected void usuariosClick(){
        if (ConfigManager.ConfigProperties.getUsuario()==null) {
            cambiarPagina(usuarioBoton, "login");
        }
        usuarioBoton.setText(ConfigManager.ConfigProperties.getProperty("yaRegistrado"));
    }
}

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
        if (ConfigManager.ConfigProperties.getProperty("ajustes") == null) {return;}
        ajustesBoton.setText(ConfigManager.ConfigProperties.getProperty("ajustes"));
        newRunBoton.setText(ConfigManager.ConfigProperties.getProperty("newRun"));
        coleccionBoton.setText(ConfigManager.ConfigProperties.getProperty("coleccion"));
        logrosBroton.setText(ConfigManager.ConfigProperties.getProperty("logros"));
        usuarioBoton.setText(ConfigManager.ConfigProperties.getProperty("usuario"));
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
        if (ConfigManager.ConfigProperties.getUsuario()==null) {
            cambiarPagina(usuarioBoton, "login");
        }
        usuarioBoton.setText("Ya estas registrado");
        if (ConfigManager.ConfigProperties.getProperty("registrado") != null) {
            usuarioBoton.setText(ConfigManager.ConfigProperties.getProperty("yaRegistrado"));
        }
    }
}

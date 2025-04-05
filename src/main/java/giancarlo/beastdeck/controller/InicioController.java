package giancarlo.beastdeck.controller;

import giancarlo.beastdeck.controller.abstracta.AbstractController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class InicioController extends AbstractController{
    @FXML
    private Button ajustesBoton;

    @FXML
    private Button newRunClick;

    @FXML
    private Button coleccionBoton;

    @FXML
    private Button logrosBroton;

    @FXML
    private Button usuarioBoton;

    @FXML
    public void ajustesClick(){
        cambiarPagina("ajustes");
    }

    @FXML
    public void newRunClick(){
        cambiarPagina("combate");
    }

    @FXML
    public void coleccionClick(){
        cambiarPagina("coleccion");
    }

    @FXML
    public void logrosClick(){
        cambiarPagina("logros");
    }

    @FXML
    public void usuariosClick(){
        cambiarPagina("usuarios");
    }
}

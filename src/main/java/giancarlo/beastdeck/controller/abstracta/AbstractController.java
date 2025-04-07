package giancarlo.beastdeck.controller.abstracta;

import java.io.IOException;

import giancarlo.beastdeck.PrincipalApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
/**
 * @author Giancarlo
 * @version 1.0.0
 */
public abstract class AbstractController {
    
    /**
     * Metodo que permite cambiar la pagina
     * @param boton
     * @param pagina
     */
    protected void cambiarPagina(Button boton, String pagina) {
        cambiarPagina(boton, pagina, 500, 600);
    }

    protected void cambiarPagina(Button boton, String pagina, int width, int heigh) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource(pagina+".fxml"));
            Scene scene = new Scene(fxmlLoader.load(), width, heigh);
            Stage stage = (Stage) boton.getScene().getWindow();
            stage.setResizable(false);
            stage.setTitle(pagina);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
}

package giancarlo.beastdeck.controller.abstracta;

import java.io.IOException;

import giancarlo.beastdeck.PrincipalApplication;
import giancarlo.beastdeck.model.enums.EnumTipos;
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
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource(pagina+".fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) boton.getScene().getWindow();
            stage.setResizable(false);
            scene.getStylesheets().add(getClass().getResource("/estilos/styles.css").toExternalForm());
            stage.setTitle(pagina);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected String color(EnumTipos tipo){
        switch (tipo) {
            case FUEGO -> {
                return "#ff0000";
            }

            case AGUA -> {
                return "#0000ff";
            }

            case PLANTA -> {
                return "#00ff00";
            }

            case TIERRA -> {
                return "#804000";
            }

            case ELECTRICO -> {
                return "#ffea00";
            }

            case VOLADOR -> {
                return "#9b9b9b";
            }

            case BESTIA -> {
                return "#332233";
            }
        }
        return null;
    }
    
}

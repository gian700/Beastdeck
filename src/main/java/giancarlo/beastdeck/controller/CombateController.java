package giancarlo.beastdeck.controller;

import giancarlo.beastdeck.config.ConfigManager;
import giancarlo.beastdeck.model.clases.Combate;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class CombateController {

    @FXML
    private ImageView imageView1;

    @FXML
    private Button boton1;

    @FXML
    private ImageView imageView2;

    @FXML
    private Button boton2;

    @FXML
    private ImageView imageView3;

    @FXML
    private Button boton3;

    @FXML
    private ImageView imageView4;

    @FXML
    private Button boton4;

    @FXML
    private ImageView imageView5;

    @FXML
    private Button boton5;

    @FXML
    private ImageView imageView6;

    @FXML
    private Button boton6;

    @FXML
    private ImageView imageView7;

    @FXML
    private Button boton7;

    @FXML
    private ImageView imageView8;

    @FXML
    private Button boton8;

    @FXML
    private ImageView imageViewGrande;

    @FXML
    private ImageView imageViewPropio;

    @FXML
    private Button botonPropio;

    @FXML
    private ImageView imageViewRival;

    @FXML
    private Button botonRival;

    @FXML
    private Button usarBoton;

    @FXML
    private Button activarBoton;

    @FXML
    private Text textMensage;

    @FXML
    private TextArea descripcionText;

    private Combate combate;

    @FXML
    protected void initialize() {
        combate = new Combate(ConfigManager.ConfigObjects.getJugador(), ConfigManager.ConfigObjects.getRival());
        
        cambiarImagen();
        
        
    }

    protected void cambiarImagen(int posicion){
    }

    protected void cambiarImagen(){
        //TODO: esto que se quede comentado hasta agregar las cartas al deck;
        /*
        imageView1.setImage(new Image("file:src/main/resources/imagenes/" + combate.getDeckPropio().get(0).getImagen()));
        imageView2.setImage(new Image("file:src/main/resources/imagenes/" + combate.getDeckPropio().get(1).getImagen()));
        imageView3.setImage(new Image("file:src/main/resources/imagenes/" + combate.getDeckPropio().get(2).getImagen()));
        imageView4.setImage(new Image("file:src/main/resources/imagenes/" + combate.getDeckPropio().get(3).getImagen()));
        imageView5.setImage(new Image("file:src/main/resources/imagenes/" + combate.getDeckRival().get(0).getImagen()));
        imageView6.setImage(new Image("file:src/main/resources/imagenes/" + combate.getDeckRival().get(1).getImagen()));
        imageView7.setImage(new Image("file:src/main/resources/imagenes/" + combate.getDeckRival().get(2).getImagen()));
        imageView8.setImage(new Image("file:src/main/resources/imagenes/" + combate.getDeckRival().get(3).getImagen()));
        */
    }
}

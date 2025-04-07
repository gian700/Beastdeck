package giancarlo.beastdeck.controller;

import giancarlo.beastdeck.config.ConfigManager;
import giancarlo.beastdeck.controller.abstracta.AbstractController;
import giancarlo.beastdeck.model.clases.Carta;
import giancarlo.beastdeck.model.clases.Combate;
import giancarlo.beastdeck.model.enums.EnumTipos;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

/*
 * @author Giancarlo
 * @version 1.0.0
 */
public class CombateController extends AbstractController{

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

    private Carta cartaSeleccionada;

    @FXML
    protected void initialize() {
        combate = new Combate(ConfigManager.ConfigObjects.getJugador(), ConfigManager.ConfigObjects.getRival());
        cambiarImagen();
    }

    protected void cambiarImagen(Button boton, int posicion){
        Carta carta;
        if (posicion<4) {
            carta = combate.getDeckPropio().get(posicion);
        }else{
            posicion -= 4;
            carta = combate.getDeckRival().get(posicion);
        }
        imageViewGrande.setImage(new Image("file:src/main/resources/imagenes/" + carta.getImagen()));
        descripcionText.setText(carta.toString());
        cartaSeleccionada = carta;
    }

    protected void cambiarImagen(){
        //TODO: se rompe si alguna imagen no existe, asegurarse de que no puedes llegar sin validar
        
        imageView1.setImage(new Image("file:src/main/resources/imagenes/" + combate.getDeckPropio().get(0).getImagen()));
        boton1.setStyle("-fx-background-color: "+color(combate.getDeckPropio().get(0)));
        imageView2.setImage(new Image("file:src/main/resources/imagenes/" + combate.getDeckPropio().get(1).getImagen()));
        boton2.setStyle("-fx-background-color: "+color(combate.getDeckPropio().get(1)));
        imageView3.setImage(new Image("file:src/main/resources/imagenes/" + combate.getDeckPropio().get(2).getImagen()));
        boton3.setStyle("-fx-background-color: "+color(combate.getDeckPropio().get(2)));
        imageView4.setImage(new Image("file:src/main/resources/imagenes/" + combate.getDeckPropio().get(3).getImagen()));
        boton4.setStyle("-fx-background-color: "+color(combate.getDeckPropio().get(3)));
        imageView5.setImage(new Image("file:src/main/resources/imagenes/" + combate.getDeckRival().get(0).getImagen()));
        boton5.setStyle("-fx-background-color: "+color(combate.getDeckRival().get(0)));
        imageView6.setImage(new Image("file:src/main/resources/imagenes/" + combate.getDeckRival().get(1).getImagen()));
        boton6.setStyle("-fx-background-color: "+color(combate.getDeckRival().get(1)));
        imageView7.setImage(new Image("file:src/main/resources/imagenes/" + combate.getDeckRival().get(2).getImagen()));
        boton7.setStyle("-fx-background-color: "+color(combate.getDeckRival().get(2)));
        imageView8.setImage(new Image("file:src/main/resources/imagenes/" + combate.getDeckRival().get(3).getImagen()));
        boton8.setStyle("-fx-background-color: "+color(combate.getDeckRival().get(3))); 
    }

    protected String color(Carta carta){
        EnumTipos tipo = carta.getTipo();
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

    @FXML
    protected void boton1Click(){
        cambiarImagen(boton1, 0);
    }

    @FXML
    protected void boton2Click(){
        cambiarImagen(boton2, 1);
    }

    @FXML
    protected void boton3Click(){
        cambiarImagen(boton3, 2);
    }

    @FXML
    protected void boton4Click(){
        cambiarImagen(boton4, 3);
    }

    @FXML
    protected void boton5Click(){
        cambiarImagen(boton5, 4);
    }

    @FXML
    protected void boton6Click(){
        cambiarImagen(boton6, 5);
    }

    @FXML
    protected void boton7Click(){
        cambiarImagen(boton7, 6);
    }

    @FXML
    protected void boton8Click(){
        cambiarImagen(boton8, 7);
    }
}

package giancarlo.beastdeck.controller;

import java.util.ArrayList;
import java.util.List;

import giancarlo.beastdeck.config.ConfigManager;
import giancarlo.beastdeck.controller.abstracta.AbstractController;
import giancarlo.beastdeck.model.clases.Carta;
import giancarlo.beastdeck.model.clases.Combate;
import javafx.event.ActionEvent;
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

    //@FXML
    //private Button botonRival;

    @FXML
    private Button usarBoton;

    @FXML
    private Button activarBoton;

    @FXML
    private Text textMensage;

    @FXML
    private Text puntuacionRival;

    @FXML
    private Text puntuacionPropia;

    @FXML
    private TextArea descripcionText;

    private Combate combate;

    private Carta cartaSeleccionada;

    private int posicion;

    @FXML
    protected void initialize() {
        usarBoton.setText(ConfigManager.ConfigProperties.getProperty("usar"));
        activarBoton.setText(ConfigManager.ConfigProperties.getProperty("activar"));
        combate = new Combate(ConfigManager.ConfigObjects.getJugador(), ConfigManager.ConfigObjects.getRival());
        cambiarImagen();
    }

    

    @FXML
    protected void botonVerCarta(ActionEvent event){
        Button boton = (Button) event.getSource();
        String id = boton.getId();

        switch (id) {
            case "boton1" -> cambiarImagen(boton, 0);
            case "boton2" -> cambiarImagen(boton, 1);
            case "boton3" -> cambiarImagen(boton, 2);
            case "boton4" -> cambiarImagen(boton, 3);
            case "boton5" -> cambiarImagen(boton, 4);
            case "boton6" -> cambiarImagen(boton, 5);
            case "boton7" -> cambiarImagen(boton, 6);
            case "boton8" -> cambiarImagen(boton, 7);
        }
    }


    @FXML
    protected void usarClick() {
        if (cartaSeleccionada == null){
            textMensage.setText(ConfigManager.ConfigProperties.getProperty("noCarta"));
            return;
        }

        if (posicion >3) {
            textMensage.setText(ConfigManager.ConfigProperties.getProperty("cartaRival"));
            return;
        }
    
        if (cartaSeleccionada.getUtilizada()) {
            textMensage.setText(ConfigManager.ConfigProperties.getProperty("utilizada"));
            return;
        }

        int opcionRival = combate.getRival().mejorOpcion(combate.getDeckPropio());
        Carta cRival = combate.getDeckRival().get(opcionRival);
        cRival.setUtilizada(true);
        cartaSeleccionada.setUtilizada(true);
        combate.ronda(cartaSeleccionada, cRival);
        cambiarImagen(opcionRival);
        descripcionText.setText(cartaSeleccionada.toString());
        puntuacionPropia.setText(""+combate.getPuntuacionPropia());
        puntuacionRival.setText(""+combate.getPuntuacionRival());

        if (combate.getTurno()==0) {
            if (combate.getPuntuacionPropia()>combate.getPuntuacionRival()) {
                activarBoton.setText(ConfigManager.ConfigProperties.getProperty("ganar"));
            }else{
                activarBoton.setText(ConfigManager.ConfigProperties.getProperty("perder"));
            }
        }
         
    }

    protected void cambiarImagen(int posicionRival){
        cambiarEstado(false);
        cambiarImagen();

        switch (posicion) {
            case 0 -> { 
                imageView1.setImage(null);
                boton1.setStyle("-fx-background-color: #000");
                boton1.setDisable(true);
            }
            case 1 -> { 
                imageView2.setImage(null);
                boton2.setStyle("-fx-background-color: #000");
                boton2.setDisable(true);
            }
            case 2 -> { 
                imageView3.setImage(null);
                boton3.setStyle("-fx-background-color: #000");
                boton3.setDisable(true);
            }
            case 3 -> { 
                imageView4.setImage(null);
                boton4.setStyle("-fx-background-color: #000");
                boton4.setDisable(true);
            }
        }
        switch (posicionRival){ 
            case 0 -> { 
                imageView5.setImage(null);
                boton5.setStyle("-fx-background-color: #000");
                boton5.setDisable(true);
            }
            case 1 -> { 
                imageView6.setImage(null);
                boton6.setStyle("-fx-background-color: #000");
                boton6.setDisable(true);
            }
            case 2 -> { 
                imageView7.setImage(null);
                boton7.setStyle("-fx-background-color: #000");
                boton7.setDisable(true);
            }
            case 3 -> { 
                imageView8.setImage(null);
                boton8.setStyle("-fx-background-color: #000");
                boton8.setDisable(true);
            }
        }

        imageViewPropio.setImage(new Image("file:src/main/resources/imagenes/" + cartaSeleccionada.getImagen()));
        botonPropio.setStyle("-fx-background-color: " + color(cartaSeleccionada));
        Carta cRival = combate.getDeckRival().get(posicionRival);
        imageViewRival.setImage(new Image("file:src/main/resources/imagenes/" + cRival.getImagen()));
        
    }


    protected void cambiarImagen(Button boton, int posicion){

        textMensage.setText("");
        Carta carta;
        this.posicion=posicion;
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
        List<ImageView> imageViews = List.of(imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8);
        List<Button> botones = List.of(boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8);
        List<Carta> cartas = new ArrayList<>();

        cartas.addAll(combate.getDeckPropio());
        cartas.addAll(combate.getDeckRival());

        for (int i = 0; i < cartas.size(); i++) {
            Carta carta = cartas.get(i);
            imageViews.get(i).setImage(new Image("file:src/main/resources/imagenes/" + carta.getImagen()));
            botones.get(i).setStyle("-fx-background-color: " + color(carta));
        }
    }

    protected void cambiarEstado(boolean value){
        boton1.setDisable(value);
        boton2.setDisable(value);
        boton3.setDisable(value);
        boton4.setDisable(value);
        boton5.setDisable(value);
        boton6.setDisable(value);
        boton7.setDisable(value);
        boton8.setDisable(value);
    }

    public void botonActivar(){
        if (activarBoton.getText().equals(ConfigManager.ConfigProperties.getProperty("activar"))) {
            textMensage.setText(ConfigManager.ConfigProperties.getProperty("proximamente"));
            return;
        }
        cambiarPagina(activarBoton, "inicio");
    }
}

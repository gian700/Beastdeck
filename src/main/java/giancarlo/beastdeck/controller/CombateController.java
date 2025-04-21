package giancarlo.beastdeck.controller;

import java.util.ArrayList;
import java.util.List;

import giancarlo.beastdeck.config.ConfigManager;
import giancarlo.beastdeck.controller.abstracta.AbstractController;
import giancarlo.beastdeck.model.clases.Carta;
import giancarlo.beastdeck.model.clases.Combate;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.util.Duration;

/*
 * @author Giancarlo
 * @version 1.0.0
 */
public class CombateController extends AbstractController{
    @FXML private Button boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8, botonPropio, botonRival, usarBoton, activarBoton;
    @FXML private ImageView imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageViewGrande, imageViewPropio, imageViewRival;
    @FXML private TextField puntuacionRival, puntuacionPropia, puntuacionTemporalRival, puntuacionTemporalPropia;
    @FXML private Text textMensage;
    @FXML private TextArea descripcionText;
    private Combate combate;
    private Carta cartaSeleccionada;
    private int posicion;
    private Timeline animacionPuntuacionGeneral;

    @FXML
    protected void initialize() {
        usarBoton.setText(ConfigManager.ConfigProperties.getProperty("usar"));
        activarBoton.setText(ConfigManager.ConfigProperties.getProperty("activar"));
        combate = new Combate(ConfigManager.ConfigObjects.getJugador(), ConfigManager.ConfigObjects.getRival());
        cambiarImagen();
    }

    /**
     * Boton que permite ver en grande la carta seleccionada
     * @param event
     */
    @FXML
    protected void botonVerCarta(ActionEvent event){
        cancelarAnimacion();
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

    /**
     * Metodo que utiliza la carta seleccionada
     */
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
        int valorInicial = combate.getPuntuacionPropia();
        int valorInicialRival = combate.getPuntuacionRival();
        combate.ronda(cartaSeleccionada, cRival);
        cRival.setUtilizada(true);
        cartaSeleccionada.setUtilizada(true);
        cambiarImagen(opcionRival);
        descripcionText.setText(cartaSeleccionada.toString());
        puntuacionTemporalRival.setText(""+combate.getPuntuacionTemporalRival());
        puntuacionTemporalPropia.setText(""+combate.getPuntuacionTemporalPropia());
        animacionNumeros(valorInicial, valorInicialRival);
        if (combate.getTurno()<=0) {
            AlertaResultados();
        }   
    }

    /**
     * Metodo que cambia la carta seleccionada
     * @param posicionRival
     */
    protected void cambiarImagen(int posicionRival){
        cambiarEstado(false);
        cambiarImagen();

        switch (posicion) {
            case 0 -> { 
                imageView1.setImage(null);
                boton1.setStyle("-fx-background-color: #000");
                boton1.setDisable(true);
                botonPropio.setId("boton1");
            }
            case 1 -> { 
                imageView2.setImage(null);
                boton2.setStyle("-fx-background-color: #000");
                boton2.setDisable(true);
                botonPropio.setId("boton2");
            }
            case 2 -> { 
                imageView3.setImage(null);
                boton3.setStyle("-fx-background-color: #000");
                boton3.setDisable(true);
                botonPropio.setId("boton3");
            }
            case 3 -> { 
                imageView4.setImage(null);
                boton4.setStyle("-fx-background-color: #000");
                boton4.setDisable(true);
                botonPropio.setId("boton4");
            }
        }
        switch (posicionRival){ 
            case 0 -> { 
                imageView5.setImage(null);
                boton5.setStyle("-fx-background-color: #000");
                boton5.setDisable(true);
                botonRival.setId("boton5");
            }
            case 1 -> { 
                imageView6.setImage(null);
                boton6.setStyle("-fx-background-color: #000");
                boton6.setDisable(true);
                botonRival.setId("boton6");
            }
            case 2 -> { 
                imageView7.setImage(null);
                boton7.setStyle("-fx-background-color: #000");
                boton7.setDisable(true);
                botonRival.setId("boton7");
            }
            case 3 -> { 
                imageView8.setImage(null);
                boton8.setStyle("-fx-background-color: #000");
                boton8.setDisable(true);
                botonRival.setId("boton8");
            }
        }

        imageViewPropio.setImage(new Image("file:src/main/resources/imagenes/" + cartaSeleccionada.getImagen()));
        botonPropio.setStyle("-fx-background-color: " + color(cartaSeleccionada.getTipo()));
        Carta cRival = combate.getDeckRival().get(posicionRival);
        imageViewRival.setImage(new Image("file:src/main/resources/imagenes/" + cRival.getImagen()));
        botonRival.setStyle("-fx-background-color: " + color(cRival.getTipo()));
    }

    /**
     * Metodo que cambia la imagen de la carta seleccionada
     * @param boton
     * @param posicion
     */
    protected void cambiarImagen(Button boton, int posicion){

        textMensage.setText("");
        Carta carta;
        this.posicion=posicion;
        if (posicion<4) {
            carta = combate.getDeckPropio().get(posicion);
            puntuacionTemporalRival.setText("");
            puntuacionTemporalPropia.setText(""+ carta.getFuerza()*100);
        }else{
            posicion -= 4;
            carta = combate.getDeckRival().get(posicion);
            puntuacionTemporalPropia.setText("");
            puntuacionTemporalRival.setText(""+ carta.getFuerza()*100);
        }
        imageViewGrande.setImage(new Image("file:src/main/resources/imagenes/" + carta.getImagen()));
        descripcionText.setText(carta.toString());
        cartaSeleccionada = carta;
    }

    /**
     * Metodo que prepara la imagen de todas las cartas
     */
    protected void cambiarImagen(){
        List<ImageView> imageViews = List.of(imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8);
        List<Button> botones = List.of(boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8);
        List<Carta> cartas = new ArrayList<>();

        cartas.addAll(combate.getDeckPropio());
        cartas.addAll(combate.getDeckRival());

        for (int i = 0; i < cartas.size(); i++) {
            Carta carta = cartas.get(i);
            imageViews.get(i).setImage(new Image("file:src/main/resources/imagenes/" + carta.getImagen()));
            botones.get(i).setStyle("-fx-background-color: " + color(carta.getTipo()));
        }
    }

    /**
     * Metodo que cambia el estado de todos los botones
     * @param value
     */
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

    /**
     * TODO:metodo aun no hecho
     */
    @FXML
    public void botonActivar(){
        if (activarBoton.getText().equals(ConfigManager.ConfigProperties.getProperty("activar"))) {
            textMensage.setText(ConfigManager.ConfigProperties.getProperty("proximamente"));
            return;
        }
        cambiarPagina(activarBoton, "inicio");
    }

    /**
     * Metodo que permite animar los valores de puntuacion
     * @param valorInicial
     * @param valorInicialRival
     */
    protected void animacionNumeros(int valorInicial, int valorInicialRival){
        if (animacionPuntuacionGeneral != null) animacionPuntuacionGeneral.stop();

            PauseTransition pausa = new PauseTransition(Duration.millis(300));
            pausa.setOnFinished(event -> {
                Timeline anim1 = crearAnimacionPuntuacion(puntuacionPropia, valorInicial, combate.getPuntuacionPropia());
                Timeline anim2 = crearAnimacionPuntuacion(puntuacionRival, valorInicialRival, combate.getPuntuacionRival());
                Timeline anim3 = crearAnimacionPuntuacion(puntuacionTemporalPropia, combate.getPuntuacionTemporalPropia(), 0);
                Timeline anim4 = crearAnimacionPuntuacion(puntuacionTemporalRival, combate.getPuntuacionTemporalRival(), 0);
            
                animacionPuntuacionGeneral = new Timeline();
                animacionPuntuacionGeneral.getKeyFrames().addAll(anim1.getKeyFrames());
                animacionPuntuacionGeneral.getKeyFrames().addAll(anim2.getKeyFrames());
                animacionPuntuacionGeneral.getKeyFrames().addAll(anim3.getKeyFrames());
                animacionPuntuacionGeneral.getKeyFrames().addAll(anim4.getKeyFrames());
            
                animacionPuntuacionGeneral.play();
            });
            pausa.play();
    }

    /**
     * Metodo que comprueba cuando tiene que cambiar los valores
     * @param texto
     * @param inicio
     * @param fin
     * @return
     */
    protected Timeline crearAnimacionPuntuacion(TextField texto, int inicio, int fin) {
        Timeline timeline = new Timeline();
        int duracion = 900;
        int pasos = 50;
        double incremento = (double)(fin - inicio) / pasos;
    
        for (int i = 0; i <= pasos; i++) {
            int frame = i;
            KeyFrame keyFrame = new KeyFrame(
                Duration.millis(i * (duracion / pasos)),
                e -> {
                    if (puntuacionTemporalRival.getText().isEmpty()) {
                        
                        cancelarAnimacion();
                        return;
                    }

                    int valor = inicio + (int)Math.round(incremento * frame);
                    texto.setText(String.valueOf(valor));
                }
            );
            timeline.getKeyFrames().add(keyFrame);
        }
        return timeline;
    }

    /**
     * Acceso rapido para cancelar la animacion
     */
    protected void cancelarAnimacion() {
        if (animacionPuntuacionGeneral != null) {
            animacionPuntuacionGeneral.stop();
            puntuacionPropia.setText(""+combate.getPuntuacionPropia());
            puntuacionRival.setText("" +combate.getPuntuacionRival()); 
        }
    }

    /**
     * Configuracion del alert de fin del combate
     */
    protected void AlertaResultados(){
        Alert alerta = new Alert(Alert.AlertType.NONE);
        DialogPane dialogPane = alerta.getDialogPane();
        dialogPane.setPrefSize(400, 100);

        alerta.setTitle("Resultado del Combate");
        alerta.setHeaderText(null);
        ButtonType botonCerrar = new ButtonType("volver al menu");
        if (combate.getPuntuacionPropia()>combate.getPuntuacionRival()) {
            alerta.setContentText(ConfigManager.ConfigProperties.getProperty("ganar"));
        }else{
            alerta.setHeaderText(ConfigManager.ConfigProperties.getProperty("perder"));
        }
        alerta.getButtonTypes().setAll(botonCerrar);
        alerta.initOwner(activarBoton.getScene().getWindow());
    
        alerta.showAndWait(); 
        if (combate.getPuntuacionPropia()>combate.getPuntuacionRival()) {
            cambiarPagina(boton1, "mapa");
        }else{
            cambiarPagina(boton1, "inicio");
        }
    }
}

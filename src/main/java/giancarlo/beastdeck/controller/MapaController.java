package giancarlo.beastdeck.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import giancarlo.beastdeck.config.ConfigManager;
import giancarlo.beastdeck.controller.abstracta.AbstractController;
import giancarlo.beastdeck.model.clases.Carta;
import giancarlo.beastdeck.model.clases.Deck;
import giancarlo.beastdeck.model.clases.Jugador;
import giancarlo.beastdeck.model.clases.Rival;
import giancarlo.beastdeck.model.database.CartaManager;
import giancarlo.beastdeck.model.enums.EnumTipos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MapaController extends AbstractController{
    @FXML private Button opcion1, opcion2, opcion3, opcion4, opcion5, opcion6, opcion7, opcion8;

    @FXML
    protected void initialize() {
        opcion1.setStyle("-fx-background-color: " + color(EnumTipos.AGUA));
    }

    @FXML
    protected void usarClick(ActionEvent event){
        List<Carta> cartas;
        Button boton = (Button) event.getSource();
        try {
            cartas = new CartaManager().obtenerCartas();

            Collections.shuffle(cartas);
            List<Carta> cartasPropias = new ArrayList<>(Arrays.asList(cartas.get(0), cartas.get(1), cartas.get(2), cartas.get(3)));
            List<Carta> cartasRival = new ArrayList<>(Arrays.asList(cartas.get(4), cartas.get(5), cartas.get(6), cartas.get(7)));
            
            ConfigManager.ConfigObjects.setRival(new Rival(new Deck(cartasPropias)));
            ConfigManager.ConfigObjects.setJugador(new Jugador(new Deck(cartasRival)));
            cambiarPagina(boton, "combate2");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

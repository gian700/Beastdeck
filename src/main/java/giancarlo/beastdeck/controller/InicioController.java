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
import giancarlo.beastdeck.model.clases.HabilidadActiva;
import giancarlo.beastdeck.model.clases.Jugador;
import giancarlo.beastdeck.model.clases.Rival;
import giancarlo.beastdeck.model.database.CartaManager;
import giancarlo.beastdeck.model.enums.EnumRarezas;
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
        try {
            //TODO: cuando la base de datos este lista arreglar lo de abajo

            HabilidadActiva habilidadActiva1 = new HabilidadActiva(1, "Apuesta clara", "multiplica por 2 la fuerza de la carta si ganas en tipo, \npero la divide si pierdes", EnumRarezas.R, true);
            HabilidadActiva habilidadActiva1C = new HabilidadActiva(1, "Apuesta clara", "multiplica por 2 la fuerza de la carta si ganas en tipo, \npero la divide si pierdes", EnumRarezas.R, true);
            HabilidadActiva habilidadActiva2 = new HabilidadActiva(2, "Inutilidad", "baja a la mitad la fuerza del rival", EnumRarezas.C, true);
            HabilidadActiva habilidadActiva2C = new HabilidadActiva(2, "Inutilidad", "baja a la mitad la fuerza del rival", EnumRarezas.C, true);
            HabilidadActiva habilidadActiva3 = new HabilidadActiva(3, "adaptativo", "si tienes desventaja de tipo, cambia tu tipo aleatoriamente", EnumRarezas.R, true);
            List<Carta> cartas = new CartaManager().obtenerCartas();
            cartas.get(0).setHabilidadesActivas(new ArrayList<>(Arrays.asList(habilidadActiva1)));
            cartas.get(2).setHabilidadesActivas(new ArrayList<>(Arrays.asList(habilidadActiva1C, habilidadActiva2C)));
            cartas.get(3).setHabilidadesActivas(new ArrayList<>(Arrays.asList(habilidadActiva3)));
            cartas.get(6).setHabilidadesActivas(new ArrayList<>(Arrays.asList(habilidadActiva2)));
            
            //TODO: cuando la base de datos este lista arreglar lo de encima

            Collections.shuffle(cartas);
            List<Carta> cartasPropias = new ArrayList<>(Arrays.asList(cartas.get(0), cartas.get(1), cartas.get(2), cartas.get(3)));
            List<Carta> cartasRival = new ArrayList<>(Arrays.asList(cartas.get(4), cartas.get(5), cartas.get(6), cartas.get(7)));
            
            ConfigManager.ConfigObjects.setRival(new Rival(new Deck(cartasPropias)));
            ConfigManager.ConfigObjects.setJugador(new Jugador(new Deck(cartasRival)));

            
            cambiarPagina(newRunBoton, "combate", 1000, 600);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
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

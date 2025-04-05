package giancarlo.beastdeck.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import giancarlo.beastdeck.model.Carta;
import giancarlo.beastdeck.model.Deck;
import giancarlo.beastdeck.model.Rival;
import giancarlo.beastdeck.model.enums.EnumRarezas;
import giancarlo.beastdeck.model.enums.EnumTipos;

public class RivalTest {
    private Rival rival;
    private Carta carta1;
    private Carta carta2;
    private Carta carta3;
    private Carta carta4;
    private Carta carta5;
    private Carta carta6;
    private Carta carta7;
    private Carta carta8;
    private Deck deck1;
    private Deck deck2;


    @BeforeEach
    void beforeEach() {
        carta1 = new Carta(1, "nombre", "descripcion", EnumRarezas.C, EnumTipos.AGUA, new ArrayList<>(), new ArrayList<>(), 1, 0, false, false);
        carta2 = new Carta(2, "nombre", "descripcion", EnumRarezas.R, EnumTipos.AGUA, new ArrayList<>(), new ArrayList<>(), 1, 0, false, false);
        carta3 = new Carta(3, "nombre", "descripcion", EnumRarezas.C, EnumTipos.AGUA, new ArrayList<>(), new ArrayList<>(), 1, 0, false, false);
        carta4 = new Carta(4, "nombre", "descripcion", EnumRarezas.R, EnumTipos.AGUA, new ArrayList<>(), new ArrayList<>(), 1, 0, false, false);
        carta5 = new Carta(5, "nombre", "descripcion", EnumRarezas.C, EnumTipos.AGUA, new ArrayList<>(), new ArrayList<>(), 1, 0, false, false);
        carta6 = new Carta(6, "nombre", "descripcion", EnumRarezas.R, EnumTipos.FUEGO, new ArrayList<>(), new ArrayList<>(), 1, 0, false, false);
        carta7 = new Carta(7, "nombre", "descripcion", EnumRarezas.C, EnumTipos.PLANTA, new ArrayList<>(), new ArrayList<>(), 1, 0, false, false);
        carta8 = new Carta(8, "nombre", "descripcion", EnumRarezas.R, EnumTipos.TIERRA, new ArrayList<>(), new ArrayList<>(), 1, 0, false, false);
        deck1 = new Deck(new ArrayList<>(Arrays.asList(carta1, carta2, carta3, carta4)));
        deck2 = new Deck(new ArrayList<>(Arrays.asList(carta5, carta6, carta7, carta8)));
        rival = new Rival(deck2);
        
    }

    @Test
    void opcionClara() {
        int opcion = rival.mejorOpcion(deck1);
        Assertions.assertEquals(2, opcion);
    }
}

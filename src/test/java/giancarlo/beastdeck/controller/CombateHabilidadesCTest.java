package giancarlo.beastdeck.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import giancarlo.beastdeck.model.clases.Carta;
import giancarlo.beastdeck.model.clases.Combate;
import giancarlo.beastdeck.model.clases.Deck;
import giancarlo.beastdeck.model.clases.HabilidadActiva;
import giancarlo.beastdeck.model.enums.EnumRarezas;
import giancarlo.beastdeck.model.enums.EnumTipos;

public class CombateHabilidadesCTest {

    private Combate combateController;
    private Carta carta1;
    private Carta carta2;
    private Carta carta3;
    private final HabilidadActiva habilidadActiva1 = new HabilidadActiva(1, "Apuesta clara", "multiplica por 2 la fuerza de la carta si ganas en tipo, pero la divide si pierdes", true);
    private final HabilidadActiva habilidadActiva1C = new HabilidadActiva(1, "Apuesta clara", "multiplica por 2 la fuerza de la carta si ganas en tipo, pero la divide si pierdes", true);
    private final HabilidadActiva habilidadActiva2 = new HabilidadActiva(2, "Inutilidad", "baja a la mitad la fuerza del rival", true);
    private final HabilidadActiva habilidadActiva3 = new HabilidadActiva(3, "adaptativo", "si tienes desventaja de tipo, cambia tu tipo aleatoriamente", true);


    @BeforeEach
    void beforeEach() {
        combateController = new Combate();
        combateController.setDeckPropio(new Deck(new ArrayList<>()));
        combateController.setDeckRival(new Deck(new ArrayList<>()));
        carta1 = new Carta(1, "nombre", "descripcion", EnumRarezas.C, EnumTipos.AGUA, new ArrayList<>(Arrays.asList(habilidadActiva1)), new ArrayList<>(), 2, 0, false, null);
        carta2 = new Carta(2, "nombre", "descripcion", EnumRarezas.R, EnumTipos.AGUA, new ArrayList<>(), new ArrayList<>(), 2, 0, false, null);
        carta3 = new Carta(3, "nombre", "descripcion", EnumRarezas.C, EnumTipos.AGUA, new ArrayList<>(Arrays.asList(habilidadActiva1C)), new ArrayList<>(), 2, 0, false, null);
        
    }

    @Test
    void habilidad1EmpateTest() {
        combateController.ronda(carta1, carta2);
        Assertions.assertEquals(200, combateController.getPuntuacionPropia());
        Assertions.assertEquals(200, combateController.getPuntuacionRival());
    }

    @Test
    void habilidad1gana() {
        carta1.setTipo(EnumTipos.PLANTA);
        combateController.ronda(carta1, carta2);
        Assertions.assertEquals(800, combateController.getPuntuacionPropia());
        Assertions.assertEquals(100, combateController.getPuntuacionRival());
    }

    @Test
    void habilidad1Pierde() {
        carta1.setTipo(EnumTipos.FUEGO);
        combateController.ronda(carta1, carta2);
        Assertions.assertEquals(50, combateController.getPuntuacionPropia());
        Assertions.assertEquals(400, combateController.getPuntuacionRival());
    }

    @Test
    void habilidad1EmpateRivalTest() {
        combateController.ronda(carta2, carta1);
        Assertions.assertEquals(200, combateController.getPuntuacionPropia());
        Assertions.assertEquals(200, combateController.getPuntuacionRival());
    }

    @Test
    void habilidad1Rivalgana() {
        carta1.setTipo(EnumTipos.PLANTA);
        combateController.ronda(carta2, carta1);
        Assertions.assertEquals(100, combateController.getPuntuacionPropia());
        Assertions.assertEquals(800, combateController.getPuntuacionRival());
    }

    @Test
    void habilidad1RivalPierde() {
        carta1.setTipo(EnumTipos.FUEGO);
        combateController.ronda(carta2, carta1);
        Assertions.assertEquals(400, combateController.getPuntuacionPropia());
        Assertions.assertEquals(50, combateController.getPuntuacionRival());
    }

    @Test
    void habilidad1SameEmpateTest() {
        combateController.ronda(carta1, carta3);
        Assertions.assertEquals(200, combateController.getPuntuacionPropia());
        Assertions.assertEquals(200, combateController.getPuntuacionRival());
    }

    @Test
    void habilidad1SameGana() {
        carta1.setTipo(EnumTipos.PLANTA);
        combateController.ronda(carta1, carta3);
        Assertions.assertEquals(800, combateController.getPuntuacionPropia());
        Assertions.assertEquals(50, combateController.getPuntuacionRival());
    }

    @Test
    void habilidad1SamePierde() {
        carta1.setTipo(EnumTipos.FUEGO);
        combateController.ronda(carta1, carta3);
        Assertions.assertEquals(50, combateController.getPuntuacionPropia());
        Assertions.assertEquals(800, combateController.getPuntuacionRival());
    }
}

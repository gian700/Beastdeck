package giancarlo.beastdeck.controller;


import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import giancarlo.beastdeck.model.clases.Carta;
import giancarlo.beastdeck.model.clases.Combate;
import giancarlo.beastdeck.model.enums.EnumRarezas;
import giancarlo.beastdeck.model.enums.EnumTipos;


public class CombateSinHabilidadesTest {
    private Combate combateController;
    private Carta carta1;
    private Carta carta2;


    @BeforeEach
    void beforeEach() {
        combateController = new Combate();
        carta1 = new Carta(1, "nombre", "descripcion", EnumRarezas.C, EnumTipos.AGUA, new ArrayList<>(), new ArrayList<>(), 1, 5, true, null);
        carta2 = new Carta(2, "nombre", "descripcion", EnumRarezas.R, EnumTipos.AGUA, new ArrayList<>(), new ArrayList<>(), 1, 5, false, null);
        
    }

    @Test
    void EmpateTest() {
        combateController.ronda(carta1, carta2);
        Assertions.assertEquals(100, combateController.getPuntuacionTemporalPropia());
        Assertions.assertEquals(100, combateController.getPuntuacionTemporalRival());
        Assertions.assertEquals(combateController.getPuntuacionPropia(), combateController.getPuntuacionRival());
    }

    @Test
    void Carta1GanaCarta2FuegoTest() {
        carta2.setTipo(EnumTipos.FUEGO);
        combateController.ronda(carta1, carta2);
        Assertions.assertEquals(200, combateController.getPuntuacionTemporalPropia());
        Assertions.assertEquals(50, combateController.getPuntuacionTemporalRival());
    }

    @Test
    void Carta1GanaCarta1FuegoTest() {
        carta1.setTipo(EnumTipos.FUEGO);
        carta1.setFuerza(6);
        combateController.ronda(carta1, carta2);
        Assertions.assertEquals(300, combateController.getPuntuacionTemporalPropia());
        Assertions.assertEquals(200, combateController.getPuntuacionTemporalRival());
    }

    @Test
    void Carta2GanaCarta1FuegoTest() {
        carta1.setTipo(EnumTipos.FUEGO);
        combateController.ronda(carta1, carta2);
        Assertions.assertEquals(50, combateController.getPuntuacionTemporalPropia());
        Assertions.assertEquals(200, combateController.getPuntuacionTemporalRival());
    }

    @Test
    void Carta2GanaCarta2FuegoTest() {
        carta2.setTipo(EnumTipos.FUEGO);
        carta2.setFuerza(6);
        combateController.ronda(carta1, carta2);
        Assertions.assertEquals(200, combateController.getPuntuacionTemporalPropia());
        Assertions.assertEquals(300, combateController.getPuntuacionTemporalRival());
    }

    @Test
    void cartaNull(){
        Carta carta = null;
        try {
            combateController.ronda(carta, carta1);
            Assertions.fail();
        } catch (Exception e) {
            if (!(e instanceof IllegalArgumentException)) {
                Assertions.fail();
            }
        }
        carta = new Carta();
        try {
            combateController.ronda(carta, carta1);
            Assertions.fail();
        } catch (Exception e) {
            if (!(e instanceof IllegalArgumentException)) {
                Assertions.fail();
            }
        }
    }
}

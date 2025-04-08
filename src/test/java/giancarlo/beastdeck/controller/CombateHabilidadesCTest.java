package giancarlo.beastdeck.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import giancarlo.beastdeck.model.clases.Carta;
import giancarlo.beastdeck.model.clases.Combate;
import giancarlo.beastdeck.model.clases.HabilidadActiva;
import giancarlo.beastdeck.model.enums.EnumRarezas;
import giancarlo.beastdeck.model.enums.EnumTipos;

public class CombateHabilidadesCTest {

    private Combate combateController;
    private HabilidadActiva habilidad;
    private Carta carta1;
    private Carta carta2;


    @BeforeEach
    void beforeEach() {
        combateController = new Combate();
        habilidad = new HabilidadActiva(0, "null", "null", EnumRarezas.C, true);
        carta1 = new Carta(1, "nombre", "descripcion", EnumRarezas.C, EnumTipos.AGUA, new ArrayList<>(Arrays.asList(habilidad)), new ArrayList<>(), 1, 5, false, null);
        carta2 = new Carta(2, "nombre", "descripcion", EnumRarezas.R, EnumTipos.AGUA, new ArrayList<>(), new ArrayList<>(), 1, 5, false, null);
        
    }

    @Test
    void habilidadGenericaTest() {
        combateController.ronda(carta1, carta2);
        Assertions.assertEquals(100, combateController.getPuntuacionPropia());
        Assertions.assertEquals(100, combateController.getPuntuacionRival());
    }

    @Test
    void habilidad1Test() {
        habilidad.setId(1);
        combateController.ronda(carta1, carta2);
        Assertions.assertEquals(200, combateController.getPuntuacionPropia());
        Assertions.assertEquals(100, combateController.getPuntuacionRival());
    }

    @Test
    void habilidad2Test() {
        habilidad.setId(2);
        combateController.ronda(carta1, carta2);
        Assertions.assertEquals(100, combateController.getPuntuacionPropia());
        Assertions.assertEquals(0, combateController.getPuntuacionRival());
    }
}

package giancarlo.beastdeck.backend.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import giancarlo.beastdeck.backend.controller.enums.EnumRarezas;
import giancarlo.beastdeck.backend.controller.enums.EnumTipos;

public class CombateHabilidadesCTest {

    private Combate combateController;
    private Habilidad habilidad;
    private Carta carta1;
    private Carta carta2;


    @BeforeEach
    void beforeEach() {
        combateController = new Combate();
        habilidad = new Habilidad(0, "null", "null", EnumRarezas.C, true, true);
        carta1 = new Carta(1, "nombre", "descripcion", EnumRarezas.C, EnumTipos.AGUA, new ArrayList<>(Arrays.asList(habilidad)), 1, 5);
        carta2 = new Carta(2, "nombre", "descripcion", EnumRarezas.R, EnumTipos.AGUA, new ArrayList<>(), 1, 5);
        
    }

    //@Test
    void habilidadGenericaTest() {
        combateController.ronda(carta1, carta2);
        Assertions.assertEquals(100, combateController.getPuntuacionPropia());
        Assertions.assertEquals(100, combateController.getPuntuacionRival());
    }

    //@Test
    void habilidad1Test() {
        habilidad.setId(1);
        combateController.ronda(carta1, carta2);
        Assertions.assertEquals(200, combateController.getPuntuacionPropia());
        Assertions.assertEquals(100, combateController.getPuntuacionRival());
    }

    //@Test
    void habilidad2Test() {
        habilidad.setId(2);
        combateController.ronda(carta1, carta2);
        Assertions.assertEquals(100, combateController.getPuntuacionPropia());
        Assertions.assertEquals(0, combateController.getPuntuacionRival());
    }
}

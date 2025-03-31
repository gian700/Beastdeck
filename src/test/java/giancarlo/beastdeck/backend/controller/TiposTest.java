package giancarlo.beastdeck.backend.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import giancarlo.beastdeck.backend.controller.enums.EnumTipos;

public class TiposTest {

    private Combate combateController;
    private Carta carta1;
    private Carta carta2;
    private List<EnumTipos> tipos;
    private double lucha;
    private double luchaComprobar;

    @BeforeEach
    void beforeEach() {
        combateController = new Combate();
        carta1 = new Carta();
        carta2 = new Carta();
        tipos = new ArrayList<>(Arrays.asList(EnumTipos.AGUA, EnumTipos.FUEGO, EnumTipos.PLANTA, EnumTipos.BESTIA, EnumTipos.TIERRA, EnumTipos.ELECTRICO, EnumTipos.VOLADOR));
    }

    //@Test
    void TipoNullTest() {
        
        try {
             lucha = combateController.comprobarGanador(carta1, carta2);
        } catch (Exception e) {
            if (!(e instanceof IllegalArgumentException) || !e.getMessage().contains("tipos no son validos")) {
                Assertions.fail();
            }
        }
    }

    //@Test
    void aguaTest() {
        carta1.setTipo(EnumTipos.AGUA);
        for (EnumTipos tipo : tipos) {
            carta2.setTipo(tipo);
            lucha = combateController.comprobarGanador(carta1, carta2);
            int luchaSwitch = (int) lucha;
            
            switch (luchaSwitch) {
                case 1 -> {
                    luchaComprobar = combateController.comprobarGanador(carta2, carta1);
                    Assertions.assertEquals(1.0, luchaComprobar, "tipo que falla: "+carta2.getTipo());
                }
                case 2 -> {
                    luchaComprobar = combateController.comprobarGanador(carta2, carta1);
                    Assertions.assertEquals(0.5, luchaComprobar, "tipo que falla: "+carta2.getTipo());
                }
                case 0 -> {
                    luchaComprobar = combateController.comprobarGanador(carta2, carta1);
                    Assertions.assertEquals(2, luchaComprobar, "tipo que falla: "+carta2.getTipo());
                }
                default -> Assertions.fail();
            }
        }
    }

    //@Test
    void fuegoTest() {
        carta1.setTipo(EnumTipos.FUEGO);
        for (EnumTipos tipo : tipos) {
            carta2.setTipo(tipo);
            lucha = combateController.comprobarGanador(carta1, carta2);
            int luchaSwitch = (int) lucha;
            
            switch (luchaSwitch) {
                case 1 -> {
                    luchaComprobar = combateController.comprobarGanador(carta2, carta1);
                    Assertions.assertEquals(1.0, luchaComprobar, "tipo que falla: "+carta2.getTipo());
                }
                case 2 -> {
                    luchaComprobar = combateController.comprobarGanador(carta2, carta1);
                    Assertions.assertEquals(0.5, luchaComprobar, "tipo que falla: "+carta2.getTipo());
                }
                case 0 -> {
                    luchaComprobar = combateController.comprobarGanador(carta2, carta1);
                    Assertions.assertEquals(2, luchaComprobar, "tipo que falla: "+carta2.getTipo());
                }
                default -> Assertions.fail();
            }
        }
    }

    //@Test
    void plantaTest() {
        carta1.setTipo(EnumTipos.PLANTA);
        for (EnumTipos tipo : tipos) {
            carta2.setTipo(tipo);
            lucha = combateController.comprobarGanador(carta1, carta2);
            int luchaSwitch = (int) lucha;
            
            switch (luchaSwitch) {
                case 1 -> {
                    luchaComprobar = combateController.comprobarGanador(carta2, carta1);
                    Assertions.assertEquals(1.0, luchaComprobar, "tipo que falla: "+carta2.getTipo());
                }
                case 2 -> {
                    luchaComprobar = combateController.comprobarGanador(carta2, carta1);
                    Assertions.assertEquals(0.5, luchaComprobar, "tipo que falla: "+carta2.getTipo());
                }
                case 0 -> {
                    luchaComprobar = combateController.comprobarGanador(carta2, carta1);
                    Assertions.assertEquals(2, luchaComprobar, "tipo que falla: "+carta2.getTipo());
                }
                default -> Assertions.fail();
            }
        }
    }

   // @Test
    void bestiaTest() {
        carta1.setTipo(EnumTipos.BESTIA);
        for (EnumTipos tipo : tipos) {
            carta2.setTipo(tipo);
            lucha = combateController.comprobarGanador(carta1, carta2);
            int luchaSwitch = (int) lucha;
            
            switch (luchaSwitch) {
                case 1 -> {
                    luchaComprobar = combateController.comprobarGanador(carta2, carta1);
                    Assertions.assertEquals(1.0, luchaComprobar, "tipo que falla: "+carta2.getTipo());
                }
                case 2 -> {
                    luchaComprobar = combateController.comprobarGanador(carta2, carta1);
                    Assertions.assertEquals(0.5, luchaComprobar, "tipo que falla: "+carta2.getTipo());
                }
                case 0 -> {
                    luchaComprobar = combateController.comprobarGanador(carta2, carta1);
                    Assertions.assertEquals(2, luchaComprobar, "tipo que falla: "+carta2.getTipo());
                }
                default -> Assertions.fail();
            }
        }
    }

    //@Test
    void tierraTest() {
        carta1.setTipo(EnumTipos.TIERRA);
        for (EnumTipos tipo : tipos) {
            carta2.setTipo(tipo);
            lucha = combateController.comprobarGanador(carta1, carta2);
            int luchaSwitch = (int) lucha;
            
            switch (luchaSwitch) {
                case 1 -> {
                    luchaComprobar = combateController.comprobarGanador(carta2, carta1);
                    Assertions.assertEquals(1.0, luchaComprobar, "tipo que falla: "+carta2.getTipo());
                }
                case 2 -> {
                    luchaComprobar = combateController.comprobarGanador(carta2, carta1);
                    Assertions.assertEquals(0.5, luchaComprobar, "tipo que falla: "+carta2.getTipo());
                }
                case 0 -> {
                    luchaComprobar = combateController.comprobarGanador(carta2, carta1);
                    Assertions.assertEquals(2, luchaComprobar, "tipo que falla: "+carta2.getTipo());
                }
                default -> Assertions.fail();
            }
        }
    }

    //@Test
    void electricoTest() {
        carta1.setTipo(EnumTipos.ELECTRICO);
        for (EnumTipos tipo : tipos) {
            carta2.setTipo(tipo);
            lucha = combateController.comprobarGanador(carta1, carta2);
            int luchaSwitch = (int) lucha;
            
            switch (luchaSwitch) {
                case 1 -> {
                    luchaComprobar = combateController.comprobarGanador(carta2, carta1);
                    Assertions.assertEquals(1.0, luchaComprobar, "tipo que falla: "+carta2.getTipo());
                }
                case 2 -> {
                    luchaComprobar = combateController.comprobarGanador(carta2, carta1);
                    Assertions.assertEquals(0.5, luchaComprobar, "tipo que falla: "+carta2.getTipo());
                }
                case 0 -> {
                    luchaComprobar = combateController.comprobarGanador(carta2, carta1);
                    Assertions.assertEquals(2, luchaComprobar, "tipo que falla: "+carta2.getTipo());
                }
                default -> Assertions.fail();
            }
        }
    }

    @Test
    void voladorTest() {
        carta1.setTipo(EnumTipos.VOLADOR);
        for (EnumTipos tipo : tipos) {
            carta2.setTipo(tipo);
            lucha = combateController.comprobarGanador(carta1, carta2);
            int luchaSwitch = (int) lucha;
            
            switch (luchaSwitch) {
                case 1 -> {
                    luchaComprobar = combateController.comprobarGanador(carta2, carta1);
                    Assertions.assertEquals(1.0, luchaComprobar, "tipo que falla: "+carta2.getTipo());
                }
                case 2 -> {
                    luchaComprobar = combateController.comprobarGanador(carta2, carta1);
                    Assertions.assertEquals(0.5, luchaComprobar, "tipo que falla: "+carta2.getTipo());
                }
                case 0 -> {
                    luchaComprobar = combateController.comprobarGanador(carta2, carta1);
                    Assertions.assertEquals(2, luchaComprobar, "tipo que falla: "+carta2.getTipo());
                }
                default -> Assertions.fail();
            }
        }
    }
}

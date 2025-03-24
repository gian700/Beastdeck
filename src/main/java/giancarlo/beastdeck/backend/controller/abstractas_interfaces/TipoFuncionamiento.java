package giancarlo.beastdeck.backend.controller.abstractas_interfaces;

import java.util.List;

import giancarlo.beastdeck.backend.controller.Carta;
import giancarlo.beastdeck.backend.controller.dependencias.tipos.Agua;
import giancarlo.beastdeck.backend.controller.dependencias.tipos.Bestia;
import giancarlo.beastdeck.backend.controller.dependencias.tipos.Electrico;
import giancarlo.beastdeck.backend.controller.dependencias.tipos.Fuego;
import giancarlo.beastdeck.backend.controller.dependencias.tipos.Planta;
import giancarlo.beastdeck.backend.controller.dependencias.tipos.Tierra;
import giancarlo.beastdeck.backend.controller.dependencias.tipos.Volador;
import giancarlo.beastdeck.backend.controller.enums.EnumTipos;


/**
 * @author Giancarlo
 * @version 1.0.0
 */
public abstract class TipoFuncionamiento {

    /**
     * Metodo que comprueba entre dos cartas quien tiene la ventaja de tipo
     * 
     * @param cartaPropia
     * @param cartaRival
     * @return double
     */
    public double comprobarGanador(Carta cartaPropia, Carta cartaRival) {

        if (cartaPropia == null || cartaRival == null) {
            throw new IllegalArgumentException("Alguna de las cartas no son validas");
        }

        EnumTipos tipoPropio = cartaPropia.getTipo();
        EnumTipos tipoRival = cartaRival.getTipo();

        if (tipoPropio == null || tipoRival == null) {
            throw new IllegalArgumentException("Alguno de los tipos no son validos");
        }

        if (tipoPropio == tipoRival) {
            return 1;
        }

        List<EnumTipos> debilidades = comprobarDebilidades(tipoPropio);
        if (debilidades.contains(tipoRival)) {
            return 0.5;
        }
        return 2;
    }

    /**
     * Metodo que permite que el metodo comprobarGanador tenga la informacion de las
     * ventajas de tipo
     * 
     * @param tipoPropio
     * @return List<EnumTipos>
     */
    private List<EnumTipos> comprobarDebilidades(EnumTipos tipoPropio) {

        switch (tipoPropio) {
            case FUEGO -> {
                Fuego fuego = new Fuego();
                return fuego.debilidades();
            }

            case AGUA -> {
                Agua agua = new Agua();
                return agua.debilidades();
            }

            case PLANTA -> {
                Planta planta = new Planta();
                return planta.debilidades();
            }

            case TIERRA -> {
                Tierra tierra = new Tierra();
                return tierra.debilidades();
            }

            case ELECTRICO -> {
                Electrico electrico = new Electrico();
                return electrico.debilidades();
            }

            case VOLADOR -> {
                Volador volador = new Volador();
                return volador.debilidades();
            }

            case BESTIA -> {
                Bestia bestia = new Bestia();
                return bestia.debilidades();
            }

        }
        throw new IllegalArgumentException("Error desconociodo");
    }
}

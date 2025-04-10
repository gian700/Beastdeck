package giancarlo.beastdeck.model.abstractas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import giancarlo.beastdeck.model.clases.Carta;
import giancarlo.beastdeck.model.enums.EnumTipos;


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
     * @return float
     */
    public float comprobarGanador(Carta cartaPropia, Carta cartaRival) {

        if (cartaPropia == null || cartaRival == null) {
            throw new IllegalArgumentException("Alguna de las cartas no son validas");
        }

        EnumTipos tipoPropio = cartaPropia.getTipo();
        EnumTipos tipoRival = cartaRival.getTipo();

        if (tipoPropio == null || tipoRival == null) {
            throw new IllegalArgumentException("Alguno de los tipos no son validos");
        }

        if (tipoPropio == tipoRival) {
            return 1f;
        }

        List<EnumTipos> debilidades = comprobarDebilidades(tipoPropio);
        if (debilidades.contains(tipoRival)) {
            return 0.5f;
        }
        return 2f;
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
                return new ArrayList<>(Arrays.asList(EnumTipos.AGUA, EnumTipos.TIERRA, EnumTipos.VOLADOR));
            }

            case AGUA -> {
                return new ArrayList<>(Arrays.asList(EnumTipos.PLANTA, EnumTipos.ELECTRICO, EnumTipos.BESTIA));
            }

            case PLANTA -> {
                return new ArrayList<>(Arrays.asList(EnumTipos.FUEGO, EnumTipos.ELECTRICO, EnumTipos.BESTIA));
            }

            case TIERRA -> {
                return new ArrayList<>(Arrays.asList(EnumTipos.VOLADOR, EnumTipos.AGUA, EnumTipos.PLANTA));
            }

            case ELECTRICO -> {
                return new ArrayList<>(Arrays.asList(EnumTipos.TIERRA, EnumTipos.FUEGO, EnumTipos.BESTIA));
            }

            case VOLADOR -> {
                return new ArrayList<>(Arrays.asList(EnumTipos.ELECTRICO, EnumTipos.AGUA, EnumTipos.PLANTA));
            }

            case BESTIA -> {
                return new ArrayList<>(Arrays.asList(EnumTipos.FUEGO, EnumTipos.TIERRA, EnumTipos.VOLADOR));
            }

        }
        throw new IllegalArgumentException("Error desconociodo");
    }
}

package giancarlo.beastdeck.model.clases;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import giancarlo.beastdeck.model.Constructores.HabilidadActivaConstructor;
import giancarlo.beastdeck.model.enums.EnumRarezas;
import giancarlo.beastdeck.model.enums.EnumTipos;

/**
 * @author Giancarlo
 * @version 1.0.0
 */
public class HabilidadActiva extends HabilidadActivaConstructor{

    public HabilidadActiva(){}
    
    public HabilidadActiva(int id, String nombre, String descripcion, EnumRarezas rareza, boolean rapida) {
        super(id, nombre, descripcion, rareza, rapida);
    }
    
    /**
     * Metodo que activa las habilidades
     * @param cartaPropia
     * @param combate
     * @param cartaRival
     */
    public void activar(Carta cartaPropia, Combate combate, Carta cartaRival) {
        switch (getId()) {
            case 1 -> apuestaClara(combate, cartaPropia, cartaRival);
            case 2 -> inutilidad(cartaRival);
            case 3 -> adaptativo(combate, cartaPropia, cartaRival);
            default -> throw new AssertionError("habilidad no existente");
        }
    }

    /**
     * Habilidad que multiplica por 2 la fuerza de la carta
     * @param cartaPropia
     */
    private void apuestaClara(Combate combate, Carta cartaPropia, Carta cartaRival){
        float ganador = combate.comprobarGanador(cartaPropia, cartaRival);
        if (ganador == 0.5) {
            cartaPropia.setFuerza(cartaPropia.getFuerza()/2);
        }
        if (ganador == 2.0) {
            cartaPropia.setFuerza(cartaPropia.getFuerza()*2);
        }
    }

    /**
     * Habilidad que le baja a la mitad la fuerza, redondeando hacia bajo en caso, 
     * @param cartaRival
     */
    private void inutilidad(Carta cartaRival){
        cartaRival.setFuerza(cartaRival.getFuerza()/2);
    }

    /**
     * Habilidad que si vas a perder por tipo base, cambia de tipo, no necesariamente ganaras en tipo, 
     * @param cartaPropia
     * @param combate
     * @param cartaRival
     */
    private void adaptativo(Combate combate, Carta cartaPropia, Carta cartaRival){
        float ganador = combate.comprobarGanador(cartaPropia, cartaRival);
        if (ganador == 0.5) {
            List<EnumTipos> tipos = new ArrayList<>(Arrays.asList(EnumTipos.AGUA, EnumTipos.FUEGO, EnumTipos.PLANTA, EnumTipos.BESTIA, EnumTipos.TIERRA, EnumTipos.ELECTRICO, EnumTipos.VOLADOR));
            tipos.remove(cartaPropia.getTipo());
            Collections.shuffle(tipos);
            cartaPropia.setTipo(tipos.get(0));
        }
    }


    @Override
    public String toString() {
        return super.toString();
    }
    
}

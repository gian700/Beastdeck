package giancarlo.beastdeck.model.clases;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import giancarlo.beastdeck.model.constructores.HabilidadActivaConstructor;
import giancarlo.beastdeck.model.enums.EnumTipos;

/**
 * @author Giancarlo
 * @version 1.0.0
 */
public class HabilidadActiva extends HabilidadActivaConstructor{

    public HabilidadActiva(){}
    
    public HabilidadActiva(int id, String nombre, String descripcion, boolean rapida) {
        super(id, nombre, descripcion, rapida);
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
            case 4 -> explosionPuntual(combate, cartaPropia);
            case 5 -> explosionCancelable(combate, cartaPropia, cartaRival);
            case 6 -> neutralidad(combate, cartaPropia, cartaRival, EnumTipos.AGUA);
            case 7 -> neutralidad(combate, cartaPropia, cartaRival, EnumTipos.FUEGO);
            case 8 -> neutralidad(combate, cartaPropia, cartaRival, EnumTipos.BESTIA);
            case 9 -> neutralidad(combate, cartaPropia, cartaRival, EnumTipos.VOLADOR);
            case 10 -> CambiarTipo(cartaPropia, EnumTipos.AGUA);
            case 11 -> CambiarTipo(cartaPropia, EnumTipos.TIERRA);
            case 12 -> CambiarTipo(cartaPropia, EnumTipos.PLANTA);
            case 13 -> CambiarTipo(cartaPropia, EnumTipos.ELECTRICO);
            case 14 -> robaFuerzas(cartaPropia, cartaRival);
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
     * Habilidad que le baja 1 la fuerza a la carta rival 
     * @param cartaRival
     */
    private void inutilidad(Carta cartaRival){
        cartaRival.setFuerza(cartaRival.getFuerza()-1);
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
            CambiarTipo(cartaPropia, tipos.get(0));
        }
    }

    /**
     * Metodo que cambia una carta de tipo
     * @param cambiar
     * @param tipo
     */
    private void CambiarTipo(Carta cambiar, EnumTipos tipo){
        cambiar.setTipo(tipo);
    }

    /**
     * Habilidad que multiplica la puntuacion total, dependiendo del turno 
     * @param cartaRival
     */
    private void explosionPuntual(Combate combate, Carta cartaPropia){
        boolean esPropia = cartaPropia.equals(combate.getCartaPropia());
        int nuevaPuntuacion = (esPropia ? combate.getPuntuacionPropia() : combate.getPuntuacionRival()) * (combate.getTurno() - 1);

        if (esPropia) {
            combate.setPuntuacionPropia(nuevaPuntuacion);
        } else {
            combate.setPuntuacionRival(nuevaPuntuacion);
        }
    }

    /**
         * Habilidad que multiplica la puntuacion total en el 3 turno si no pierdes por tipo, en el ultimo turno la multiplicacion sera de 0
     * @param cartaRival
     */
    private void explosionCancelable(Combate combate, Carta cartaPropia, Carta cartaRival){

        float ganador = combate.comprobarGanador(cartaPropia, cartaRival);
        if (combate.getTurno() > 2 || ganador == 0.5) {
            return;
        }

        boolean esPropia = cartaPropia.equals(combate.getCartaPropia());
        int nuevaPuntuacion = (esPropia ? combate.getPuntuacionPropia() : combate.getPuntuacionRival()) * (combate.getTurno()==2 ? 3:0);
        
        if (esPropia) {
            combate.setPuntuacionPropia(nuevaPuntuacion);
        } else {
            combate.setPuntuacionRival(nuevaPuntuacion);
        }
    }

    /**
     * Habilidad que hace la batalla neutra si el rival es de un tipo especificado
     * @param cartaPropia
     * @param cartaRival
     */
    private void neutralidad(Combate combate, Carta cartaPropia, Carta cartaRival, EnumTipos tipo){
        if (cartaRival.getTipo() != tipo) {
            return;
        }
        float ganador = combate.comprobarGanador(cartaPropia, cartaRival);
        if (ganador == 2) {
            cartaPropia.setFuerza(cartaPropia.getFuerza()/2);
            cartaRival.setFuerza(cartaRival.getFuerza()*2);
        }
        if (ganador == 0.5) {
            cartaPropia.setFuerza(cartaPropia.getFuerza()*2);
            cartaRival.setFuerza(cartaRival.getFuerza()/2);
        }
    }

    /**
     * Habilidad que intercambia la fuerza de las cartas
     * @param cartaPropia
     * @param cartaRival
     */
    private void robaFuerzas(Carta cartaPropia, Carta cartaRival){
        int fuerza = cartaPropia.getFuerza();
        cartaPropia.setFuerza(cartaRival.getFuerza());
        cartaRival.setFuerza(fuerza);
    }

    

    @Override
    public String toString() {
        return super.toString();
    }
    
}

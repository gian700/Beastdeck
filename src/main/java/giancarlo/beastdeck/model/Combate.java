package giancarlo.beastdeck.model;

import java.util.Objects;

import giancarlo.beastdeck.model.Constructores.CombateConstructor;
import giancarlo.beastdeck.model.abstractas.TipoFuncionamiento;

/**
 * @author Giancarlo
 * @version 1.0.0
 */
public class Combate extends CombateConstructor{
    

    /**
     * Metodo que permite llevar las rondas de la batalla despues de elegir las cartas a usar
     * @param cartaPropia
     * @param cartaRival
     */
    public void ronda (Carta cartaPropia, Carta cartaRival){
        if (cartaPropia == null || cartaRival == null) {
            throw new IllegalArgumentException("Carta nula");
        }
        if (cartaPropia.getUtilizada() || cartaRival.getUtilizada()) {
            return;
        }
        cartaPropia.activarHabilidades(this, cartaRival);
        cartaRival.activarHabilidades(this, cartaPropia);

        float multiplicador = comprobarGanador(cartaPropia, cartaRival);
        setPuntuacionTemporalPropia((cartaPropia.getFuerza()*multiplicador) * 100);
        setPuntuacionTemporalRival((cartaRival.getFuerza()/multiplicador) * 100);

        cartaPropia.activarHabilidades(this, cartaRival);
        cartaRival.activarHabilidades(this, cartaPropia);

        setPuntuacionPropia(getPuntuacionPropia() + getPuntuacionTemporalPropia());
        setPuntuacionRival(getPuntuacionRival() + getPuntuacionTemporalRival());
    }

}

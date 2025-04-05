package giancarlo.beastdeck.model;

import java.util.List;
import java.util.Objects;

import giancarlo.beastdeck.model.Constructores.CartaConstructor;
import giancarlo.beastdeck.model.enums.EnumRarezas;
import giancarlo.beastdeck.model.enums.EnumTipos;


/**
 * @author Giancarlo
 * @version 1.0.0
 */
public class Carta extends CartaConstructor{

    public Carta(Integer id){}
    
    
    /**
     * Metodo que activa la habilidades de una carta
     * @param combate
     * @param cartaRival
     */
    public void activarHabilidades(Combate combate, Carta cartaRival){
        for (HabilidadActiva habilidad : getHabilidadesActivas()) {
            if (habilidad.getActiva() && habilidad.getRapida()) {
                habilidad.activar(this, combate, cartaRival);
            }
            habilidad.setRapida();
            
        }
    }
}

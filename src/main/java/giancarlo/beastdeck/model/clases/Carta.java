package giancarlo.beastdeck.model.clases;

import java.util.List;

import giancarlo.beastdeck.model.Constructores.CartaConstructor;
import giancarlo.beastdeck.model.enums.EnumRarezas;
import giancarlo.beastdeck.model.enums.EnumTipos;


/**
 * @author Giancarlo
 * @version 1.0.0
 */
public class Carta extends CartaConstructor{

    public Carta(){
    }

    public Carta(Integer id) {
        super(id);
    }

    public Carta(Integer id, String nombre, String descripcion, EnumRarezas rareza, EnumTipos tipo, List<HabilidadActiva> habilidadesActivas, List<HabilidadPasiva> habilidadesPasivas, int fuerza, int ordenRecomendado, boolean desbloqueada, String imagen) {
        super(id, nombre, descripcion, rareza, tipo, habilidadesActivas, habilidadesPasivas, fuerza, ordenRecomendado, desbloqueada, imagen);
    }

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


    @Override
    public String toString() {
        return super.toString();
    }

}

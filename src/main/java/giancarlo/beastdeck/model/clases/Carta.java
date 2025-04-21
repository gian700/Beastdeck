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

    public Carta(int id) {
        super(id);
    }

    public Carta(int id, String nombre, String descripcion, EnumRarezas rareza, EnumTipos tipo, List<HabilidadActiva> habilidadesActivas, List<HabilidadPasiva> habilidadesPasivas, int fuerza, int ordenRecomendado, boolean desbloqueada, String imagen) {
        super(id, nombre, descripcion, rareza, tipo, habilidadesActivas, habilidadesPasivas, fuerza, ordenRecomendado, desbloqueada, imagen);
    }

    public Carta(Carta carta){
        super(
            carta.getId(),
            carta.getNombre(),
            carta.getDescripcion(),
            carta.getRareza(),
            carta.getTipo(),
            carta.getHabilidadesActivas(),
            carta.getHabilidadesPasivas(),
            carta.getFuerza(),
            carta.getOrdenRecomendado(),
            carta.isDesbloqueada(),
            carta.getImagen()
        );
    }

    /**
     * Metodo que activa las habilidades de uso de una carta
     * @param combate
     * @param cartaRival
     */
    public void activarHabilidadActiva(Combate combate, Carta cartaRival){
        for (HabilidadActiva habilidad : getHabilidadesActivas()) {
            if (habilidad.getRapida()) {
                habilidad.activar(this, combate, cartaRival);
            }
            habilidad.setRapida();
            
        }
    }

    /*
     * Metodo que permite cambiar el estado de las habilidades pasivas
     */
    public boolean cambiarEstado(){
        setPasivasActivadas();
        for (HabilidadPasiva habilidad : getHabilidadesPasivas()) {
            if (!habilidad.getBot() && !getGastada()) {
                setPasivasActivadas();
                return false;
            }
        }
        return true;
    }

    /**
     * Metodo que activa las habilidades de campo de una carta
     * @param combate
     * @param cartaRival
     */
    public void activarPasiva(Combate combate, Carta cartaPropia, Carta cartaRival){
        boolean gastada = false;
        for (HabilidadPasiva habilidad : getHabilidadesPasivas()) {
            if (!habilidad.getContinua()) {
                gastada = true;
            }
            habilidad.activar(cartaPropia, combate, cartaRival);
        }
        setGastada(gastada);
        
    }

    @Override
    public String toString() {
        return super.toString();
    }

}

package giancarlo.beastdeck.model;


import giancarlo.beastdeck.model.Constructores.HabilidadActivaConstructor;
import giancarlo.beastdeck.model.enums.EnumRarezas;

/**
 * @author Giancarlo
 * @version 1.0.0
 */
public class HabilidadActiva extends HabilidadActivaConstructor{
    
    public HabilidadActiva(int id, String nombre, String descripcion, EnumRarezas rareza, boolean activa, boolean rapida) {
        super(id, nombre, descripcion, rareza, activa, rapida);
    }
    
    /**
     * Metodo que activa las habilidades
     * @param cartaPropia
     * @param combate
     * @param cartaRival
     */
    public void activar(Carta cartaPropia, Combate combate, Carta cartaRival) {
        switch (getId()) {
            case 0 -> generico();
            case 1 -> DobleFuerza(cartaPropia);
            case 2 -> inutilidad(cartaRival);
            default -> throw new AssertionError("habilidad no existente");
        }
    }

    /**
     * Metodo generico, copiar este metodo para crear nueva habilidad
     * @param cartaPropia
     * @param combate
     * @param cartaRival
     */
    private void generico(){}

    /**
     * Habilidad que multiplica por 2 la fuerza de la carta
     * @param cartaPropia
     * @param combate
     * @param cartaRival
     */
    private void DobleFuerza(Carta cartaPropia){
        cartaPropia.setFuerza(cartaPropia.getFuerza()*2);
    }

    /**
     * Habilidad que le baja a la mitad la fuerza, redondeando hacia bajo en caso, 
     * @param cartaPropia
     * @param combate
     * @param cartaRival
     */
    private void inutilidad(Carta cartaRival){
        cartaRival.setFuerza(cartaRival.getFuerza()/2);
        
    }
    
}

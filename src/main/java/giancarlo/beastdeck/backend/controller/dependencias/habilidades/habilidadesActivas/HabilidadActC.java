package giancarlo.beastdeck.backend.controller.dependencias.habilidades.habilidadesActivas;

import giancarlo.beastdeck.backend.controller.Carta;
import giancarlo.beastdeck.backend.controller.Combate;
import giancarlo.beastdeck.backend.controller.abstractas_interfaces.HabilidadesInterfaz;

public class HabilidadActC implements HabilidadesInterfaz{

    public HabilidadActC(int id, Carta cartaPropia, Combate combate, Carta cartaRival){
        seleccionar(id, cartaPropia, combate, cartaRival);
    }

    @Override
    public void seleccionar(int id, Carta cartaPropia, Combate combate, Carta cartaRival) {
        switch (id) {
            case 0 -> generico(cartaPropia, combate, cartaRival);
            case 1 -> DobleFuerza(cartaPropia, combate, cartaRival);
            case 2 -> inutilidad(cartaPropia, combate, cartaRival);
            default -> throw new AssertionError("habilidad no existente");
        }
    }

    /**
     * Metodo generico, copiar este metodo para crear nueva habilidad
     * @param cartaPropia
     * @param combate
     * @param cartaRival
     */
    private void generico(Carta cartaPropia, Combate combate, Carta cartaRival){}

    /**
     * Habilidad que multiplica por 2 la fuerza de la carta
     * @param cartaPropia
     * @param combate
     * @param cartaRival
     */
    private void DobleFuerza(Carta cartaPropia, Combate combate, Carta cartaRival){
        cartaPropia.setFuerza(cartaPropia.getFuerza()*2);
    }

    /**
     * Habilidad que le baja a la mitad la fuerza, redondeando hacia bajo en caso, 
     * @param cartaPropia
     * @param combate
     * @param cartaRival
     */
    private void inutilidad(Carta cartaPropia, Combate combate, Carta cartaRival){
        cartaRival.setFuerza(cartaRival.getFuerza()/2);
        
    }
}

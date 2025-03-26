package giancarlo.beastdeck.backend.controller.abstractas_interfaces;

import giancarlo.beastdeck.backend.controller.Carta;
import giancarlo.beastdeck.backend.controller.Combate;

/**
 * @author Giancarlo
 * @version 1.0.0
 */
public interface HabilidadesInterfaz {
    /**
     * Metodo que permite separar las distintas habilidades por rareza
     * 
     */
    public void seleccionar(int id, Carta cartaPropia, Combate combate, Carta cartaRival);

    
}

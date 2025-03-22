package giancarlo.beastdeck.backend.controller.abstractas_interfaces;

import java.util.List;

import giancarlo.beastdeck.backend.controller.enums.EnumTipos;

/**
 * @author Giancarlo
 * @version 1.0.0
 */
public interface TiposInterfaz {

    /**
     * Metodo que da las debilidades del tipo correspondiente
     * @return List<EnumTipos>
     */
    public List<EnumTipos> debilidades();
}

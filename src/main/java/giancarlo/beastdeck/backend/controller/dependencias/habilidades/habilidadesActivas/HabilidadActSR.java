package giancarlo.beastdeck.backend.controller.dependencias.habilidades.habilidadesActivas;

import giancarlo.beastdeck.backend.controller.Carta;
import giancarlo.beastdeck.backend.controller.Combate;
import giancarlo.beastdeck.backend.controller.abstractas_interfaces.HabilidadesInterfaz;

public class HabilidadActSR implements HabilidadesInterfaz{

    public HabilidadActSR(int id, Carta cartaPropia, Combate combate, Carta cartaRival){
        seleccionar(id, cartaPropia,combate, cartaRival);
    }

    @Override
    public void seleccionar(int id, Carta cartaPropia, Combate combate, Carta cartaRival) {
        switch (id) {
            case 0:
                
                break;
            default:
                throw new AssertionError("habilidad no existente");
        }
    }

}

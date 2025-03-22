package giancarlo.beastdeck.backend.controller.dependencias.tipos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import giancarlo.beastdeck.backend.controller.abstractas_interfaces.TiposInterfaz;
import giancarlo.beastdeck.backend.controller.enums.EnumTipos;

/**
 * @author Giancarlo
 * @version 1.0.0
 */
public class Volador implements TiposInterfaz{

    public Volador() {
    }    

    @Override
    public List<EnumTipos> debilidades() {
        List<EnumTipos> debilidadesVolador = new ArrayList<>(Arrays.asList(EnumTipos.ELECTRICO, EnumTipos.AGUA, EnumTipos.PLANTA));
        return debilidadesVolador;
    }

}
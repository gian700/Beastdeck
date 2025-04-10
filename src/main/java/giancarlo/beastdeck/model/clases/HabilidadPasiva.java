package giancarlo.beastdeck.model.clases;

import giancarlo.beastdeck.model.Constructores.HabilidadPasivaConstructor;

public class HabilidadPasiva extends HabilidadPasivaConstructor{

    public HabilidadPasiva() {
    }

    public HabilidadPasiva(int id, String nombre, String descripcion, boolean continua, boolean gastada, boolean bot) {
        super(id, nombre, descripcion, continua, bot);
    }

    /**
     * Metodo que activa las habilidades
     * @param cartaPropia
     * @param combate
     * @param cartaRival
     */
    public void activar(Carta cartaPropia, Combate combate, Carta cartaRival) {
        if (!getActivada()) {
            return;
        }

        switch (getId()) {
            default -> throw new AssertionError("habilidad no existente");
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

}

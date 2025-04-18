package giancarlo.beastdeck.model.clases;

import giancarlo.beastdeck.model.Constructores.HabilidadPasivaConstructor;

public class HabilidadPasiva extends HabilidadPasivaConstructor{

    public HabilidadPasiva() {
    }

    public HabilidadPasiva(int id, String nombre, String descripcion, boolean continua, boolean bot) {
        super(id, nombre, descripcion, continua, bot);
    }

    /**
     * Metodo que activa las habilidades
     * @param cartaPropia
     * @param combate
     * @param cartaRival
     */
    public void activar(Carta cartaPropia, Combate combate, Carta cartaRival) {
        switch (getId()) {
            case 1 -> BonificadorTotal(combate, cartaPropia);
            default -> throw new AssertionError("habilidad no existente");
        }
    }

    public void BonificadorTotal(Combate combate, Carta cartaPropia){
        if (combate.getDeckPropio().contains(cartaPropia)) {
            for (Carta carta : combate.getDeckPropio()) {
                carta.setFuerza(carta.getFuerza()+1);
            }
        }
        if (combate.getDeckRival().contains(cartaPropia)) {
            for (Carta carta : combate.getDeckRival()) {
                carta.setFuerza(carta.getFuerza()+1);
            }
        }
        
    }

    @Override
    public String toString() {
        return super.toString();
    }

}

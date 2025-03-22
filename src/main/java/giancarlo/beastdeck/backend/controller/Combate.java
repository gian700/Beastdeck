package giancarlo.beastdeck.backend.controller;

import giancarlo.beastdeck.backend.controller.abstractas_interfaces.TipoFuncionamiento;

/**
 * @author Giancarlo
 * @version 1.0.0
 */
public class Combate extends TipoFuncionamiento{
    Deck deckPropio;
    Deck Rival;

    public Combate() {
    }

    public Combate(Deck deckPropio, Deck Rival) {
        this.deckPropio = deckPropio;
        this.Rival = Rival;
    }

    public Deck getDeckPropio() {
        return this.deckPropio;
    }

    public void setDeckPropio(Deck deckPropio) {
        this.deckPropio = deckPropio;
    }

    public Deck getRival() {
        return this.Rival;
    }

    public void setRival(Deck Rival) {
        this.Rival = Rival;
    }


    

}

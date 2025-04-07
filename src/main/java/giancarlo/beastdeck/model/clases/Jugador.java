package giancarlo.beastdeck.model.clases;

/**
 * @author Giancarlo
 * @version 1.0.0
 */
public class Jugador {
    Deck deck;


    public Jugador() {
    }

    public Jugador(Deck deck) {
        this.deck = deck;
    }
    public void setDeck(Deck deck) {
        this.deck = deck;
    }


    @Override
    public String toString() {
        return "{" +
            " deck='" + getDeck() + "'" +
            "}";
    }
    

    public Deck getDeck(){
        return this.deck;
    }
}

package giancarlo.beastdeck.model.clases;

import java.util.List;
/**
 * @author Giancarlo
 * @version 1.0.0
 */
public class Deck {
    private List<Carta> deck; 

    public Deck() {
    }

    public Deck(List<Carta> deck) {
        this.deck = deck;
    }

    public List<Carta> getDeck() {
        return this.deck;
    }

    public void setDeck(List<Carta> deck) {
        this.deck = deck;
    }

    public List<Deck> getCopia(){
        
        return null;
    }

    @Override
    public String toString() {
        return getDeck().toString();
    }

    /**
     * Metodo que permite agregar una carta al deck
     * @param carta
     * @return boolean
     */
    public boolean create(Carta carta){
        if (carta == null) {
            return false;
        }
        if (deck.contains(carta)) {
            return false;
        }
        deck.add(carta);
        return true;
    }

    /**
     * Metodo que permite eliminar una carta del deck
     * @param id
     * @return boolean
     */
    public boolean remove(Integer id){
        if (id == null) {
            return false;
        }
        Carta carta = new Carta(id);
        if (!deck.contains(carta)) {
            return false;
        }
        deck.remove(carta);
        return true;
    }

    /**
     * Metodo que permite modificar una carta del deck
     * @param carta
     * @return boolean
     */
    public boolean update(Carta carta){
        if (carta == null) {
            return false;
        }
        int posicion = deck.indexOf(carta);
        if (posicion == -1) {
            return false;
        }
        deck.set(posicion, carta);
        return true;
    }

    /**
     * Metodo que permite leer una carta del deck
     * @param carta
     * @return Carta
     */
    public Carta read(Integer id){
        if (id == null) {
            return null;
        }
        Carta carta = new Carta(id);
        int posicion = deck.indexOf(carta);
        if (posicion == -1) {
            return null;
        }
        return deck.get(posicion);
    }
}
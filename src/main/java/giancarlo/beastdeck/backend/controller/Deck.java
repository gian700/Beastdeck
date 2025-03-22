package giancarlo.beastdeck.backend.controller;

import java.util.HashMap;
/**
 * @author Giancarlo
 * @version 1.0.0
 */
public class Deck {
    private HashMap<Integer, Carta> deck; 

    public Deck() {
    }

    public Deck(HashMap<Integer,Carta> deck) {
        this.deck = deck;
    }

    public HashMap<Integer,Carta> getDeck() {
        return this.deck;
    }

    public void setDeck(HashMap<Integer,Carta> deck) {
        this.deck = deck;
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
        if (deck.containsKey(carta.getId())) {
            return false;
        }
        deck.put(carta.getId(), carta);
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
        if (!deck.containsKey(id)) {
            return false;
        }
        deck.remove(id);
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
        if (!deck.containsKey(carta.getId())) {
            return false;
        }
        deck.replace(carta.getId(), carta);
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
        if (!deck.containsKey(id)) {
            return null;
        }
        return deck.get(id);
    }
}
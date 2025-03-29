package giancarlo.beastdeck.backend.controller;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Giancarlo
 * @version 1.0.0
 */
public class Rival {
    Deck deck;

    public Rival(Deck deck){
        this.deck = deck;
    }

    public Deck getDeck(){
        return this.deck;
    }

    /**
     * Metodo que permite al bot elegir la carta a usar
     * @param deckUsuario
     * @return
     */
    public int mejorOpcion(Deck deckUsuario){

        List<Integer> comprobar = new ArrayList<>();
        Combate combate = new Combate();
        Integer orden;
        Carta carta;
        Carta cartaUsuario;
        int ordenRival;


        for (int i = 0; i < deck.getDeck().size(); i++) {
            carta = deck.getDeck().get(i);
            orden = carta.getordenRecomendado();

            for (int j = 0; j < deckUsuario.getDeck().size(); j++) {
                cartaUsuario = deckUsuario.getDeck().get(j);
                ordenRival = (cartaUsuario.getordenRecomendado())/2;
                int batalla = (int) combate.comprobarGanador(carta, cartaUsuario);
                switch (batalla) {
                    case 2 -> {orden += 1 + ordenRival;}
                    case 0 -> {orden -= (1 + ordenRival);}
                }
            }
            comprobar.add(orden);
        }
        Integer ganador = comprobar.get(0);
        for (int i = 0; i < comprobar.size(); i++) {
            orden = comprobar.get(i);
            if (orden > ganador) {
                ganador = orden;
            }
        }
        int posicion = comprobar.indexOf(ganador);
        return posicion;
    }
}

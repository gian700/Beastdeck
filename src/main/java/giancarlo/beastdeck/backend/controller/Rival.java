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

    public int mejorOpcion(Deck deckUsuario){

        List<Integer> comprobar = new ArrayList<>();
        Integer orden = 0;

        for (int i = 0; i < deck.getDeck().size(); i++) {
            Carta carta = deck.getDeck().get(i);
            orden = carta.getordenRecomendado();

            for (int j = 0; j < deckUsuario.getDeck().size(); j++) {
                Carta cartaUsuario = deckUsuario.getDeck().get(j);
                Combate combate = new Combate();
                int batalla = (int) combate.comprobarGanador(carta, cartaUsuario);
                switch (batalla) {
                    case 2 -> {orden += 1;}
                    case 0 -> {orden -= 1;}
                    default -> {}
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

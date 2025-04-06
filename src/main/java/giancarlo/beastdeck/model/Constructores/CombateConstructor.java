package giancarlo.beastdeck.model.Constructores;

import java.util.List;

import giancarlo.beastdeck.model.abstractas.TipoFuncionamiento;
import giancarlo.beastdeck.model.clases.Carta;
import giancarlo.beastdeck.model.clases.Deck;
import giancarlo.beastdeck.model.clases.Jugador;
import giancarlo.beastdeck.model.clases.Rival;

public abstract class CombateConstructor extends TipoFuncionamiento{
private Jugador jugador;
    private Deck deckPropio;
    private Rival rival;
    private Deck deckRival;
    private float puntuacionPropia;
    private float puntuacionRival;
    private float puntuacionTemporalPropia;
    private float puntuacionTemporalRival;


    public CombateConstructor() {
    }


    public CombateConstructor(Jugador jugador, Rival rival) {
        this.jugador = jugador;
        this.deckPropio = jugador.getDeck();
        this.rival = rival;
        this.deckRival = rival.getDeck();
        this.puntuacionPropia = 0;
        this.puntuacionRival = 0;
        this.puntuacionTemporalPropia = 0;
        this.puntuacionTemporalRival = 0;
    }
    

    public Jugador getJugador() {
        return this.jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public List<Carta> getDeckPropio() {
        return this.deckPropio.getDeck();
    }

    public void setDeckPropio(Deck deckPropio) {
        this.deckPropio = deckPropio;
    }

    public Rival getRival() {
        return this.rival;
    }

    public void setRival(Rival rival) {
        this.rival = rival;
    }

    public List<Carta> getDeckRival() {
        return this.deckRival.getDeck();
    }

    public void setDeckRival(Deck deckRival) {
        this.deckRival = deckRival;
    }

    public float getPuntuacionPropia() {
        return this.puntuacionPropia;
    }

    public void setPuntuacionPropia(float puntuacionPropia) {
        this.puntuacionPropia = puntuacionPropia;
    }

    public float getPuntuacionRival() {
        return this.puntuacionRival;
    }

    public void setPuntuacionRival(float puntuacionRival) {
        this.puntuacionRival = puntuacionRival;
    }

    public float getPuntuacionTemporalPropia() {
        return this.puntuacionTemporalPropia;
    }

    public void setPuntuacionTemporalPropia(float puntuacionTemporalPropia) {
        this.puntuacionTemporalPropia = puntuacionTemporalPropia;
    }

    public float getPuntuacionTemporalRival() {
        return this.puntuacionTemporalRival;
    }

    public void setPuntuacionTemporalRival(float puntuacionTemporalRival) {
        this.puntuacionTemporalRival = puntuacionTemporalRival;
    }

}

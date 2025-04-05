package giancarlo.beastdeck.model.Constructores;

import java.util.Objects;

import giancarlo.beastdeck.model.Combate;
import giancarlo.beastdeck.model.Deck;
import giancarlo.beastdeck.model.Jugador;
import giancarlo.beastdeck.model.Rival;
import giancarlo.beastdeck.model.abstractas.TipoFuncionamiento;

public abstract class CombateConstructor extends TipoFuncionamiento{
private Jugador jugador;
    private Deck deckPropio;
    private Rival rival;
    private Deck deckRival;
    private float puntuacionPropia;
    private float puntuacionRival;
    private float puntuacionTemporalPropia;
    private float puntuacionTemporalRival;

    public Jugador getJugador() {
        return this.jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Deck getDeckPropio() {
        return this.deckPropio;
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

    public Deck getDeckRival() {
        return this.deckRival;
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

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
    private int puntuacionPropia;
    private int puntuacionRival;
    private int puntuacionTemporalPropia;
    private int puntuacionTemporalRival;
    private int turno;


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
        this.turno = 4;
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

    public Deck getDeckPropioDeck() {
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

    public List<Carta> getDeckRival() {
        return this.deckRival.getDeck();
    }

    public Deck getDeckRivalDeck() {
        return this.deckRival;
    }

    public void setDeckRival(Deck deckRival) {
        this.deckRival = deckRival;
    }

    public int getPuntuacionPropia() {
        return this.puntuacionPropia;
    }

    public void setPuntuacionPropia(int puntuacionPropia) {
        this.puntuacionPropia = puntuacionPropia;
    }

    public int getPuntuacionRival() {
        return this.puntuacionRival;
    }

    public void setPuntuacionRival(int puntuacionRival) {
        this.puntuacionRival = puntuacionRival;
    }

    public int getPuntuacionTemporalPropia() {
        return this.puntuacionTemporalPropia;
    }

    public void setPuntuacionTemporalPropia(int puntuacionTemporalPropia) {
        this.puntuacionTemporalPropia = puntuacionTemporalPropia;
    }

    public int getPuntuacionTemporalRival() {
        return this.puntuacionTemporalRival;
    }

    public void setPuntuacionTemporalRival(int puntuacionTemporalRival) {
        this.puntuacionTemporalRival = puntuacionTemporalRival;
    }

    public int getTurno() {
        return this.turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public void turnoM(){
        this.turno = turno-1;
    }
    @Override
    public String toString() {
        return "{" +
            " jugador='" + getJugador() + "'" +
            ", deckPropio='" + getDeckPropio() + "'" +
            ", rival='" + getRival() + "'" +
            ", deckRival='" + getDeckRival() + "'" +
            ", puntuacionPropia='" + getPuntuacionPropia() + "'" +
            ", puntuacionRival='" + getPuntuacionRival() + "'" +
            ", puntuacionTemporalPropia='" + getPuntuacionTemporalPropia() + "'" +
            ", puntuacionTemporalRival='" + getPuntuacionTemporalRival() + "'" +
            "}";
    }

}

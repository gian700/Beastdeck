package giancarlo.beastdeck.backend.controller;

import java.util.Objects;

import giancarlo.beastdeck.backend.controller.abstractas.TipoFuncionamiento;

/**
 * @author Giancarlo
 * @version 1.0.0
 */
public class Combate extends TipoFuncionamiento{
    private Jugador jugador;
    private Deck deckPropio;
    private Rival rival;
    private Deck deckRival;
    private float puntuacionPropia;
    private float puntuacionRival;
    private float puntuacionTemporalPropia;
    private float puntuacionTemporalRival;

    public Combate() {
    }

    public Combate(Jugador jugador, Rival rival) {
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

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Combate)) {
            return false;
        }
        Combate combate = (Combate) o;
        return Objects.equals(jugador, combate.jugador) && Objects.equals(deckPropio, combate.deckPropio) && Objects.equals(rival, combate.rival) && Objects.equals(deckRival, combate.deckRival) && puntuacionPropia == combate.puntuacionPropia && puntuacionRival == combate.puntuacionRival && puntuacionTemporalPropia == combate.puntuacionTemporalPropia && puntuacionTemporalRival == combate.puntuacionTemporalRival;
    }

    @Override
    public int hashCode() {
        return Objects.hash(jugador, deckPropio, rival, deckRival, puntuacionPropia, puntuacionRival, puntuacionTemporalPropia, puntuacionTemporalRival);
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

    /**
     * Metodo que permite llevar las rondas de la batalla despues de elegir las cartas a usar
     * @param cartaPropia
     * @param cartaRival
     */
    public void ronda (Carta cartaPropia, Carta cartaRival){
        if (cartaPropia == null || cartaRival == null) {
            throw new IllegalArgumentException("Carta nula");
        }
        if (!cartaPropia.validar() || !cartaRival.validar()) {
            throw new IllegalArgumentException("Una o mas variable es nula");
        }
        if (cartaPropia.getUtilizada() || cartaRival.getUtilizada()) {
            return;
        }
        cartaPropia.activarHabilidades(this, cartaRival, cartaPropia);
        cartaRival.activarHabilidades(this, cartaPropia, cartaPropia);

        float multiplicador = comprobarGanador(cartaPropia, cartaRival);
        puntuacionTemporalPropia = (cartaPropia.getFuerza()*multiplicador) * 100;
        puntuacionTemporalRival = (cartaRival.getFuerza()/multiplicador) * 100;

        cartaPropia.activarHabilidades(this, cartaRival, cartaPropia);
        cartaRival.activarHabilidades(this, cartaPropia, cartaPropia);
        
        puntuacionPropia += puntuacionTemporalPropia;
        puntuacionRival += puntuacionTemporalRival;
    }

}

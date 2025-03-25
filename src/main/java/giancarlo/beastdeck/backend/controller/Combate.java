package giancarlo.beastdeck.backend.controller;

import java.util.Objects;

import giancarlo.beastdeck.backend.controller.abstractas_interfaces.TipoFuncionamiento;

/**
 * @author Giancarlo
 * @version 1.0.0
 */
public class Combate extends TipoFuncionamiento{
    private Jugador jugador;
    private Deck deckPropio;
    private Rival rival;
    private Deck deckRival;
    private double puntuacionPropia;
    private double puntuacionRival;
    private double puntuacionTemporalPropia;
    private double puntuacionTemporalRival;

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

    public double getPuntuacionPropia() {
        return this.puntuacionPropia;
    }

    public void setPuntuacionPropia(double puntuacionPropia) {
        this.puntuacionPropia = puntuacionPropia;
    }

    public double getPuntuacionRival() {
        return this.puntuacionRival;
    }

    public void setPuntuacionRival(double puntuacionRival) {
        this.puntuacionRival = puntuacionRival;
    }

    public double getPuntuacionTemporalPropia() {
        return this.puntuacionTemporalPropia;
    }

    public void setPuntuacionTemporalPropia(double puntuacionTemporalPropia) {
        this.puntuacionTemporalPropia = puntuacionTemporalPropia;
    }

    public double getPuntuacionTemporalRival() {
        return this.puntuacionTemporalRival;
    }

    public void setPuntuacionTemporalRival(double puntuacionTemporalRival) {
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
        cartaPropia.activarHabilidades(this, cartaRival,true);
        cartaRival.activarHabilidades(this, cartaPropia,true);
        double multiplicador = comprobarGanador(cartaPropia, cartaRival);
        puntuacionTemporalPropia = (cartaPropia.getFuerza()*multiplicador) * 100;
        puntuacionTemporalRival = (cartaRival.getFuerza()/multiplicador) * 100;
        cartaPropia.activarHabilidades(this, cartaRival,false);
        cartaRival.activarHabilidades(this, cartaPropia,false);
        puntuacionPropia += puntuacionTemporalPropia;
        puntuacionRival += puntuacionTemporalRival;
    }

}

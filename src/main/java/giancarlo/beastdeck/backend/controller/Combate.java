package giancarlo.beastdeck.backend.controller;

import java.util.Objects;

import giancarlo.beastdeck.backend.controller.abstractas_interfaces.TipoFuncionamiento;

/**
 * @author Giancarlo
 * @version 1.0.0
 */
public class Combate extends TipoFuncionamiento{
    Jugador jugador;
    Deck deckPropio;
    Rival rival;
    Deck deckRival;
    int puntuacionPropia;
    int puntuacionRival;
    int puntuacionTemporalPropia;
    int puntuacionTemporalRival;
    Combate combateCopy;

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

    public Combate getCombateCopy() {
        return this.combateCopy;
    }

    public void setCombateCopy(Combate combateCopy) {
        this.combateCopy = combateCopy;
    }


    public Combate(Jugador jugador, Deck deckPropio, Rival rival, Deck deckRival, int puntuacionPropia, int puntuacionRival, int puntuacionTemporalPropia, int puntuacionTemporalRival, Combate combateCopy) {
        this.jugador = jugador;
        this.deckPropio = deckPropio;
        this.rival = rival;
        this.deckRival = deckRival;
        this.puntuacionPropia = puntuacionPropia;
        this.puntuacionRival = puntuacionRival;
        this.puntuacionTemporalPropia = puntuacionTemporalPropia;
        this.puntuacionTemporalRival = puntuacionTemporalRival;
        this.combateCopy = combateCopy;
    }

    public Combate jugador(Jugador jugador) {
        setJugador(jugador);
        return this;
    }

    public Combate deckPropio(Deck deckPropio) {
        setDeckPropio(deckPropio);
        return this;
    }

    public Combate rival(Rival rival) {
        setRival(rival);
        return this;
    }

    public Combate deckRival(Deck deckRival) {
        setDeckRival(deckRival);
        return this;
    }

    public Combate puntuacionPropia(int puntuacionPropia) {
        setPuntuacionPropia(puntuacionPropia);
        return this;
    }

    public Combate puntuacionRival(int puntuacionRival) {
        setPuntuacionRival(puntuacionRival);
        return this;
    }

    public Combate puntuacionTemporalPropia(int puntuacionTemporalPropia) {
        setPuntuacionTemporalPropia(puntuacionTemporalPropia);
        return this;
    }

    public Combate puntuacionTemporalRival(int puntuacionTemporalRival) {
        setPuntuacionTemporalRival(puntuacionTemporalRival);
        return this;
    }

    public Combate combateCopy(Combate combateCopy) {
        setCombateCopy(combateCopy);
        return this;
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
            ", combateCopy='" + getCombateCopy() + "'" +
            "}";
    }

}

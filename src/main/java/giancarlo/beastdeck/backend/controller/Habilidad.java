package giancarlo.beastdeck.backend.controller;

import java.util.Objects;

import giancarlo.beastdeck.backend.controller.dependencias.habilidades.habilidadesActivas.HabilidadActC;
import giancarlo.beastdeck.backend.controller.dependencias.habilidades.habilidadesActivas.HabilidadActLegendary;
import giancarlo.beastdeck.backend.controller.dependencias.habilidades.habilidadesActivas.HabilidadActR;
import giancarlo.beastdeck.backend.controller.dependencias.habilidades.habilidadesActivas.HabilidadActSR;
import giancarlo.beastdeck.backend.controller.dependencias.habilidades.habilidadesActivas.HabilidadActUR;
import giancarlo.beastdeck.backend.controller.enums.EnumRarezas;

/**
 * @author Giancarlo
 * @version 1.0.0
 */
public class Habilidad{
    int id;
    String nombre;
    String descripcion;
    EnumRarezas rareza;
    boolean activa;
    boolean rapida;

    public Habilidad() {
    }

    public Habilidad(int id, String nombre, String descripcion, EnumRarezas rareza, boolean activa, boolean rapida) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rareza = rareza;
        this.activa = activa;
        this.rapida = rapida;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EnumRarezas getRareza() {
        return this.rareza;
    }

    public void setRareza(EnumRarezas rareza) {
        this.rareza = rareza;
    }

    public boolean getActiva(){
        return this.activa;
    }

    public boolean getRapida(){
        return this.rapida;
    }

    public void setRapida(){
        this.rapida = !rapida;
    }

    public Habilidad id(int id) {
        setId(id);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Habilidad)) {
            return false;
        }
        Habilidad habilidades = (Habilidad) o;
        return id == habilidades.id && Objects.equals(rareza, habilidades.rareza) && Objects.equals(activa, habilidades.activa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rareza, activa);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", descripcion='" + getDescripcion() + "'" +
            ", rareza='" + getRareza() + "'" +
            "}";
    }
    
    
    public void activar(Carta cartaPropia, Combate combate, Carta cartaRival){
        switch (getRareza()) {
            case C -> {
                new HabilidadActC(getId(), cartaPropia, combate, cartaRival);
            }
            case R -> {
                new HabilidadActR(getId(), cartaPropia, combate, cartaRival);
            }
            case SR -> {
                new HabilidadActSR(getId(), cartaPropia, combate, cartaRival);
            }
            case UR -> {
                new HabilidadActUR(getId(), cartaPropia, combate, cartaRival);
            }
            case LEGENDARY -> {
                new HabilidadActLegendary(getId(), cartaPropia, combate, cartaRival);
            }
            default -> {
            }
        }
    }
}

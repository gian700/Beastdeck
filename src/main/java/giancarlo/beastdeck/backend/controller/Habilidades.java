package giancarlo.beastdeck.backend.controller;

import java.util.Objects;

import giancarlo.beastdeck.backend.controller.enums.EnumRarezas;

/**
 * @author Giancarlo
 * @version 1.0.0
 */
public class Habilidades{
    int id;
    String nombre;
    String descripcion;
    EnumRarezas rareza;
    boolean activa;

    public Habilidades() {
    }

    public Habilidades(int id, String nombre, String descripcion, EnumRarezas rareza, boolean activa) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rareza = rareza;
        this.activa = activa;
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

    public Habilidades id(int id) {
        setId(id);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Habilidades)) {
            return false;
        }
        Habilidades habilidades = (Habilidades) o;
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
    
}

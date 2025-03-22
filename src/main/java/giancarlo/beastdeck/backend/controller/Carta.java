package giancarlo.beastdeck.backend.controller;

import java.util.Objects;

import giancarlo.beastdeck.backend.controller.dependencias.Habilidades;
import giancarlo.beastdeck.backend.controller.enums.EnumRarezas;
import giancarlo.beastdeck.backend.controller.enums.EnumTipos;


/**
 * @author Giancarlo
 * @version 1.0.0
 */
public class Carta{

    private Integer id;
    private String nombre;
    private String descripcion;
    private EnumRarezas rareza;
    private EnumTipos tipo;
    private Habilidades habilidad;
    private int fuerza;

    /**
     * Constructor vacio 
    */
    public Carta() {
    }

    /**
     * Constructor generico
     * @param id
     * @param nombre
     * @param descripcion
     * @param rareza
     * @param tipo
     * @param habilidad
     * @param fuerza
     */
    public Carta(Integer id, String nombre, String descripcion, EnumRarezas rareza, EnumTipos tipo, Habilidades habilidad, int fuerza) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rareza = rareza;
        this.tipo = tipo;
        this.habilidad = habilidad;
        this.fuerza = fuerza;
    }

    /**
     * getter y Setter
     * @return
     */
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
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

    public EnumTipos getTipo() {
        return this.tipo;
    }

    public void setTipo(EnumTipos tipo) {
        this.tipo = tipo;
    }

    public Habilidades getHabilidad() {
        return this.habilidad;
    }

    public void setHabilidad(Habilidades habilidad) {
        this.habilidad = habilidad;
    }

    public int getFuerza() {
        return this.fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Carta)) {
            return false;
        }
        Carta carta = (Carta) o;
        return Objects.equals(id, carta.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", descripcion='" + getDescripcion() + "'" +
            ", rareza='" + getRareza() + "'" +
            ", tipo='" + getTipo() + "'" +
            ", habilidad='" + getHabilidad() + "'" +
            ", fuerza='" + getFuerza() + "'" +
            "}";
    }

}

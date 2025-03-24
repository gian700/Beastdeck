package giancarlo.beastdeck.backend.controller;

import java.util.Objects;

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
    private Habilidades habilidades;
    private int fuerza;
    private int ordenRecomendado;

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
     * @param habilidades
     * @param fuerza
     * @param ordenRecomendado
     */
    public Carta(Integer id, String nombre, String descripcion, EnumRarezas rareza, EnumTipos tipo, Habilidades habilidades, int fuerza, int ordenRecomendado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rareza = rareza;
        this.tipo = tipo;
        this.habilidades = habilidades;
        this.fuerza = fuerza;
        this.ordenRecomendado = ordenRecomendado;
    }

    public Carta(Integer id){
        this.id = id;
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

    public Habilidades getHabilidades() {
        return this.habilidades;
    }

    public void setHabilidades(Habilidades habilidades) {
        this.habilidades = habilidades;
    }

    public int getFuerza() {
        return this.fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }
    public int getordenRecomendado(){
        return ordenRecomendado;
    }
    public void setordenRecomendado(int ordenRecomendado){
        this.ordenRecomendado = ordenRecomendado;
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
            ", habilidades='" + getHabilidades() + "'" +
            ", fuerza='" + getFuerza() + "'" +
            ", orden='" + getordenRecomendado() + "'" +
            "}";
    }

    /**
     * Metodo que activa la habilidades de una carta
     * @param combate
     * @param cartaRival
     */
    public void activarHabilidades(Combate combate, Carta cartaRival){

    }

}

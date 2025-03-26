package giancarlo.beastdeck.backend.controller;

import java.util.List;
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
    private List<Habilidad> habilidades;
    private int fuerza;
    private int ordenRecomendado;
    private boolean utilizada;

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
    public Carta(Integer id, String nombre, String descripcion, EnumRarezas rareza, EnumTipos tipo, List<Habilidad> habilidades, int fuerza, int ordenRecomendado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rareza = rareza;
        this.tipo = tipo;
        this.habilidades = habilidades;
        this.fuerza = fuerza;
        this.ordenRecomendado = ordenRecomendado;
        this.utilizada = false;
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

    public List<Habilidad> getHabilidades() {
        return this.habilidades;
    }

    public void setHabilidades(List<Habilidad> habilidades) {
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
    public boolean getUtilizada(){
        return utilizada;
    }
    /**
     * funcion que cambia el boolean a su contraparte
     */
    public void cambioUtilizada(){
        utilizada = !utilizada;
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
    public void activarHabilidades(Combate combate, Carta cartaRival, Carta cartaPropia){
        for (Habilidad habilidad : getHabilidades()) {
            if (habilidad.getActiva() && habilidad.getRapida()) {
                habilidad.activar(cartaPropia, combate, cartaRival);
            }
            habilidad.setRapida();
            
        }
    }

    /**
     * Metodo que valida que una carta tenga toda la informacion que necesita
     * @return
     */
    public boolean validar(){

        if (id == null || id < 0) {
            return false;
        }
        if (nombre == null || nombre.isBlank()) {
            return false;
        }
        if (descripcion == null || descripcion.isBlank()) {
            return false;
        }
        if (rareza == null || tipo == null) {
            return false;
        }
        return habilidades != null;
    }
}

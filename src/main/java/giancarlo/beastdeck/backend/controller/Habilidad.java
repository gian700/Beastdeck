package giancarlo.beastdeck.backend.controller;

import java.util.Objects;

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
    
    /**
     * Metodo que activa las habilidades
     * @param cartaPropia
     * @param combate
     * @param cartaRival
     */
    public void activar(Carta cartaPropia, Combate combate, Carta cartaRival) {
        switch (id) {
            case 0 -> generico();
            case 1 -> DobleFuerza(cartaPropia);
            case 2 -> inutilidad(cartaRival);
            default -> throw new AssertionError("habilidad no existente");
        }
    }

    /**
     * Metodo generico, copiar este metodo para crear nueva habilidad
     * @param cartaPropia
     * @param combate
     * @param cartaRival
     */
    private void generico(){}

    /**
     * Habilidad que multiplica por 2 la fuerza de la carta
     * @param cartaPropia
     * @param combate
     * @param cartaRival
     */
    private void DobleFuerza(Carta cartaPropia){
        cartaPropia.setFuerza(cartaPropia.getFuerza()*2);
    }

    /**
     * Habilidad que le baja a la mitad la fuerza, redondeando hacia bajo en caso, 
     * @param cartaPropia
     * @param combate
     * @param cartaRival
     */
    private void inutilidad(Carta cartaRival){
        cartaRival.setFuerza(cartaRival.getFuerza()/2);
        
    }
    
}

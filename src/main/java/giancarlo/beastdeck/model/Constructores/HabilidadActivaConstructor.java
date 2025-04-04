package giancarlo.beastdeck.model.Constructores;

import giancarlo.beastdeck.model.enums.EnumRarezas;

public abstract class HabilidadActivaConstructor {
    int id;
    String nombre;
    String descripcion;
    EnumRarezas rareza;
    boolean activa;
    boolean rapida;


    public HabilidadActivaConstructor(int id, String nombre, String descripcion, EnumRarezas rareza, boolean activa, boolean rapida) {
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
}

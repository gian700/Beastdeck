package giancarlo.beastdeck.model.Constructores;

import giancarlo.beastdeck.model.enums.EnumRarezas;

public abstract class HabilidadActivaConstructor {
    int id;
    String nombre;
    String descripcion;
    EnumRarezas rareza;
    boolean rapida;

    public HabilidadActivaConstructor(){}

    public HabilidadActivaConstructor(int id, String nombre, String descripcion, EnumRarezas rareza, boolean rapida) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rareza = rareza;
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

    public boolean getRapida(){
        return this.rapida;
    }

    public void setRapida(){
        this.rapida = !rapida;
    }

    @Override
    public String toString() {
        return
            getNombre() + ": \n" +
            getDescripcion();
    }

}

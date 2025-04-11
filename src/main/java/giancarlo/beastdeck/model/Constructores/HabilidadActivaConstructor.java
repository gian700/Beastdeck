package giancarlo.beastdeck.model.Constructores;

public abstract class HabilidadActivaConstructor {
    int id;
    String nombre;
    String descripcion;
    boolean rapida;

    public HabilidadActivaConstructor(){}

    public HabilidadActivaConstructor(int id, String nombre, String descripcion, boolean rapida) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
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
            getDescripcion() + "\n"
            + getId();
            
    }

}

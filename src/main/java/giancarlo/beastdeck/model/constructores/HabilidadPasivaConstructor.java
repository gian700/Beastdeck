package giancarlo.beastdeck.model.constructores;
import java.util.Objects;

public abstract class HabilidadPasivaConstructor {
    private int id;
    private String nombre;
    private String descripcion;
    private boolean continua;
    private boolean bot;

    public HabilidadPasivaConstructor() {
    }

    public HabilidadPasivaConstructor(int id, String nombre, String descripcion, boolean continua, boolean bot) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.continua = continua;
        this.bot = bot;
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

    public boolean getContinua() {
        return this.continua;
    }

    public void setContinua(boolean continua) {
        this.continua = continua;
    }

    public boolean isBot() {
        return this.bot;
    }

    public boolean getBot() {
        return this.bot;
    }

    public HabilidadPasivaConstructor id(int id) {
        setId(id);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof HabilidadPasivaConstructor)) {
            return false;
        }
        HabilidadPasivaConstructor habilidadPasivaConstructor = (HabilidadPasivaConstructor) o;
        return id == habilidadPasivaConstructor.id ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        if (bot) {
            return "";
        }
        return 
            getNombre() + "\n" 
            + getDescripcion();
    }
    
}

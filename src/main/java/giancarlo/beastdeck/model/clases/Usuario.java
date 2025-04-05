package giancarlo.beastdeck.model.clases;

import java.util.Objects;

public class Usuario {
    private String nombre;
    private String contrasenia;

    /**
     * Constructor por defecto.
     */
    public Usuario() {
    }

    /**
     * Constructor general.
     * 
     * @param nombre
     * @param contrasenia
     * @param email
     */
    public Usuario(String nombre, String contrasenia) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getContrasenia() {
        return this.contrasenia;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Usuario)) {
            return false;
        }
        Usuario usuario = (Usuario) o;
        return Objects.equals(nombre, usuario.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        return getNombre() + getContrasenia();
    }

}

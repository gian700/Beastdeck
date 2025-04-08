package giancarlo.beastdeck.model.Constructores;

import java.util.List;

import giancarlo.beastdeck.model.clases.HabilidadActiva;
import giancarlo.beastdeck.model.clases.HabilidadPasiva;
import giancarlo.beastdeck.model.enums.EnumRarezas;
import giancarlo.beastdeck.model.enums.EnumTipos;

public abstract class CartaConstructor {
    private Integer id;
    private String nombre;
    private String descripcion;
    private EnumRarezas rareza;
    private EnumTipos tipo;
    private List<HabilidadActiva> habilidadesActivas;
    private List<HabilidadPasiva> habilidadesPasivas;
    private int fuerza;
    private int ordenRecomendado;
    private boolean utilizada;
    private boolean desbloqueada;
    private String imagen;


    public CartaConstructor() {
    }

    public CartaConstructor(Integer id) {
        this.id = id;
    }

    public CartaConstructor(Integer id, String nombre, String descripcion, EnumRarezas rareza, EnumTipos tipo, List<HabilidadActiva> habilidadesActivas, List<HabilidadPasiva> habilidadesPasivas, int fuerza, int ordenRecomendado, boolean desbloqueada, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rareza = rareza;
        this.tipo = tipo;
        this.habilidadesActivas = habilidadesActivas;
        this.habilidadesPasivas = habilidadesPasivas;
        this.fuerza = fuerza;
        this.ordenRecomendado = ordenRecomendado;
        this.utilizada = false;
        this.desbloqueada = desbloqueada;
        this.imagen = imagen;
    }


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

    public List<HabilidadActiva> getHabilidadesActivas() {
        return this.habilidadesActivas;
    }

    public void setHabilidadesActivas(List<HabilidadActiva> habilidadesActivas) {
        this.habilidadesActivas = habilidadesActivas;
    }

    public List<HabilidadPasiva> getHabilidadesPasivas() {
        return this.habilidadesPasivas;
    }

    public void setHabilidadesPasivas(List<HabilidadPasiva> habilidadesPasivas) {
        this.habilidadesPasivas = habilidadesPasivas;
    }

    public int getFuerza() {
        return this.fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getOrdenRecomendado() {
        return this.ordenRecomendado;
    }

    public void setOrdenRecomendado(int ordenRecomendado) {
        this.ordenRecomendado = ordenRecomendado;
    }

    public boolean isUtilizada() {
        return this.utilizada;
    }

    public boolean getUtilizada() {
        return this.utilizada;
    }

    public void setUtilizada(boolean utilizada) {
        this.utilizada = utilizada;
    }

    public boolean isDesbloqueada() {
        return this.desbloqueada;
    }

    public boolean getDesbloqueada() {
        return this.desbloqueada;
    }

    public void setDesbloqueada(boolean desbloqueada) {
        this.desbloqueada = desbloqueada;
    }

    public boolean cambiarEstadoPasivas(){
        return false;
    }

    public String getImagen() {
        return this.imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getCodigoActivas(){
        String codigo = "0";
        for (HabilidadActiva habilidadActiva : habilidadesActivas) {
            codigo += ","+ habilidadActiva.getId();
        }
        return codigo;
    }

    @Override
    public String toString() {
        return 
            (getUtilizada() ? "Utilizada \n": "")+ 
            "id: " + getId() +" "+ getTipo() +" "+ getFuerza() +" \n" + 
            getNombre() +" "+ getRareza() +"\n"+
            getDescripcion() + "\n" +

            (habilidadesActivas.isEmpty() ? "" : "Al usarla: \n" + getHabilidadesActivas() + "\n") +
            (habilidadesPasivas.isEmpty() ? "" : "Al Tenerla en el campo: \n" + getHabilidadesActivas());
    }
}

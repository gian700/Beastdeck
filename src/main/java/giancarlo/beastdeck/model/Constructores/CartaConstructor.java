package giancarlo.beastdeck.model.Constructores;

import java.util.List;

import giancarlo.beastdeck.model.HabilidadActiva;
import giancarlo.beastdeck.model.HabilidadPasiva;
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
}

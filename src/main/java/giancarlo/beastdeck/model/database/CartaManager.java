package giancarlo.beastdeck.model.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import giancarlo.beastdeck.config.ConfigManager;
import giancarlo.beastdeck.model.clases.Carta;
import giancarlo.beastdeck.model.clases.HabilidadActiva;
import giancarlo.beastdeck.model.clases.HabilidadPasiva;
import giancarlo.beastdeck.model.enums.EnumRarezas;
import giancarlo.beastdeck.model.enums.EnumTipos;

public class CartaManager extends DatabaseManager{

    List<EnumTipos> tipos = new ArrayList<>(Arrays.asList(EnumTipos.AGUA, EnumTipos.FUEGO, EnumTipos.PLANTA, EnumTipos.BESTIA, EnumTipos.TIERRA, EnumTipos.ELECTRICO, EnumTipos.VOLADOR));
    List<EnumRarezas> rarezas = new ArrayList<>(Arrays.asList(EnumRarezas.C, EnumRarezas.R, EnumRarezas.SR, EnumRarezas.UR, EnumRarezas.LEGENDARY));

    public CartaManager() throws SQLException {
        super();

    }

    public Carta obtenerCartaPorid(int id) {
        try {
            String sql = "SELECT * FROM Carta " + "where id='"+id+"'";
        ArrayList<Carta> cartas = obtenerCarta(sql);
        if (cartas.isEmpty()) {
            return null;
        }
        return cartas.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }  
    }

    public List<Carta> obtenerCartaPorRareza(EnumRarezas rareza) {
        try {
            int posicion = rarezas.indexOf(rareza);
            String sql = "SELECT * FROM Carta " + "where rareza='"+posicion+"'";
            ArrayList<Carta> cartas = obtenerCarta(sql);
            return cartas;

        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }  
    }

    public List<Carta> obtenerCartaPorTipo(EnumTipos tipo) {
        try {
            int posicion = tipos.indexOf(tipo);
            String sql = "SELECT * FROM Carta " + "where tipo='"+posicion+"'";
            ArrayList<Carta> cartas = obtenerCarta(sql);
            return cartas;

        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }  
    }

    public List<Carta> obtenerCartaPorRarezayTipo(EnumRarezas rareza, EnumTipos tipo ) {
        int posicionT = tipos.indexOf(tipo);
        int posicionR = rarezas.indexOf(rareza);
        try {
            String sql = "SELECT * FROM Carta " + "where rareza='"+posicionR+"' AND tipo='" + posicionT + "'";
            ArrayList<Carta> Cartas = obtenerCarta(sql);
            
            return Cartas;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }  
    }

    public ArrayList<Carta> obtenerCartas() throws SQLException {
        String sql = "SELECT * FROM carta";
        return obtenerCarta(sql);
    }

    protected ArrayList<Carta> obtenerCarta(String sql) throws SQLException {
        ArrayList<Carta> Cartas = new ArrayList<>();
        try {
            PreparedStatement sentencia = getConnection().prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();
           

            while (resultado.next()) {

                PreparedStatement sentenciaIdioma = getConnection().prepareStatement("SELECT * FROM " +
                ConfigManager.ConfigProperties.getProperty("idioma") +" where id='"+resultado.getInt("id")+"'");

                ResultSet resultadoIdioma = sentenciaIdioma.executeQuery();
                
                Integer id = resultado.getInt("id");
                String nombre = resultadoIdioma.getString("nombreCarta");
                String descripcion = resultadoIdioma.getString("descCarta");
                EnumRarezas rareza = rarezas.get(resultado.getInt("rareza"));
                EnumTipos tipo = tipos.get(resultado.getInt("tipo"));
                int fuerza = resultado.getInt("fuerza");
                int ordenRecomendado = resultado.getInt("ordenRec");
                boolean desbloqueada = true;
                String imagen = resultado.getString("Imagen"); 
                String habActCode = resultado.getString("habActivas");
                    List<HabilidadActiva> habilidadesActivas = new HabilidadActManager().obtenerHabActivaPorid(habActCode);
                List<HabilidadPasiva> habilidadesPasivas = new ArrayList<>();
                
                Carta carta = new Carta(id, nombre, descripcion, rareza, tipo, habilidadesActivas, habilidadesPasivas, fuerza, ordenRecomendado, desbloqueada, imagen);
                Cartas.add(carta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            
            cerrar();
        }
        return Cartas;
    }

    public boolean crearCarta(Carta carta) throws SQLException{
        if (carta == null) {
            return false;
        }
        String query = "INSERT INTO carta(id, rareza, tipo, habActivas, habPass, fuerza, ordenRec, desbloqueada, Imagen) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement pStatement = conectar().prepareStatement(query);
            pStatement.setInt(1, carta.getId());
            pStatement.setInt(2, rarezas.indexOf(carta.getRareza()));
            pStatement.setInt(3, tipos.indexOf(carta.getTipo()));
            pStatement.setString(4, carta.getCodigoActivas());
            pStatement.setString(5, "0");
            pStatement.setInt(6, carta.getFuerza());
            pStatement.setInt(7, carta.getOrdenRecomendado());
            pStatement.setInt(8, 1);
            pStatement.setString(9, carta.getImagen());
            if (pStatement.executeUpdate() == 1) {
                cerrar();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            cerrar();
        }
        return false;
    }

    public boolean updateCarta(Carta carta) throws SQLException{
        if (carta == null) {
            return false;
        }
        String query = "update carta set habActivas=? where id=?";

        try {
            PreparedStatement pStatement = conectar().prepareStatement(query);
            pStatement.setInt(2, carta.getId());
            pStatement.setString(1, carta.getCodigoActivas());
            if (pStatement.executeUpdate() == 1) {
                cerrar();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            cerrar();
        }
        return false;
    }

}

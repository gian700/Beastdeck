package giancarlo.beastdeck.model.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import giancarlo.beastdeck.config.ConfigManager;
import giancarlo.beastdeck.model.clases.Carta;
import giancarlo.beastdeck.model.clases.HabilidadActiva;
import giancarlo.beastdeck.model.clases.HabilidadPasiva;
import giancarlo.beastdeck.model.enums.EnumRarezas;
import giancarlo.beastdeck.model.enums.EnumTipos;

public class CartaManager extends DatabaseManager{

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
            String sql = "SELECT * FROM Carta " + "where rareza='"+rareza.toString()+"'";
            ArrayList<Carta> cartas = obtenerCarta(sql);
            return cartas;

        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }  
    }

    public List<Carta> obtenerCartaPorTipo(EnumTipos tipo) {
        try {
            String sql = "SELECT * FROM Carta " + "where tipo='"+tipo.toString()+"'";
            ArrayList<Carta> cartas = obtenerCarta(sql);
            return cartas;

        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }  
    }

    public List<Carta> obtenerCartaPorRarezayTipo(EnumRarezas rareza, EnumTipos tipo ) {
        try {
            String sql = "SELECT * FROM Carta " + "where rareza='"+rareza.toString()+"' AND tipo='" + tipo.toString() + "'";
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
                EnumRarezas rareza = EnumRarezas.valueOf(resultado.getString("rareza"));
                EnumTipos tipo = EnumTipos.valueOf(resultado.getString("tipo"));
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
            pStatement.setString(2, carta.getRareza().toString());
            pStatement.setString(3, carta.getTipo().toString());
            pStatement.setString(4, carta.getCodigoActivas());
            pStatement.setString(5, "0");
            pStatement.setInt(6, carta.getFuerza());
            pStatement.setInt(7, carta.getOrdenRecomendado());
            pStatement.setString(8, (carta.getDesbloqueada()? "true":"false"));
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

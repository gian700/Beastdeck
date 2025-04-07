package giancarlo.beastdeck.model.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        } catch (Exception e) {
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

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }  
    }

    public List<Carta> obtenerCartaPorTipo(EnumTipos tipo) {
        try {
            int posicion = tipos.indexOf(tipo);
            String sql = "SELECT * FROM Carta " + "where Name='"+posicion+"'";
            ArrayList<Carta> cartas = obtenerCarta(sql);
            return cartas;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }  
    }
/*
    public Carta obtenerCartaPorRarezayTipo(String nombre) {
        try {
            String sql = "SELECT * FROM Carta " + "where Name='"+nombre+"'";
        ArrayList<Carta> Cartas = obtenerCarta(sql);
        if (Cartas.isEmpty()) {
            return null;
        }
        return Cartas.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }  
    }
*/
    public ArrayList<Carta> obtenerCartas() throws SQLException {
        String sql = "SELECT * FROM carta";
        return obtenerCarta(sql);
    }

    protected ArrayList<Carta> obtenerCarta(String sql) throws SQLException {
        ArrayList<Carta> Cartas = new ArrayList<Carta>();
        try {
            PreparedStatement sentencia = getConnection().prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();
           

            while (resultado.next()) {

                //PreparedStatement sentenciaIdioma = getConnection().prepareStatement("SELECT * FROM " +
                //ConfigManager.ConfigProperties.getProperty("idioma") +"where id='"+resultado.getInt("id")+"'");

                //ResultSet resultadoIdioma = sentenciaIdioma.executeQuery();
                
                Integer id = resultado.getInt("id");
                String nombre = "carta"; //resultadoIdioma.getString("nombreCarta");
                String descripcion = "descripcion"; //resultadoIdioma.getString("nombreCarta");
                EnumRarezas rareza = rarezas.get(resultado.getInt("rareza"));
                EnumTipos tipo = tipos.get(resultado.getInt("tipo"));
                List<HabilidadActiva> habilidadesActivas = new ArrayList<>();
                List<HabilidadPasiva> habilidadesPasivas = new ArrayList<>();
                int fuerza = resultado.getInt("fuerza");
                int ordenRecomendado = resultado.getInt("ordenRec");
                boolean desbloqueada = true;
                String imagen = resultado.getString("Imagen");

                Carta carta = new Carta(id, nombre, descripcion, rareza, tipo, habilidadesActivas, habilidadesPasivas, fuerza, ordenRecomendado, desbloqueada, imagen);
                Cartas.add(carta);
            }
        } catch (Exception e) {
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
            pStatement.setInt(4, 0);
            pStatement.setInt(5, 0);
            pStatement.setInt(6, carta.getFuerza());
            pStatement.setInt(7, carta.getOrdenRecomendado());
            pStatement.setInt(8, 1);
            pStatement.setString(9, carta.getImagen());
            if (pStatement.executeUpdate() == 1) {
                cerrar();
                return true;
            }
        } catch (SQLException e) {
            System.out.println("");
            System.out.println("pepe");
            e.printStackTrace();
        }finally {
            cerrar();
        }
        return false;
    }

}

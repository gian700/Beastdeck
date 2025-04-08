package giancarlo.beastdeck.model.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import giancarlo.beastdeck.model.clases.Carta;

public class HabilidadActManager extends DatabaseManager{

    public HabilidadActManager() throws SQLException {
        super();

    }

    public Carta obtenerHabActivaPorid(int id) {
        try {
            String sql = "SELECT * FROM  " + "where id='"+id+"'";
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

    public ArrayList<Carta> obtenerHabAct() throws SQLException {
        String sql = "SELECT * FROM habActiva";
        return obtenerCarta(sql);
    }

    protected ArrayList<Carta> obtenerCarta(String sql) throws SQLException {
        ArrayList<Carta> Cartas = new ArrayList<>();
        try {
            PreparedStatement sentencia = getConnection().prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();
           

           /* 
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

                    List<HabilidadPasiva> habilidadesPasivas = new ArrayList<>();
                    String habActCode = resultado.getString("habActivas");
                
                List<HabilidadActiva> habilidadesActivas = new ArrayList<>();
                
                Carta carta = new Carta(id, nombre, descripcion, rareza, tipo, habilidadesActivas, habilidadesPasivas, fuerza, ordenRecomendado, desbloqueada, imagen);
                Cartas.add(carta);
            }*/

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            
            cerrar();
        }
        return Cartas;
    }

    /*public boolean crearCarta(Carta carta) throws SQLException{
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
            System.out.println("");
            System.out.println("pepe");
            e.printStackTrace();
        }finally {
            cerrar();
        }
        return false;
    }*/

}

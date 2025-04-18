package giancarlo.beastdeck.model.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import giancarlo.beastdeck.config.ConfigManager;
import giancarlo.beastdeck.model.clases.HabilidadPasiva;

public class HabilidadPasivaManager extends DatabaseManager{

    public HabilidadPasivaManager() throws SQLException {
        super();

    }

    public List<HabilidadPasiva> obtenerHabPasivaPorid(String id) {
        ArrayList<HabilidadPasiva> habilidades = new ArrayList<>();
        try {
            String[] idArray = id.split(",");
            int idint;

            for (String idFor : idArray) {
                if (!idFor.equals("0") && !idFor.isBlank()) {
                    idint = Integer.parseInt(idFor);
                String sql = "SELECT * FROM HabilidadPasiva " + "where id='"+idint+"'";
                obtenerHabAct(sql, habilidades);
                }
            }
        return habilidades;

        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }  
    }

    public List<HabilidadPasiva> obtenerHabAct() throws SQLException {
        String sql = "SELECT * FROM HabilidadPasiva";
        List<HabilidadPasiva> habilidades = new ArrayList<>();
        return obtenerHabAct(sql, habilidades);
    }

    protected List<HabilidadPasiva> obtenerHabAct(String sql , List<HabilidadPasiva> habilidades) throws SQLException {
        
        try {
            PreparedStatement sentencia = getConnection().prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();
           
            while (resultado.next()) {

                PreparedStatement sentenciaIdioma = getConnection().prepareStatement("SELECT * FROM " +
                ConfigManager.ConfigProperties.getProperty("idioma") +" where id='"+resultado.getInt("id")+"'");

                ResultSet resultadoIdioma = sentenciaIdioma.executeQuery();
                
                int id = resultado.getInt("id");
                String nombre = resultadoIdioma.getString("nombreHabPasi");
                String descripcion = resultadoIdioma.getString("descHabPasi");
                Boolean continua = resultado.getString("continua").equals("true");
                Boolean bot = resultado.getString("bot").equals("true");
               
                HabilidadPasiva habilidadPasiva =  new HabilidadPasiva(id, nombre, descripcion, continua, bot);
                habilidades.add(habilidadPasiva);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            
            cerrar();
        }
        return habilidades;
    }

    public boolean crearHabAct(HabilidadPasiva habilidad) throws SQLException{
        if (habilidad == null) {
            return false;
        }
        String query = "INSERT INTO HabilidadPasiva(id, continua, bot) VALUES (?, ?, ?)";

        try {
            PreparedStatement pStatement = conectar().prepareStatement(query);
            pStatement.setInt(1, habilidad.getId());
            pStatement.setString(2, (habilidad.getContinua()? "true":"false"));
            pStatement.setString(3, (habilidad.getBot()? "true":"false"));

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

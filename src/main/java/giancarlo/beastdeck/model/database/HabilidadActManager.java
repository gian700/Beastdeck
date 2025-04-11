package giancarlo.beastdeck.model.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import giancarlo.beastdeck.config.ConfigManager;
import giancarlo.beastdeck.model.clases.HabilidadActiva;

public class HabilidadActManager extends DatabaseManager{

    public HabilidadActManager() throws SQLException {
        super();

    }

    public List<HabilidadActiva> obtenerHabActivaPorid(String id) {
        ArrayList<HabilidadActiva> habilidades = new ArrayList<>();
        try {
            String[] idArray = id.split(",");
            int idint;

            for (String idFor : idArray) {
                idint = Integer.parseInt(idFor);
                String sql = "SELECT * FROM  " + "where id='"+idint+"'";
                obtenerHabAct(sql, habilidades);
            }
        return habilidades;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }  
    }

    public List<HabilidadActiva> obtenerHabAct() throws SQLException {
        String sql = "SELECT * FROM habActiva";
        List<HabilidadActiva> habilidades = new ArrayList<>();
        return obtenerHabAct(sql, habilidades);
    }

    protected List<HabilidadActiva> obtenerHabAct(String sql , List<HabilidadActiva> habilidades) throws SQLException {
        
        try {
            PreparedStatement sentencia = getConnection().prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();
           

           
            while (resultado.next()) {

                PreparedStatement sentenciaIdioma = getConnection().prepareStatement("SELECT * FROM " +
                ConfigManager.ConfigProperties.getProperty("idioma") +" where id='"+resultado.getInt("id")+"'");

                ResultSet resultadoIdioma = sentenciaIdioma.executeQuery();
                
                Integer id = resultado.getInt("id");
                String nombre = resultadoIdioma.getString("nombreHabAct");
                String descripcion = resultadoIdioma.getString("descHabAct");
                Boolean rapida = resultado.getBoolean("rapida");
               
                HabilidadActiva habilidadActiva =  new HabilidadActiva(id, nombre, descripcion, rapida);
                habilidades.add(habilidadActiva);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            
            cerrar();
        }
        return habilidades;
    }

    public boolean crearHabAct(HabilidadActiva habilidad) throws SQLException{
        if (habilidad == null) {
            return false;
        }
        String query = "INSERT INTO HabilidadActiva(id, rapida) VALUES (?, ?)";

        try {
            PreparedStatement pStatement = conectar().prepareStatement(query);
            pStatement.setInt(1, habilidad.getId());
            pStatement.setString(2, (habilidad.getRapida()? "true":"false"));

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

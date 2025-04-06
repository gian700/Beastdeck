package giancarlo.beastdeck.model.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import giancarlo.beastdeck.model.clases.Usuario;

public class UsuarioManager extends DatabaseManager{


    public UsuarioManager() throws SQLException {
        super();

    }

    public Usuario obtenerUsuarioPorNombre(String nombre) {
        try {
            String sql = "SELECT * FROM usuario " + "where Name='"+nombre+"'";
        ArrayList<Usuario> usuarios = obtenerUsuario(sql);
        if (usuarios.isEmpty()) {
            return null;
        }
        return usuarios.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }

    public ArrayList<Usuario> obtenerUsaarios() throws SQLException {
        String sql = "SELECT * FROM usuario";
        return obtenerUsuario(sql);
    }

    public ArrayList<Usuario> obtenerUsuario(String sql) throws SQLException {
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            PreparedStatement sentencia = getConnection().prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()) {
                String nombreStr = resultado.getString("Name");
                String contraseniaStr = resultado.getString("Password");
                Usuario usuarioModel = new Usuario(nombreStr, contraseniaStr);
                usuarios.add(usuarioModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            
            cerrar();
        }
        return usuarios;
    }

    public boolean crearUsuario(Usuario usuario) throws SQLException{
        if (usuario == null) {
            return false;
        }
        String query = "INSERT INTO usuario(Name, Password) VALUES (?, ?)";

        try {
            PreparedStatement pStatement = conectar().prepareStatement(query);
            pStatement.setString(1, usuario.getNombre());
            pStatement.setString(2, usuario.getContrasenia());
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

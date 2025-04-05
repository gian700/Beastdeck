package giancarlo.beastdeck.controller;

import java.sql.SQLException;

import giancarlo.beastdeck.config.ConfigManager;
import giancarlo.beastdeck.controller.abstracta.AbstractController;
import giancarlo.beastdeck.model.clases.Usuario;
import giancarlo.beastdeck.model.database.UsuarioManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoginController extends AbstractController {

    
    @FXML
    private TextField textFieldUsuario;
    
    @FXML
    private PasswordField textFieldPassword;

    @FXML
    private Text textFieldMensaje;

    @FXML
    private Button openRegistrar;

    @FXML
    private Button volverBoton;

    @FXML
    private Button aceptarBoton;

    @FXML
    private Text textUsuario;

    @FXML
    private Text textContrasenia;

    @FXML
    public void initialize() {
        if (ConfigManager.ConfigProperties.getProperty("volver") == null) {return;}
        openRegistrar.setText(ConfigManager.ConfigProperties.getProperty("crearCuenta"));
        volverBoton.setText(ConfigManager.ConfigProperties.getProperty("volver"));
        aceptarBoton.setText(ConfigManager.ConfigProperties.getProperty("aceptar"));
        textUsuario.setText(ConfigManager.ConfigProperties.getProperty("usuario"));
        textContrasenia.setText(ConfigManager.ConfigProperties.getProperty("contrasenia"));
    }

    @FXML
    protected void onLoginButtonClick() throws SQLException {
        
        if (textFieldUsuario== null || textFieldUsuario.getText().isEmpty() || 
            textFieldPassword == null || textFieldPassword.getText().isEmpty() ) {
                textFieldMensaje.setText("Credenciales nulas o vacias");
                if (ConfigManager.ConfigProperties.getProperty("volver") != null) {
                    textFieldMensaje.setText(ConfigManager.ConfigProperties.getProperty("Vacio"));
                }
                return;
        }
        UsuarioManager usuarioManager = new UsuarioManager();
        Usuario usuario = usuarioManager.obtenerUsuarioPorNombre(textFieldUsuario.getText());
        
        if (usuario == null) {
            textFieldMensaje.setText("El usuario no existe");
            if (ConfigManager.ConfigProperties.getProperty("volver") != null) {
                textFieldMensaje.setText(ConfigManager.ConfigProperties.getProperty("noExistente"));
            }
            return;
        }

        if (
            !textFieldPassword.getText().equals(usuario.getContrasenia())) {
            textFieldMensaje.setText("Credenciales invalidas");
            if (ConfigManager.ConfigProperties.getProperty("volver") != null) {
                textFieldMensaje.setText(ConfigManager.ConfigProperties.getProperty("credencialesInvalidas"));
            }
            return;
        } 

        textFieldMensaje.setText("Usuario validado correctamente");
        if (ConfigManager.ConfigProperties.getProperty("volver") != null) {
            textFieldMensaje.setText(ConfigManager.ConfigProperties.getProperty("credencialesValidas"));
        }
        usuario = new Usuario(textFieldUsuario.getText(), textFieldPassword.getText());
        ConfigManager.ConfigProperties.setUsuario(usuario);
        cambiarPagina(volverBoton, "inicio");
    }

    @FXML
    public void volverClick(){
        cambiarPagina(volverBoton, "inicio");
    }
    
    @FXML
    public void openRegistrarClick(){
        cambiarPagina(openRegistrar, "registro");
    }

}
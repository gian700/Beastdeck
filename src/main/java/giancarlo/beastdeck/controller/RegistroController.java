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

public class RegistroController extends AbstractController {
    
    @FXML 
    private TextField textFiledUsuario;

    @FXML 
    private Text textMensaje;

    @FXML 
    private Button buttonRegistrar;

    @FXML 
    private PasswordField textFieldPassword;

    @FXML
    private PasswordField textFieldPasswordRepit;

    @FXML
    private Text textUsuario;

    @FXML
    private Text textContrasenia;

    @FXML
    private Text textContrasenia2;

    @FXML
    private Button volver;

    @FXML
    public void initialize() {        
        textUsuario.setText(ConfigManager.ConfigProperties.getProperty("usuario"));
        textContrasenia.setText(ConfigManager.ConfigProperties.getProperty("contrasenia"));
        textContrasenia2.setText(ConfigManager.ConfigProperties.getProperty("contrasenia2"));
        buttonRegistrar.setText(ConfigManager.ConfigProperties.getProperty("registrar"));
        volver.setText(ConfigManager.ConfigProperties.getProperty("volver"));
    }

    @FXML
    protected void registrarClick() throws SQLException, InterruptedException  {

        if (textFieldPassword == null ||  textFieldPassword.getText().isEmpty() 
            || textFieldPasswordRepit == null || textFieldPasswordRepit.getText().isEmpty()) {

            textMensaje.setText(ConfigManager.ConfigProperties.getProperty("Vacio"));
            return;
        }

        if (!(textFieldPassword.getText().equals(textFieldPasswordRepit.getText()))) {
            textMensaje.setText(ConfigManager.ConfigProperties.getProperty("contraseniaOtraVez"));
            return;       
        }
        UsuarioManager usuarioManager = new UsuarioManager();
        Usuario usuario = usuarioManager.obtenerUsuarioPorNombre(textFiledUsuario.getText());

        if (usuario!=null) {
            textMensaje.setText(ConfigManager.ConfigProperties.getProperty("usuarioExistente"));
            return;
        }

        usuario = new Usuario(textFiledUsuario.getText(), textFieldPassword.getText());
        boolean comprobar = usuarioManager.crearUsuario(usuario);

        if (!comprobar) {
            textMensaje.setText(ConfigManager.ConfigProperties.getProperty("errorDB"));
            return;
        }

        textMensaje.setText(ConfigManager.ConfigProperties.getProperty("usuarioCreado"));
        
        ConfigManager.ConfigProperties.setUsuario(usuario);
        cambiarPagina(volver, "inicio");
    }

    public void volverClick(){
        cambiarPagina(volver, "login");
    }
}

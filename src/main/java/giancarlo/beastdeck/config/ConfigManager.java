package giancarlo.beastdeck.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import giancarlo.beastdeck.model.clases.Jugador;
import giancarlo.beastdeck.model.clases.Rival;
import giancarlo.beastdeck.model.clases.Usuario;
/**
 * @author Giancarlo
 * @version 1.0.0
 */
public class ConfigManager {
    /**
     * Clase estatica que maneja el idioma y guarda el usuario activo
     */
    public static class ConfigProperties {
        static String path = "src/main/resources/idiomas/Español.properties";
        static private Usuario usuario = null;
        private static final Properties properties = new Properties();

        /**
         * Metodo estatico para obtener una propiedad
         **/
        public static String getProperty(String key) {
            return properties.getProperty(key);
        }

        /**
         * Metodo estatico para obtener el usuario activo
         **/
        public static Usuario getUsuario() {
            return usuario;
        }        

        /**
         * Metodo estatico para cambiar el usuario activo
         **/
        public static void setUsuario(Usuario usuario){
            ConfigProperties.usuario = usuario;
        }

        /**
         * Metodo estatico para cambiar la ruta de propiedades
         **/
        public static void setPath(String rutaPath) {
            File file = new File(rutaPath);

            if (!file.exists() || !file.isFile()) {
                System.out.println("Path:"+file.getAbsolutePath());
            }
            path = rutaPath;
            try {
                FileInputStream input = new FileInputStream(path);
                InputStreamReader isr = new InputStreamReader(input, "UTF-8");
                properties.load(isr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public static String getPath() {
            return path;
        }


    }

    public static class ConfigObjects {
        
        static private Jugador jugador;
        static private Rival rival;

        public static  Jugador getJugador(){
            return jugador;
        }

        public static Rival getRival(){
            return rival;
        }

        public static void setRival(Rival rival){
            ConfigObjects.rival = rival; 
        }

        public static void setJugador(Jugador jugador){
            ConfigObjects.jugador = jugador;
        }
    }
}

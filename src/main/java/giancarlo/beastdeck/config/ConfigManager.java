package giancarlo.beastdeck.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import giancarlo.beastdeck.model.clases.Usuario;

public class ConfigManager {
    
    public static class ConfigProperties {

        static String path;
        static private Usuario usuario = null;
        private static final Properties properties = new Properties();


        /**
         * Metodo estatico para obtener una propiedad
         **/
        public static String getProperty(String key) {
            return properties.getProperty(key);
        }

        public static Usuario getUsuario() {
            return usuario;
        }        

        public static void setUsuario(Usuario usuario){
            ConfigProperties.usuario = usuario;
        }

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

        
    }
}

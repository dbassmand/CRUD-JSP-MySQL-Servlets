package clases;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexionDAO {
    
    // Variables estáticas para las credenciales
    private static String host;
    private static String user;
    private static String password;

    // Ruta absoluta del archivo credenciales.properties
    private static final String CREDENCIALES_PATH = "C:\\Users\\Daniel\\eclipse-workspace\\GestorWebBBDD_2\\src\\main\\java\\clases\\credenciales.properties";
    
    static {
        cargarCredenciales();
    }

    private static void cargarCredenciales() {
        Properties prop = new Properties();
        var path = Paths.get(CREDENCIALES_PATH);
        try (var in = Files.newInputStream(path)) {
            prop.load(in);
            
            host = prop.getProperty("database.host");
            user = prop.getProperty("database.username");
            password = prop.getProperty("database.pass");
            
            System.out.println("Archivo de credenciales cargado correctamente.");

            if (host == null || user == null || password == null) {
                throw new RuntimeException("Faltan algunas propiedades en el archivo de credenciales.");
            }
        } catch (IOException e) {
            System.out.println("Error al cargar las credenciales desde: " + path.toString());
            e.printStackTrace();
            throw new RuntimeException("No se pueden cargar las credenciales.", e);
        }
    }

    public static Connection obtenerConexion() throws SQLException {
        if (host == null || user == null || password == null) {
            throw new IllegalStateException("Las credenciales no están cargadas correctamente.");
        }
        return DriverManager.getConnection(host, user, password);
    }

    public static void cerrarConexion(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Conexión cerrada con éxito.");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.toString());
                e.printStackTrace();
            }
        }
    }
}











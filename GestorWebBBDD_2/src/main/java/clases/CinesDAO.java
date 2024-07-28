package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CinesDAO {

    public void insertaCine(String nombreCine, String direccion) {
        try (Connection conn = ConexionDAO.obtenerConexion()) {
            if (conn == null) {
                System.out.println("La conexión a la base de datos es nula.");
                return;
            }
            
            String sql = "INSERT INTO Cines (nombreCine, direccion) VALUES (?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, nombreCine);
                stmt.setString(2, direccion);

                int filasInsertadas = stmt.executeUpdate();

                if (filasInsertadas > 0) {
                    System.out.println("Cine insertado correctamente.");
                } else {
                    System.out.println("No se pudo insertar el cine.");
                }
            } catch (SQLException e) {
                System.out.println("Error al preparar la consulta SQL: " + e.toString());
                e.printStackTrace();
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la conexión: " + e.toString());
            e.printStackTrace();
        }
    }

    public List<EntidadCine> obtenerCines() {
        List<EntidadCine> cines = new ArrayList<>();
        
        String sql = "SELECT * FROM cines";
        
        try (Connection conn = ConexionDAO.obtenerConexion();
   	         PreparedStatement stmt = conn.prepareStatement(sql);
   	         ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                EntidadCine cine = new EntidadCine();
                cine.setIdentificador(rs.getInt("identificador"));
                cine.setNombreCine(rs.getString("nombreCine"));
                cine.setDireccion(rs.getString("direccion"));
                cines.add(cine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return cines;
    }
    
  //Metodo para actualizar datos de un cine ya existente en la BBDD.
    public void modificarCine(int identificador, String nombreCine, String direccion) {
    	
    	//Try with resources para no utilizar .close()
    	try (Connection conn = ConexionDAO.obtenerConexion()) {
            if (conn == null) {
                System.out.println("La conexión a la base de datos es nula.");
                return;
            }   	
	        String sql = "UPDATE Cines SET nombreCine = ?, direccion = ? WHERE identificador = ?";
	        try (PreparedStatement statement = conn.prepareStatement(sql)) {
	            statement.setString(1, nombreCine);
	            statement.setString(2, direccion);
	            statement.setInt(3, identificador);
	            int filasafectadas = statement.executeUpdate();
	            if (filasafectadas > 0) {
	                System.out.println("Cine actualizado correctamente.");
	            } else {
	                System.out.println("No se encontró ningún cine con el ID proporcionado.");
	            }
	        } catch (SQLException e) {
	        	System.out.println("Error al actualizar cine");
	            e.printStackTrace();
	        }
    	}catch (SQLException e) {
            System.out.println("Error al obtener la conexión: " + e.toString());
            e.printStackTrace();
        }     	
    }
    
  //Metodo para eliminar datos de un cine ya existente en la BBDD.
	public void eliminarCine(int identificador) {
	    	
	    	//Try with resources para no utilizar .close()
	    	try (Connection conn = ConexionDAO.obtenerConexion()) {
	            if (conn == null) {
	                System.out.println("La conexión a la base de datos es nula.");
	                return;
	            }   	
		        String sql = "DELETE FROM Cines WHERE identificador = ?";
		        try (PreparedStatement statement = conn.prepareStatement(sql)) {
		            statement.setInt(1, identificador);
		            int filasafectadas = statement.executeUpdate();
		            if (filasafectadas > 0) {
		                System.out.println("Cine eliminado correctamente.");
		            } else {
		                System.out.println("No se encontró ningún cine con el ID proporcionado.");
		            }
		        } catch (SQLException e) {
		        	System.out.println("Error al actualizar cine");
		            e.printStackTrace();
		        }
	    	}catch (SQLException e) {
	            System.out.println("Error al obtener la conexión: " + e.toString());
	            e.printStackTrace();
	        }     	
	    }
	    
	    
	    
	}







package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PelisDAO {
	
	public void insertaPeli(String titulo,String duracionMinutos,String genero, String director, String clasificacionEdad, String precio) {
        try (Connection conn = ConexionDAO.obtenerConexion()) {
            if (conn == null) {
                System.out.println("La conexión a la base de datos es nula.");
                return;
            }

            String sql = "INSERT INTO peliculas (titulo, duracionMinutos,genero,director,clasificacionEdad,precio) VALUES (?,?,?,?,?,?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, titulo);
                stmt.setString(2, duracionMinutos);
                stmt.setString(3, genero);
                stmt.setString(4, director);
                stmt.setString(5, clasificacionEdad);
                stmt.setString(6, precio);

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
	
	//Metodo para obtener y listar las peliculas, se almacenan en un Array dinámico
	
	public List<EntidadPelis> obtenerPelis() {
        List<EntidadPelis> pelis = new ArrayList<>();
       
        String sql = "SELECT * FROM peliculas";
                
        try (Connection conn = ConexionDAO.obtenerConexion();
   	         PreparedStatement stmt = conn.prepareStatement(sql);
   	         ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                EntidadPelis peli = new EntidadPelis();
                
                peli.setIdentificador(rs.getInt("identificador"));
                peli.setTitulo(rs.getString("titulo"));
                peli.setDuracionMinutos(rs.getString("duracionMinutos"));
                peli.setGenero(rs.getString("genero"));
                peli.setDirector(rs.getString("director"));
                peli.setClasificacionEdad(rs.getString("clasificacionEdad"));
                peli.setPrecio(rs.getString("precio"));
                pelis.add(peli);
            }
        } catch (Exception e) {
        	System.out.println("Algo ha pasado.....");
            e.printStackTrace();
        }
        return pelis;
    }
	
	//Metodo para actualizar datos de una peli ya existente en la BBDD.
    public void modificarPeli(int identificador, String titulo,String duracionMinutos,String genero, String director, String clasificacionEdad, String precio) {
    	
    	//Try with resources para no utilizar .close()
    	try (Connection conn = ConexionDAO.obtenerConexion()) {
            if (conn == null) {
                System.out.println("La conexión a la base de datos es nula.");
                return;
            }   	
	        String sql = "UPDATE peliculas SET titulo = ?, duracionMinutos = ?, genero = ?, director = ?, clasificacionEdad = ?, precio = ? WHERE identificador = ?";
	        try (PreparedStatement statement = conn.prepareStatement(sql)) {
	            statement.setString(1, titulo);
	            statement.setString(2, duracionMinutos);
	            statement.setString(3, genero);
	            statement.setString(4, director);
	            statement.setString(5, clasificacionEdad);
	            statement.setString(6, precio);
	            statement.setInt(7, identificador);
	            int filasafectadas = statement.executeUpdate();
	            if (filasafectadas > 0) {
	                System.out.println("Pelicula actualizado correctamente.");
	            } else {
	                System.out.println("No se encontró ninguna pelicula con el ID proporcionado.");
	            }
	        } catch (SQLException e) {
	        	System.out.println("Error al actualizar pelicula");
	            e.printStackTrace();
	        }
    	}catch (SQLException e) {
            System.out.println("Error al obtener la conexión: " + e.toString());
            e.printStackTrace();
        }     	
    }
	
  //Metodo para eliminar datos de una pelicula ya existente en la BBDD.
  	public void eliminarPeli(int identificador) {
  	    	
  	    	//Try with resources para no utilizar .close()
  	    	try (Connection conn = ConexionDAO.obtenerConexion()) {
  	            if (conn == null) {
  	                System.out.println("La conexión a la base de datos es nula.");
  	                return;
  	            }   	
  		        String sql = "DELETE FROM peliculas WHERE identificador = ?";
  		        try (PreparedStatement statement = conn.prepareStatement(sql)) {
  		            statement.setInt(1, identificador);
  		            int rowsAffected = statement.executeUpdate();
  		            if (rowsAffected > 0) {
  		                System.out.println("Pelicula eliminada correctamente.");
  		            } else {
  		                System.out.println("No se encontró ninguna pelicula con el ID proporcionado.");
  		            }
  		        } catch (SQLException e) {
  		        	System.out.println("Error al borrar pelicula");
  		            e.printStackTrace();
  		        }
  	    	}catch (SQLException e) {
  	            System.out.println("Error al obtener la conexión: " + e.toString());
  	            e.printStackTrace();
  	        }     	
  	    }  	      	  	    
  	}



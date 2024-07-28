package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalasDAO {
	
	public void insertaSala (int capacidad, String metrosCuadrados) {
		try (Connection conn = ConexionDAO.obtenerConexion()){
			if (conn == null) {
				System.out.println("La conexión a la base de datos es nula.");
				return;
			}
			
			String sql ="INSERT INTO Salas (capacidad, metrosCuadrados) VALUES (?,?)";
			try (PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setInt(1, capacidad);
				stmt.setString(2, metrosCuadrados);
				
				int filasInsertadas = stmt.executeUpdate();
				
				if(filasInsertadas > 0) {
					System.out.println("Sala insertada correctamente");
				}else {
					System.out.println("No se ha podido insertar Sala");
				}
				
			} catch (SQLException e) {
				System.out.println("Error al preparar la consulta SQL:" + e.toString());
				e.printStackTrace();
			}
			
		} catch (SQLException e) {
			System.out.println("Error al obtener la conexión: "+ e.toString());
			e.printStackTrace();
		}
		
	}
	
	public List<EntidadSala> obtenerSalas() {
	    List<EntidadSala> salas = new ArrayList<>();

	    String sql = "SELECT * FROM salas";

	    try (Connection conn = ConexionDAO.obtenerConexion();
	         PreparedStatement stmt = conn.prepareStatement(sql);
	         ResultSet rs = stmt.executeQuery()) {

	        while (rs.next()) {
	            EntidadSala sala = new EntidadSala();
	            sala.setIdentificador(rs.getInt("identificador"));
	            sala.setCapacidad(rs.getInt("capacidad"));
	            sala.setMetrosCuadrado(rs.getString("metrosCuadrados"));  // Corregido: Cambiado de String a int
	            salas.add(sala); // Añade el objeto sala creado a la lista salas
	        }

	    } catch (Exception e) {
	        System.out.println("Algo ha pasado.....");
	        e.printStackTrace();
	    }

	    return salas;
	}

	
	/*
	public List<EntidadSala> obtenerSalas(){
		List<EntidadSala> salas = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = ConexionDAO.obtenerConexion();
			String sql = "SELECT * FROM salas";
			stmt= conn.prepareStatement(sql);
			rs= stmt.executeQuery();
			
			while (rs.next()) {
				EntidadSala sala = new EntidadSala();
				sala.setIdentificador(rs.getInt("identificador"));
				sala.setCapacidad(rs.getInt("capacidad"));
				sala.setMetrosCuadrado(rs.getString("metrosCuadrados"));
				salas.add(sala);//añade el objeto sala creado a la lista salas
			}
			
		} catch (Exception e) {
			System.out.println("Algo ha pasao.....");
			e.printStackTrace();
		}finally {
			ConexionDAO.cerrarConexion(conn);
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(rs != null) {
					rs.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}		
		return salas;
	}
	*/
	
	public void modificarSala(int identificador, int capacidad, String metrosCuadrados) {
		
		try (Connection conn = ConexionDAO.obtenerConexion()){
			if (conn == null) {
				System.out.println("Conexion a BBDD nula!");
				return;
			}
			String sql ="UPDATE salas SET capacidad = ?, metrosCuadrados = ? WHERE identificador = ?";
			try (PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setInt(1, capacidad);
				stmt.setString(2, metrosCuadrados);
				stmt.setInt(3, identificador); 
				int filasafectadas = stmt.executeUpdate();
				if (filasafectadas >0) {
					System.out.println("Sala modificada correctamente");
				}else {
					System.out.println("No se encontró ninguna sala con ese ID");
				}
			}catch(SQLException e) {
				System.out.println("Error al actualizar Sala");
				e.printStackTrace();
			}								
		} catch (SQLException e) {
			System.out.println("Error al obtener la conexion: "+ e.toString());
			e.printStackTrace();
		}	
	}
	
	public void eliminarSala (int identificador) {
		
		try (Connection conn = ConexionDAO.obtenerConexion()){
			if (conn == null) {
				System.out.println("La conexión a BBDD es nula");
				return;
			}
			String sql = "DELETE FROM salas WHERE identificador=?";
			try (PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setInt(1, identificador);
				int filasafectadas = stmt.executeUpdate();
					if(filasafectadas>0) {
						System.out.println("Sala eliminada correctamente");
					}else {
						System.out.println("No se encontró un Sala con ese ID");
					}
			} catch (SQLException e) {
				System.out.println("Error al actualizar Sala");
				e.printStackTrace();
			}						
		} catch (Exception e) {
			System.out.println("Error al obtener conexion: "+ e.toString());
			e.printStackTrace();
		}
	}	
}

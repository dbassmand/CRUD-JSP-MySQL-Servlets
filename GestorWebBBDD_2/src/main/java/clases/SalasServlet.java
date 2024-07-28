package clases;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="SalasServlet", urlPatterns= {"/SalasServlet"})
public class SalasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SalasServlet() {
        super();        
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if("mostrar".equals(action)) {
			mostrarSalas(request, response);
		}else if("guardar".equals(action)) {
			mostrarSalasGuardar(request, response);
		}else if("modificar".equals(action)) {
			mostrarSalasModificar(request, response);
		}else if ("eliminar".equals(action)) {
			mostrarSalasEliminar(request, response);
		}		
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		String action = request.getParameter("action");
		if("guardar".equals(action)) {
			guardarSala(request, response);
		}else if("modificar".equals(action)) {
			modificarSala(request, response);
		}else if ("eliminar".equals(action)) {
			eliminarSala(request, response);
		}
	}

	public void guardarSala(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		int capacidad = Integer.parseInt(request.getParameter("capacidad"));
		String metrosCuadrados= request.getParameter("metrosCuadrados");
		
		SalasDAO salaDAO = new SalasDAO();
		salaDAO.insertaSala(capacidad, metrosCuadrados);
		
		mostrarSalasGuardar(request, response);
	}
	
	
	public void modificarSala (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		int identificador = Integer.parseInt(request.getParameter("identificador")); 
		int capacidad = Integer.parseInt(request.getParameter("capacidad"));
		String metrosCuadrados = request.getParameter("metrosCuadrados");
		
		SalasDAO salaDAO = new SalasDAO();
		salaDAO.modificarSala(identificador, capacidad, metrosCuadrados);
		
		mostrarSalasModificar(request, response);
	}
	
	public void mostrarSalas (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		SalasDAO salaDAO = new SalasDAO();
		List <EntidadSala> salas = salaDAO.obtenerSalas();
		
		if(salas != null) {
			System.out.println("Número de salas obtenidas: "+salas.size());
		}else {
			System.out.println("No hay salas que mostrar");
		}	
		request.setAttribute("listasalas", salas);
		request.getRequestDispatcher("mostrarSalas.jsp").forward(request, response);		
	}
	
	public void eliminarSala(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		int identificador = Integer.parseInt(request.getParameter("identificador"));
		
		SalasDAO salasDAO = new SalasDAO();
		salasDAO.eliminarSala(identificador);
		
		mostrarSalasEliminar(request, response);
	}
	
	public void mostrarSalasGuardar(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		SalasDAO salaDAO = new SalasDAO();
		List<EntidadSala> salas = salaDAO.obtenerSalas();
		
		if(salas != null) {
			System.out.println("Número de salas obtenidas: "+salas.size());
		}else {
			System.out.println("No hay salas que mostrar");
		}		
		request.setAttribute("listasalas", salas);
		request.getRequestDispatcher("guardarSala.jsp").forward(request, response);		
	}
	
	public void mostrarSalasModificar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		SalasDAO salaDAO = new SalasDAO();
		List<EntidadSala> salas = salaDAO.obtenerSalas();
		
		if(salas != null) {
			System.out.println("Número de salas obtenidas: "+salas.size());
		}else {
			System.out.println("No hay salas que mostrar");
		}		
		request.setAttribute("listasalas", salas);
		request.getRequestDispatcher("modificarSala.jsp").forward(request, response);
	}
	
	public void mostrarSalasEliminar(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		SalasDAO salaDAO = new SalasDAO();
		List<EntidadSala> salas = salaDAO.obtenerSalas();
		
		if(salas != null) {
			System.out.println("Número de salas obtenidas: "+salas.size());
		}else {
			System.out.println("No hay salas que mostrar");
		}		
		request.setAttribute("listasalas", salas);
		request.getRequestDispatcher("eliminarSala.jsp").forward(request, response);
	}
}

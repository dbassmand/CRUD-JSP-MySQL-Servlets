package clases;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="CinesServlet", urlPatterns= {"/CinesServlet"})
public class CinesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CinesServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("mostrar".equals(action)) {
            mostrarCines(request, response);
        } 
        /*else {
            response.getWriter().append("Served at: ").append(request.getContextPath());
        }*/
        else if ("guardar".equals(action)) {
            mostrarCinesGuardar(request, response);
        } 
        else if ("modificar".equals(action)) {
        	mostrarCinesModificar(request, response);
        }
        else if ("eliminar".equals(action)) {
        	mostrarCinesEliminar(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //doGet(request, response);
        
        String action = request.getParameter("action");
        if("guardar".equals(action)) {
        	guardarCine(request, response);
        }
        else if("modificar".equals(action)) {
        	modificarCine(request, response);
        }
        else if("eliminar".equals(action)) {
        	eliminarCine(request, response);
        }    
    }

    public void guardarCine(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String nombre = request.getParameter("nombre");
    	String direccion = request.getParameter("direccion");
    	
    	CinesDAO cineDAO = new CinesDAO();
    	cineDAO.insertaCine(nombre, direccion);
    	
    	//mostrar los datos de pues de guardar para refrescar pagina
    	mostrarCinesGuardar(request, response);
    	
    }

    public void modificarCine(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String nombre = request.getParameter("nombre");
    	String direccion = request.getParameter("direccion");
    	int identificador = Integer.parseInt(request.getParameter("identificador"));
    	
    	CinesDAO cineDAO = new CinesDAO();
    	cineDAO.modificarCine(identificador, nombre, direccion);
    	
    	//mostrar los datos depues de guardar para refrescar pagina
    	mostrarCinesModificar(request, response);
    	
    }
    
    
    public void mostrarCines(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CinesDAO cineDAO = new CinesDAO();
        List<EntidadCine> cines = cineDAO.obtenerCines();

        if (cines != null) {
            System.out.println("Número de cines obtenidos: " + cines.size());
        } else {
            System.out.println("La lista de cines es nula");
        }

        request.setAttribute("listacines", cines);
        request.getRequestDispatcher("mostrarCines.jsp").forward(request, response);
    }
    
    
	public void eliminarCine(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	
	    	
	    	int identificador = Integer.parseInt(request.getParameter("identificador"));
	    	
	    	CinesDAO cineDAO = new CinesDAO();
	    	cineDAO.eliminarCine(identificador);
	    	//mostrar los datos de pues de guardar para refrescar pagina
	    	mostrarCinesEliminar(request, response);
	    	
    }
    
    public void mostrarCinesGuardar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CinesDAO cineDAO = new CinesDAO();
        List<EntidadCine> cines = cineDAO.obtenerCines();

        if (cines != null) {
            System.out.println("Número de cines obtenidos: " + cines.size());
        } else {
            System.out.println("La lista de cines es nula");
        }

        request.setAttribute("listacines", cines);
        request.getRequestDispatcher("guardarCine.jsp").forward(request, response);
    }
    
    public void mostrarCinesModificar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CinesDAO cineDAO = new CinesDAO();
        List<EntidadCine> cines = cineDAO.obtenerCines();

        if (cines != null) {
            System.out.println("Número de cines obtenidos: " + cines.size());
        } else {
            System.out.println("La lista de cines es nula");
        }

        request.setAttribute("listacines", cines);
        request.getRequestDispatcher("modificarCine.jsp").forward(request, response);
               
        
    }
    
    public void mostrarCinesEliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CinesDAO cineDAO = new CinesDAO();
        List<EntidadCine> cines = cineDAO.obtenerCines();

        if (cines != null) {
            System.out.println("Número de cines obtenidos: " + cines.size());
        } else {
            System.out.println("La lista de cines es nula");
        }

        request.setAttribute("listacines", cines);
        request.getRequestDispatcher("eliminarCine.jsp").forward(request, response);
               
        
    }        
}


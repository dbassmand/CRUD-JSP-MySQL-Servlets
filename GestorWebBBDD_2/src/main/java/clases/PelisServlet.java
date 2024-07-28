package clases;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="PelisServlet", urlPatterns= {"/PelisServlet"})

public class PelisServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public PelisServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("mostrar".equals(action)) {
            mostrarPelis(request, response);
        } 
        /*else {
            response.getWriter().append("Served at: ").append(request.getContextPath());
        }*/
        else if ("guardar".equals(action)) {
            mostrarPelisGuardar(request, response);
        } 
        else if ("modificar".equals(action)) {
        	mostrarPelisModificar(request, response);
        }
        else if ("eliminar".equals(action)) {
        	mostrarPelisEliminar(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //doGet(request, response);
        
        String action = request.getParameter("action");
        if("guardar".equals(action)) {
        	guardarPeli(request, response);
        }
        else if("modificar".equals(action)) {
        	modificarPeli(request, response);
        }
        else if("eliminar".equals(action)) {
        	eliminarPeli(request, response);
        }
     
    }

    public void guardarPeli(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String titulo = request.getParameter("titulo");
    	String duracionMinutos = request.getParameter("duracionMinutos");
    	String genero = request.getParameter("genero");
    	String director = request.getParameter("director");
    	String clasificacionEdad = request.getParameter("clasificacionEdad");
    	String precio = request.getParameter("precio");
    
    	
    	PelisDAO peliDAO = new PelisDAO();
    	peliDAO.insertaPeli(titulo, duracionMinutos, genero, director, clasificacionEdad, precio);
	
    	//mostrar los datos de pues de guardar para refrescar pagina
    	mostrarPelisGuardar(request, response);
    	
    }

    public void modificarPeli(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	
    	
    	int identificador = Integer.parseInt(request.getParameter("identificador"));
    	String titulo = request.getParameter("titulo");
    	String duracionMinutos = request.getParameter("duracionMinutos");
    	String genero = request.getParameter("genero");
    	String director = request.getParameter("director");
    	String clasificacionEdad = request.getParameter("clasificacionEdad");
    	String precio = request.getParameter("precio");
    	
    	
    	PelisDAO peliDAO = new PelisDAO();
    	peliDAO.modificarPeli(identificador,titulo, duracionMinutos, genero, director, clasificacionEdad, precio);
    	
    	//mostrar los datos de pues de guardar para refrescar pagina
    	mostrarPelisModificar(request, response);
    	
    }
    
    
    public void mostrarPelis(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PelisDAO pelisDAO = new PelisDAO();
        List<EntidadPelis> pelis = pelisDAO.obtenerPelis();
    	
        if (pelis != null) {
            System.out.println("Número de peliculas obtenidos: " + pelis.size());
        } else {
            System.out.println("La lista de peliculas es nula");
        }

        request.setAttribute("listapelis", pelis);
        request.getRequestDispatcher("mostrarPelis.jsp").forward(request, response);
    }
    
    
	public void eliminarPeli(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	
	    	
	    	int identificador = Integer.parseInt(request.getParameter("identificador"));
	    	
	    	PelisDAO pelisDAO = new PelisDAO();
	    	pelisDAO.eliminarPeli(identificador);
	    		    	
	    	//mostrar los datos de pues de guardar para refrescar pagina
	    	mostrarPelisEliminar(request, response);
	    	
    }
    
    public void mostrarPelisGuardar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	PelisDAO pelisDAO = new PelisDAO();
        List<EntidadPelis> pelis = pelisDAO.obtenerPelis();

        if (pelis != null) {
            System.out.println("Número de peliculas obtenidos: " + pelis.size());
        } else {
            System.out.println("La lista de peliculas es nula");
        }

        request.setAttribute("listapelis", pelis);
        request.getRequestDispatcher("guardarPeli.jsp").forward(request, response);
    }
    
    public void mostrarPelisModificar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	PelisDAO pelisDAO = new PelisDAO();
        List<EntidadPelis> pelis = pelisDAO.obtenerPelis();


        if (pelis != null) {
            System.out.println("Número de peliculas obtenidas: " + pelis.size());
        } else {
            System.out.println("La lista de peliculas es nula");
        }

        request.setAttribute("listapelis", pelis);
        request.getRequestDispatcher("modificarPeli.jsp").forward(request, response);
               
        
    }
    
    public void mostrarPelisEliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	PelisDAO pelisDAO = new PelisDAO();
        List<EntidadPelis> pelis = pelisDAO.obtenerPelis();
        
        if (pelis != null) {
            System.out.println("Número de peliculas obtenidas: " + pelis.size());
        } else {
            System.out.println("La lista de peliculas es nula");
        }

        request.setAttribute("listapelis", pelis);
        request.getRequestDispatcher("eliminarPeli.jsp").forward(request, response);
               
        
    }
    
    
}
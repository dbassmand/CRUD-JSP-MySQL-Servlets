package clases;

public class EntidadPelis {
	
	int identificador;
	String titulo;
	String duracionMinutos;	
	String genero;
	String director;
	String clasificacionEdad;
	String precio;
	
		
	public int getIdentificador() {
		return identificador;
	}
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getDuracionMinutos() {
		return duracionMinutos;
	}
	public void setDuracionMinutos(String duracionMinutos) {
		this.duracionMinutos = duracionMinutos;
	}	
	
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getClasificacionEdad() {
		return clasificacionEdad;
	}
	public void setClasificacionEdad(String clasificacionEdad) {
		this.clasificacionEdad = clasificacionEdad;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	
	

}

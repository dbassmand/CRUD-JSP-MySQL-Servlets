<%@page import="clases.EntidadPelis"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>BBDD Películas</title>
<link rel="stylesheet" href="style.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<title>Eliminar Película</title>
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">Eliminar Película</h1>
        
        <div class="text-center mb-3">
            <a href="index.jsp" class="btn btn-primary">Regresar al Menú</a>
        </div>
        
        <div class="card p-4 mb-5" style="background-color: rgba(255, 255, 255, 0.8); border-radius: 10px;">
            <form action="PelisServlet" method="POST">
                <div class="mb-3">
                    <label for="idid" class="form-label">Identificador</label>
                    <input type="text" class="form-control" id="idid" name="identificador" readonly>
                </div>
                <div class="mb-3">
                    <label for="titulo" class="form-label">Título</label>
                    <input type="text" class="form-control" id="titulo" name="titulo">
                </div>
                <div class="mb-3">
                    <label for="director" class="form-label">Director</label>
                    <input type="text" class="form-control" id="director" name="director">
                </div>
                <div class="mb-3">
                    <label for="genero" class="form-label">Género</label>
                    <input type="text" class="form-control" id="genero" name="genero">
                </div>
                <button type="submit" class="btn btn-danger" name="action" value="eliminar">Eliminar</button>
            </form>
        </div>
        
        <h3 class="text-center bg-light p-3 rounded-3" style="background-color: #e9ecef;">Lista de Películas</h3>

        
        <div class="table-responsive">
            <table class="table table-striped table-bordered">
                <thead class="table-dark">
                    <tr>
                        <th>Identificador</th>
                        <th>Título</th>
                        <th>Director</th>
                        <th>Género</th>
                        <th>Acción</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<EntidadPelis> peliculas = (List<EntidadPelis>) request.getAttribute("listapelis");
                        if (peliculas != null && !peliculas.isEmpty()) {
                            for (EntidadPelis pelicula : peliculas) {
                    %>
                    <tr onclick="Seleccionar(this)">
                        <td><%= pelicula.getIdentificador() %></td>
                        <td><%= pelicula.getTitulo() %></td>
                        <td><%= pelicula.getDirector() %></td>
                        <td><%= pelicula.getGenero() %></td>
                        <td>
                            <button type="button" class="btn btn-danger btn-sm" onclick="Seleccionar(this)">Seleccionar</button>
                        </td>
                    </tr>
                    <%
                            }
                        } else {
                    %>
                    <tr>
                        <td colspan="5">No hay películas disponibles</td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
    </div>

    <script type="text/javascript">
        function Seleccionar(row){
            var cells = row.cells;

            document.getElementById('idid').value = cells[0].innerHTML.trim();
            document.getElementById('titulo').value = cells[1].innerHTML.trim();
            document.getElementById('director').value = cells[2].innerHTML.trim();
            document.getElementById('genero').value = cells[3].innerHTML.trim();
        }
    </script>
</body>
</html>





<!--  


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
    <title>BBDD Pelis</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>

	<h1>Modificar Peliculas</h1>
		<a href="index.jsp">Regresar al Menú</a>
		
			<form action="PelisServlet" method="POST">
				<p><label>Identificador</label><input type="text" name="identificador" id="idid" readonly>				
				<p><label>Titulo</label><input type="text" name="titulo" id="idtitulo">
				<p><label>Duracion min</label><input type="text" name="duracionMinutos" id="idduracionMinutos" readonly>
				<p><label>Género</label><input type="text" name="genero" id="idgenero">
				<p><label>Director</label><input type="text" name="director" id="iddirector">
				<p><label>Clasificación</label><input type="text" name="clasificacionEdad" id="idclasificacionEdad">
				<p><label>Precio</label><input type="text" name="precio" id="idprecio">
				<button type="submit" name="action" value="eliminar">Eliminar</button>
			</form>
			
			<h3>Lista de Peliculas</h3>
			
	<table border="1" id="mitabla">
        <tr>
            <th>Identificador</th>
            <th>Titulo</th>
            <th>Duracion min</th>  
            <th>Genero</th>
            <th>Director</th>
            <th>Clasificación</th>
            <th>Precio</th>              
        </tr>    
        
        <%
            List<EntidadPelis> pelis = (List<EntidadPelis>) request.getAttribute("listapelis");
            if (pelis != null && !pelis.isEmpty()) {
                for (EntidadPelis peli : pelis) {
        %>
        
        <tr>
            <td><%= peli.getIdentificador() %></td>
            <td><%= peli.getTitulo() %></td>
            <td><%= peli.getDuracionMinutos() %></td>
            <td><%= peli.getGenero() %></td>
            <td><%= peli.getDirector() %></td>
            <td><%= peli.getClasificacionEdad() %></td>
            <td><%= peli.getPrecio() %></td>  
            <td>
            	<button type="submit" onClick="Seleccionar()">Seleccionar</button>
            </td>                          
        </tr>
        
        <%
                }
            } else {
        %>
        
        <tr>
            <td colspan="3">No hay peliculas disponibles</td>
        </tr>
        
        <%
            }
        %>
                
    </table>
	

	<script type="text/javascript">
	
		function Seleccionar(){
			
			var table = document.getElementById("mitabla");
			
			for (var i=1; i<table.rows.length;i++){
				table.rows[i].onclick = function(){
					document.getElementById('idid').value= this.cells[0].innerHTML;
					document.getElementById('idtitulo').value= this.cells[1].innerHTML;
					document.getElementById('idduracionMinutos').value= this.cells[2].innerHTML;
					document.getElementById('idgenero').value= this.cells[3].innerHTML;
					document.getElementById('iddirector').value= this.cells[4].innerHTML;
					document.getElementById('idclasificacionEdad').value= this.cells[5].innerHTML;
					document.getElementById('idprecio').value= this.cells[6].innerHTML;
				};
			}			
		}	
	</script>
	</body>
</html>

-->
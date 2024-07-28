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
<title>Guardar Películas</title>
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">Guardar Películas</h1>
        
        <div class="text-center mb-3">
            <a href="index.jsp" class="btn btn-primary">Regresar al Menú</a>
        </div>
        
        <div class="card p-4 mb-5" style="background-color: rgba(255, 255, 255, 0.8); border-radius: 10px;">
            <form action="PelisServlet" method="POST">
                <div class="mb-3">
                    <label for="titulo" class="form-label">Título</label>
                    <input type="text" class="form-control" id="titulo" name="titulo">
                </div>
                <div class="mb-3">
                    <label for="duracionMinutos" class="form-label">Duración Minutos</label>
                    <input type="text" class="form-control" id="duracionMinutos" name="duracionMinutos">
                </div>
                <div class="mb-3">
                    <label for="genero" class="form-label">Género</label>
                    <input type="text" class="form-control" id="genero" name="genero">
                </div>
                <div class="mb-3">
                    <label for="director" class="form-label">Director</label>
                    <input type="text" class="form-control" id="director" name="director">
                </div>  
                <!--         
                <div class="mb-3">
                    <label for="clasificacionEdad" class="form-label">Clasificacion</label>
                    <input type="text" class="form-control" id="clasificacionEdad" name="clasificacionEdad">
                </div>
                -->
                <div class="mb-3">
                    <label for="clasificacion" class="form-label">Clasificación</label>
                    <select class="form-select" id="clasificacion" name="clasificacionEdad">
                        <option value="G">G</option>
                        <option value="PG-13">PG-13</option>
                        <option value="NC-16">NC-16</option>
                        <option value="M18">M18</option>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="precio" class="form-label">Precio</label>
                    <input type="text" class="form-control" id="precio" name="precio">
                </div>        
                <button type="submit" class="btn btn-success" name="action" value="guardar">Guardar</button>
            </form>
        </div>
        
        <h3 class="text-center bg-light p-3 rounded-3" style="background-color: #e9ecef;">Lista de Películas</h3>

        
        <div class="table-responsive">
            <table class="table table-striped table-bordered">
                <thead class="table-dark">
                    <tr>
                        <th>Identificador</th>
                        <th>Título</th>
                        <th>Duracion</th>
                        <th>Género</th>
                        <th>Director</th>
 						<th>Clasificacion</th>
 						<th>Precio</th>                                       
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<EntidadPelis> peliculas = (List<EntidadPelis>) request.getAttribute("listapelis");
                        if (peliculas != null && !peliculas.isEmpty()) {
                            for (EntidadPelis pelicula : peliculas) {
                    %>
                    <tr>
                        <td><%= pelicula.getIdentificador() %></td>
                        <td><%= pelicula.getTitulo() %></td>
                        <td><%= pelicula.getDuracionMinutos() %></td>
                        <td><%= pelicula.getGenero() %></td>
                        <td><%= pelicula.getDirector() %></td>
                        <td><%= pelicula.getClasificacionEdad() %></td>
                        <td><%= pelicula.getPrecio() %></td>
                                                
                    </tr>
                    <%
                            }
                        } else {
                    %>
                    <tr>
                        <td colspan="4">No hay películas disponibles</td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>



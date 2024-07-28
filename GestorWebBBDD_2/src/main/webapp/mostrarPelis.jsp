<%@page import="clases.EntidadPelis"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>BBDD Pelis</title>
<link rel="stylesheet" href="style.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

<title>Tabla de Peliculas</title>
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">Tabla Peliculas</h1><br>
        
        <div class="text-center mb-3">
            <a href="index.jsp" class="btn btn-primary">Regresar al menú</a>
        </div>


        
        <div class="table-responsive">
            <table class="table table-striped table-bordered">
                <thead class="table-dark"><br><br><br><br>
                    <tr>
                        <th>Identificador</th>
                        <th>Título</th>
                        <th>Duración (min)</th>
                        <th>Género</th>
                        <th>Director</th>
                        <th>Clasificación</th>
                        <th>Precio</th>
                    </tr>
                </thead>
                <tbody>
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
                    </tr>
                    <%
                            }
                        } else {
                    %>
                    <tr>
                        <td colspan="7">No hay películas disponibles</td>
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

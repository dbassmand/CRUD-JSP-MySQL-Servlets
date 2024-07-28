<%@page import="clases.EntidadSala"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>BBDD Cines</title>
<link rel="stylesheet" href="style.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

<title>Tabla de Salas</title>
</head>
<body>
<div class="container mt-5">
        <h1 class="text-center">Tabla de cines</h1>
        
        <div class="text-center mb-3">
            <a href="index.jsp" class="btn btn-primary">Regresar al menú</a>
        </div>

        <div class="table-responsive">
            <table class="table table-striped table-bordered">
                <thead class="table-dark"><br><br><br><br>
                    <tr>
                        <th>Identificador</th>
                        <th>Capacidad</th>
                        <th>metrosCuadrados</th>                
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<EntidadSala> salas = (List<EntidadSala>) request.getAttribute("listasalas");
                        if (salas != null && !salas.isEmpty()) {
                            for (EntidadSala sala : salas) {
                    %>
                    <tr>
                        <td><%= sala.getIdentificador() %></td>
                        <td><%= sala.getCapacidad() %></td>
                        <td><%= sala.getMetrosCuadrado() %></td>                        
                    </tr>
                    <%
                            }
                        } else {
                    %>
                    <tr>
                        <td colspan="3">No hay salas disponibles</td>
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
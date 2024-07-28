

<%@page import="clases.EntidadCine"%>
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
<title>Guardar Cines</title>
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">Guardar Cines</h1>
        
        <div class="text-center mb-3">
            <a href="index.jsp" class="btn btn-primary">Regresar al Menú</a>
        </div>
        
        <div class="card p-4 mb-5" style="background-color: rgba(255, 255, 255, 0.8); border-radius: 10px;">
            <form action="CinesServlet" method="POST">
                <div class="mb-3">
                    <label for="nombre" class="form-label">Nombre</label>
                    <input type="text" class="form-control" id="nombre" name="nombre">
                </div>
                <div class="mb-3">
                    <label for="direccion" class="form-label">Dirección</label>
                    <input type="text" class="form-control" id="direccion" name="direccion">
                </div>
                <button type="submit" class="btn btn-success" name="action" value="guardar">Guardar</button>
            </form>
        </div>
        
        <h3 class="text-center bg-light p-3 rounded-3" style="background-color: #e9ecef;">Lista de Cines</h3>
        
        <div class="table-responsive">
            <table class="table table-striped table-bordered">
                <thead class="table-dark">
                    <tr>
                        <th>Identificador</th>
                        <th>Nombre del Cine</th>
                        <th>Dirección</th>                
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<EntidadCine> cines = (List<EntidadCine>) request.getAttribute("listacines");
                        if (cines != null && !cines.isEmpty()) {
                            for (EntidadCine cine : cines) {
                    %>
                    <tr>
                        <td><%= cine.getIdentificador() %></td>
                        <td><%= cine.getNombreCine() %></td>
                        <td><%= cine.getDireccion() %></td>                        
                    </tr>
                    <%
                            }
                        } else {
                    %>
                    <tr>
                        <td colspan="3">No hay cines disponibles</td>
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




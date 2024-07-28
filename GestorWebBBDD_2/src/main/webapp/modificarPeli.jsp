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
<title>Modificar Películas</title>
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">Modificar Películas</h1>
        
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
                    <label for="idtitulo" class="form-label">Título</label>
                    <input type="text" class="form-control" id="idtitulo" name="titulo">
                </div>
                <div class="mb-3">
                    <label for="idduracion" class="form-label">Duración (minutos)</label>
                    <input type="number" class="form-control" id="idduracion" name="duracionMinutos">
                </div>
                <div class="mb-3">
                    <label for="idgenero" class="form-label">Género</label>
                    <input type="text" class="form-control" id="idgenero" name="genero">
                </div>
                <div class="mb-3">
                    <label for="iddirector" class="form-label">Director</label>
                    <input type="text" class="form-control" id="iddirector" name="director">
                </div>
                <div class="mb-3">
                    <label for="idclasificacion" class="form-label">Clasificación</label>
                    <select class="form-select" id="idclasificacion" name="clasificacionEdad">
                        <option value="G">G</option>
                        <option value="PG-13">PG-13</option>
                        <option value="NC-16">NC-16</option>
                        <option value="M18">M18</option>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="idprecio" class="form-label">Precio</label>
                    <input type="number" step="0.01" class="form-control" id="idprecio" name="precio">
                </div>
                <button type="submit" class="btn btn-success" name="action" value="modificar">Modificar</button>
            </form>
        </div>
        
        <h3 class="text-center bg-light p-3 rounded-3" style="background-color: #e9ecef;">Lista de Películas</h3>

        
        <div class="table-responsive">
            <table class="table table-striped table-bordered">
                <thead class="table-dark">
                    <tr>
                        <th>Identificador</th>
                        <th>Título</th>
                        <th>Duración (minutos)</th>
                        <th>Género</th>
                        <th>Director</th>
                        <th>Clasificación</th>
                        <th>Precio</th>
                        <th>Acción</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<EntidadPelis> pelis = (List<EntidadPelis>) request.getAttribute("listapelis");
                        if (pelis != null && !pelis.isEmpty()) {
                            for (EntidadPelis peli : pelis) {
                    %>
                    <tr onclick="Seleccionar(this)">
                        <td><%= peli.getIdentificador() %></td>
                        <td><%= peli.getTitulo() %></td>
                        <td><%= peli.getDuracionMinutos() %></td>
                        <td><%= peli.getGenero() %></td>
                        <td><%= peli.getDirector() %></td>
                        <td><%= peli.getClasificacionEdad() %></td>
                        <td><%= peli.getPrecio() %></td>
                        <td>
                            <button type="button" class="btn btn-primary btn-sm">Seleccionar</button>
                        </td>
                    </tr>
                    <%
                            }
                        } else {
                    %>
                    <tr>
                        <td colspan="8">No hay películas disponibles</td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
    </div>

    <script type="text/javascript">
        // Función para seleccionar una fila y mostrar los datos en el formulario
        function Seleccionar(row){
            var cells = row.cells;

            document.getElementById('idid').value = cells[0].innerHTML.trim();
            document.getElementById('idtitulo').value = cells[1].innerHTML.trim();
            document.getElementById('idduracion').value = cells[2].innerHTML.trim();
            document.getElementById('idgenero').value = cells[3].innerHTML.trim();
            document.getElementById('iddirector').value = cells[4].innerHTML.trim();
            document.getElementById('idclasificacion').value = cells[5].innerHTML.trim();
            document.getElementById('idprecio').value = cells[6].innerHTML.trim();
        }

        // Añadir evento click a los botones "Seleccionar" dentro de la tabla
        document.addEventListener('DOMContentLoaded', function() {
            var buttons = document.querySelectorAll('button.btn-primary');
            buttons.forEach(function(button) {
                button.addEventListener('click', function() {
                    var row = this.parentNode.parentNode;
                    Seleccionar(row);
                });
            });
        });
    </script>
</body>
</html>


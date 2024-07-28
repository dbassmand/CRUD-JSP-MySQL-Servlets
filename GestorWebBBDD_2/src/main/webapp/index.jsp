<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Conexion BBDD - Servlet</title>
<link rel="stylesheet" href="style.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<br><br><br>
    <div class="container">
        <div class="bg-light card mt-5 p-4 bg-translucent">
            <h1 class="bg-light display-4 text-center">CRUD JSP + MySQL</h1>
            <h2 class="bg-light text-center">Menú Principal</h2>
            <div class="bg-light text-center botones-contenedor mt-4">
            	<h4>Cines</h4>
                <form id="menuFormCines" action="CinesServlet" method="GET" class="d-grid gap-2">
                    <button type="submit" name="action" value="mostrar" class="btn btn-primary btn-block">Mostrar Cines</button>
                    <button type="submit" name="action" value="guardar" class="btn btn-secondary btn-block">Guardar Cine</button>
                    <button type="submit" name="action" value="modificar" class="btn btn-secondary btn-block">Modificar Cine</button>
                    <button type="submit" name="action" value="eliminar" class="btn btn-secondary btn-block">Eliminar Cine</button>
                </form>
                <br>
                <h4>Peliculas</h4>
                <form id="menuFormPelis" action="PelisServlet" method="GET" class="d-grid gap-2 mt-3">
                    <button type="submit" name="action" value="mostrar" class="btn btn-primary btn-block">Mostrar Película</button>
                    <button type="submit" name="action" value="guardar" class="btn btn-secondary btn-block">Guardar Película</button>
                    <button type="submit" name="action" value="modificar" class="btn btn-secondary btn-block">Modificar Película</button>
                    <button type="submit" name="action" value="eliminar" class="btn btn-secondary btn-block">Eliminar Película</button>
                </form>
                <br>
                <h4>Salas</h4>
                <form id="menuFormSalas" action="SalasServlet" method="GET" class="d-grid gap-2 mt-3">
                    <button type="submit" name="action" value="mostrar" class="btn btn-primary btn-block">Mostrar Sala</button>
                    <button type="submit" name="action" value="guardar" class="btn btn-secondary btn-block">Guardar Sala</button>
                    <button type="submit" name="action" value="modificar" class="btn btn-secondary btn-block">Modificar Sala</button>
                    <button type="submit" name="action" value="eliminar" class="btn btn-secondary btn-block">Eliminar Sala</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>


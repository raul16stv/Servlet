<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,ExamenRaul.ServletDDI.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado de usuario</title>
</head>
<body>
	<form action="cargarListadoGames" method="post">
		<input type="submit" value="ver listado">
	</form>

	<table border="1">
		<thead>
			<tr>
				<td>Titulo</td>
				<td>Fecha Recomendada</td>
				<td>Fecha Lanzamiento</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="videojuegos" items="${videojuegos}">
				<tr>
					<td><c:out value="${videojuegos.Titulo}" /></td>
					<td><c:out value="${videojuegos.FechaRecomendada}" /></td>
					<td><c:out value="${videojuegos.fechaLanzamiento}" /></td>
					<td><a href="/delete?Titulo=${videojuegos.Titulo}">Borrar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<select>
		<c:forEach var="videojuegos" items="${videojuegos}">
			<option value="${videojuegos.Titulo}">${videojuegos.Titulo}</option>
		</c:forEach>
	</select>

</body>
</html>
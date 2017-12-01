package Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import Conexion.ConnectionManager;
import ExamenRaul.ServletDDI.Consola;
import ExamenRaul.ServletDDI.Empresa;
import ExamenRaul.ServletDDI.Videojuego;


public class ConsolaRepository extends AbstractConnection implements ConnectionManager {
	AbstractConnection connection;
	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'";

	public void insert(Consola consolaFormulario) {
		Connection conn = open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO CONSOLA (nombre,EmpresaID)" + "VALUES (?, ?)");
			preparedStatement.setString(1, consolaFormulario.getNombre());
			preparedStatement.setString(2, consolaFormulario.getEmpresa());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
		}

		close(conn);
	}

	public void insert(Videojuego videojuego) {
		Connection conn = open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO VIDEOJUEGOS (Titulo,EdadRecomendada, fechaLanzamiento)" + "VALUES (?, ?, ?)");
			preparedStatement.setString(1, videojuego.getTitulo());
			preparedStatement.setString(2, videojuego.getEdadRecomendada());
			preparedStatement.setTimestamp(3, videojuego.getFechaLanzamiento());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
		}

		close(conn);
	}
	
	public List<Consola> listAllConsola() {
		List<Consola> consolas = new ArrayList<Consola>();
		Connection conn = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			conn = connection.open(jdbcUrl);
			statement = conn.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM Consola");

			while (resultSet.next()) {
				Consola consola = new Consola();
				consola.setNombre(resultSet.getString("nombre"));
				consola.setEmpresa(resultSet.getString("EmpresaID"));
				consolas.add(consola);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.close(resultSet);
			connection.close(statement);
			connection.close(conn);
		}

		return consolas;
	}
	public List<Videojuego> listAllGames() {
		List<Videojuego> videojuegos = new ArrayList<Videojuego>();
		Connection conn = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			conn = connection.open(jdbcUrl);
			statement = conn.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM Videojuegos");

			while (resultSet.next()) {
				Videojuego videojuego = new Videojuego();
				videojuego.setTitulo(resultSet.getString("Titulo"));
				videojuego.setFechaLanzamiento(resultSet.getTimestamp("fechaLanzamiento"));
				videojuego.setEdadRecomendada(resultSet.getString("EdadRecomendada"));

				videojuegos.add(videojuego);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.close(resultSet);
			connection.close(statement);
			connection.close(conn);
		}

		return videojuegos;
	}

	public void insert(Empresa empresa) {
		// TODO Auto-generated method stub
		
	}
}

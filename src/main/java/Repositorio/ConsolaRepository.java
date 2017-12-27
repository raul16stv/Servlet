package Repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Conexion.ConnectionH2;
import Conexion.ConnectionManager;
import Modelo.Consola;
import Modelo.Empresa;
import Modelo.Videojuego;




public class ConsolaRepository{
	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test";
	ConnectionManager manager = new ConnectionH2();
	public void insert(Consola consolaFormulario) {
		Connection conn = manager.open(jdbcUrl);
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

		manager.close(conn);
	}
	/*public void delete(Videojuego videojuego) {
		Connection conn = connection.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("DELETE * FROM Videjuegos WHERE Titulo=?");
			preparedStatement.setString(1, videojuego.getTitulo());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.close(preparedStatement);
		}

		connection.close(conn);
	}
*/
	public void insert(Videojuego videojuego) {
		Connection conn = manager.open(jdbcUrl);
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

		manager.close(conn);
	}

	private void close(PreparedStatement prepareStatement) {
		try {
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	private void close(ResultSet resultSet) {
		try {
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
			}
		}
	
	public List<Consola> listAllConsola() {
		List<Consola> consolas = new ArrayList<Consola>();
		Connection conn= manager.open(jdbcUrl);
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			
			statement = conn.prepareStatement("SELECT * FROM Consola");
			resultSet = statement.executeQuery();

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
			close(resultSet);
			close(statement);
		
		}

		return consolas;
	}
	public List<Videojuego> listAllGames() {
		List<Videojuego> videojuegos = new ArrayList<Videojuego>();
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			statement = conn.prepareStatement("SELECT * FROM Videojuegos");
			resultSet = statement.executeQuery();

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
			close(resultSet);
			close(statement);
		}

		return videojuegos;
	}

	public void insert(Empresa empresa) {
		// TODO Auto-generated method stub
		
	}
}

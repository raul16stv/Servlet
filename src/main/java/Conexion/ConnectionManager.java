
package Conexion;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

import ExamenRaul.ServletDDI.Consola;
import ExamenRaul.ServletDDI.Empresa;
import ExamenRaul.ServletDDI.Videojuego;


public interface ConnectionManager {
	
	public Connection open(String jdbcUrl);
	
	public void close(Connection conn);

	void insert(Consola consola);
	void insert(Videojuego videojuego);
	void insert(Empresa empresa);

	
}


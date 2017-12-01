package ExamenRaul.ServletDDI;

import java.sql.Date;
import java.sql.Timestamp;

public class Videojuego {
	String Titulo;	
	String EdadRecomendada;
	Timestamp FechaLanzamiento;
	public String getTitulo() {
		return Titulo;
	}
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	public String getEdadRecomendada() {
		return EdadRecomendada;
	}
	public void setEdadRecomendada(String edadRecomendada) {
		EdadRecomendada = edadRecomendada;
	}
	public Timestamp getFechaLanzamiento() {
		return FechaLanzamiento;
	}
	public void setFechaLanzamiento(Timestamp fechaLanzamiento) {
		FechaLanzamiento = fechaLanzamiento;
	}

}

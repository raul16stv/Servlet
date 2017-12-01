create table IF NOT EXISTS CONSOLA(
	ID INT AUTO_INCREMENT PRIMARY KEY,
	nombre String,
	EmpresaID String
);
create table IF NOT EXISTS EMPRESAS{
	ID INT AUTO_INCREMENT PRIMARY KEY,
	nombre string,
	fechaCreacion DATE
}
create table IF NOT EXISTS VIDEOJUEGOS{
	ID INT AUTO_INCREMENT PRIMARY KEY, 
	Titulo string,
	EdadRecomendada string,
	fechaLanzamiento DATE
}
INSERT INTO VIDEOJUEGOS(EdadRecomendada) VALUES("TP")
INSERT INTO VIDEOJUEGOS(EdadRecomendada) VALUES("+7")
INSERT INTO VIDEOJUEGOS(EdadRecomendada) VALUES("+13")
INSERT INTO VIDEOJUEGOS(EdadRecomendada) VALUES("+18") 
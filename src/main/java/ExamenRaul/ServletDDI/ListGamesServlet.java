package ExamenRaul.ServletDDI;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Conexion.ConsolaRepository;
import es.salesianos.model.User;
import es.salesianos.repository.UserRepository;

public class ListGamesServlet extends HttpServlet {

	ConsolaRepository consolaRepo = new ConsolaRepository();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Videojuego> listAllGames = userReposirory.listAllUsers();
		req.getSession().setAttribute("users", listAllUsers);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listado.jsp");
		dispatcher.forward(req, resp);
	}
}

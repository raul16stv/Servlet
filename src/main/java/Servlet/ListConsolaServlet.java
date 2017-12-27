package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.Consola;
import Repositorio.ConsolaRepository;


public class ListConsolaServlet extends HttpServlet {

	ConsolaRepository consolaRepo = new ConsolaRepository();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Consola> listAllConsola = consolaRepo.listAllConsola();
		req.getSession().setAttribute("consola", listAllConsola);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListadoConsola.jsp");
		dispatcher.forward(req, resp);
	}
}

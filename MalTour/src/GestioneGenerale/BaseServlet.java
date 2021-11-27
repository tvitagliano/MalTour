package GestioneGenerale;

import java.io.IOException;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import GestioneOfferte.MyServletException;
import GestioneServizi.Servizio;
import GestioneServizi.ServizioDAO;
import GestioneUtente.Utente;


public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger=Logger.getLogger("BaseServlet.java");
	private final ServizioDAO servizioDAO = new ServizioDAO();

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Servizio> servizi = servizioDAO.doRetrieveAll();
		request.setAttribute("servizi", servizi);
		logger.info("Entarto in BaseServlet.java");
		super.service(request, response);
	}

	protected void checkAdmin(HttpServletRequest request) throws ServletException {
		Utente utente = (Utente) request.getSession().getAttribute("utente");
		if (utente == null || !utente.isAdmin()) {
			throw new MyServletException("Utente non autorizzato");
		}
	}
}

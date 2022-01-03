
package GestioneOfferte;

import java.io.IOException;





import java.util.logging.Logger;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import GestioneGenerale.BaseServlet;

import GestioneUtente.Utente;


@WebServlet("/RimuoviOfferta")
public class RImuoviOffertaServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private final OffertaDAO offertaDAO = new OffertaDAO();
	private static Logger logger=Logger.getLogger("RimuoviOffertaServlet.java");
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		logger.info("Entarto in RimuoviOffertaServlet.java");
		Utente utente = (Utente) request.getSession().getAttribute("utente");
		if (utente == null || (utente.gestore())==1) {
			throw new MyServletException("Utente non autorizzato");
		}

		String idstr = request.getParameter("id");
		if (idstr != null) {
			if (request.getParameter("rimuovi") != null) {
				offertaDAO.doDelete(Integer.parseInt(idstr));
				request.setAttribute("notifica", "Offerta rimossa con successo.");
				
			}
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("gestioneOfferte/aggiungiOfferta.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}


package GestioneUtente;

import java.io.IOException;



import java.util.List;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import GestioneGenerale.BaseServlet;


@WebServlet("/RimuoviProfilo")
public class RimuoviProfiloServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private final UtenteDAO utenteDAO = new UtenteDAO();
	private static Logger logger=Logger.getLogger("EliminaAccountServlet.java");
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		checkAdmin(request);
		logger.info("Entarto in EliminaAccountServlet.java");
		List<Utente> utenti = utenteDAO.doRetrieveAll(0, 10);
		request.setAttribute("utenti", utenti);

		
		
		
		String idstr = request.getParameter("id");
		if (idstr != null) {
			request.getAttribute("utenti");
		
		Utente utente = null;
		
		if (!idstr.isEmpty()) {
			int id = Integer.parseInt(idstr);
			utente = utenti.stream().filter(c -> c.getId() == id).findAny().get();
		}

		if (request.getParameter("rimuovi") != null) {
			logger.info("Entarto in rimuovi utente");
			utenteDAO.doDelete(utente.getId());
			utenti.remove(utente);
			request.setAttribute("notifica", "utente rimosso con successo.");
			
			request.getSession().removeAttribute("utente");

			String dest = request.getHeader("referer");
			if (dest == null || dest.contains("/Logout") || dest.trim().isEmpty()) {
				dest = ".";
			}
			response.sendRedirect(dest);
		}
		
		} 
		
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

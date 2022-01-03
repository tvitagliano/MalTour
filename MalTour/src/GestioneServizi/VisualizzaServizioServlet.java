
package GestioneServizi;

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
import GestioneOfferte.Offerta;
import GestioneOfferte.OffertaDAO;




@WebServlet("/VisualizzaServizio")
public class VisualizzaServizioServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private final OffertaDAO offertaDAO = new OffertaDAO();
	private static Logger logger=Logger.getLogger("ServizioServlet.java");
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		@SuppressWarnings("unchecked")
		
		List<Servizio> servizi = (List<Servizio>) request.getAttribute("servizi");
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("servizio", servizi.stream().filter(c -> c.getId() == id).findAny().get());

		List<Offerta> offerte = offertaDAO.doRetrieveByServizio(id, 0, 10);
		request.setAttribute("offerte", offerte);
		logger.info("Entarto in ServizioServlet.java");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("gestioneServizi/servizio.jsp");
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

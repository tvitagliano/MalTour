
package GestioneOrdini;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import GestioneGenerale.BaseServlet;
import GestioneOfferte.OffertaDAO;



@WebServlet("/VisualizzaCarrello")
public class VisualizzaCarrelloServlet extends BaseServlet{
	private static final long serialVersionUID = 1L;
	private final OffertaDAO offertaDAO = new OffertaDAO();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Carrello carrello = (Carrello) session.getAttribute("carrello");
		if (carrello == null) {
			carrello = new Carrello();
			session.setAttribute("carrello", carrello);
		}

		

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("gestioneUtente/carrello.jsp");
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

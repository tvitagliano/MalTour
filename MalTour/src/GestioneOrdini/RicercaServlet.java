
package GestioneOrdini;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import GestioneGenerale.BaseServlet;
import GestioneOfferte.Offerta;
import GestioneOfferte.OffertaDAO;




@WebServlet("/Ricerca")
public class RicercaServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private final OffertaDAO offertaDAO = new OffertaDAO();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Offerta> offerte = offertaDAO.doRetrieveByDestinazione(request.getParameter("q"), 0, 10);
		request.setAttribute("offerte", offerte);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("gestioneGenerale/ricerca.jsp");
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

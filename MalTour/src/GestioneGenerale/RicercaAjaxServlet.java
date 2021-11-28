
package GestioneGenerale;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import GestioneOfferte.Offerta;
import GestioneOfferte.OffertaDAO;



@WebServlet("/RicercaAjax")
public class RicercaAjaxServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private final OffertaDAO offertaDAO = new OffertaDAO();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		JSONArray prodJson = new JSONArray();
		String query = request.getParameter("q");
		if (query != null) {
			List<Offerta> offerte = offertaDAO.doRetrieveByDestinazione(query + "*", 0, 10);
			for (Offerta p : offerte) {
				prodJson.put(p.getDestinazione());
			}
		}
		response.setContentType("application/json");
		response.getWriter().append(prodJson.toString());
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

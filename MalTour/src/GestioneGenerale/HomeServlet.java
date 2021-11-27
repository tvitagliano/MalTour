
package GestioneGenerale;

import java.io.IOException;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import GestioneOfferte.Offerta;
import GestioneOfferte.OffertaDAO;





@WebServlet("")
public class HomeServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger=Logger.getLogger("HomeServlet.java");
	private final OffertaDAO offertaDAO = new OffertaDAO();


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("Entarto in HomeServlet.java");
		List<Offerta> offerte = offertaDAO.doRetrieveAll(0, 10);
		request.setAttribute("offerte", offerte);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("gestioneGenerale/index.jsp");
		requestDispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}


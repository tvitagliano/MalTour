
package GestioneUtente;

import java.io.IOException;




import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import GestioneGenerale.BaseServlet;
import GestioneOfferte.MyServletException;



@WebServlet("/Login")
public class LoginServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private final UtenteDAO utenteDAO = new UtenteDAO();



	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Utente utente = null;
		if (username != null && password != null) {
			utente = utenteDAO.doRetrieveByUsernamePassword(username, password);		
		}
		

		if (utente == null) {
			throw new MyServletException("Username e/o password non validi.");
		}
		request.getSession().setAttribute("utente", utente);

		
		Cookie cookie = new Cookie(username, password);
		cookie.setMaxAge(30 * 24 * 60 * 60); // 30 giorni
		response.addCookie(cookie);
		
		
		String dest = request.getHeader("referer");
		if (dest == null || dest.contains("/Login") || dest.trim().isEmpty()) {
			dest = ".";
		}
		response.sendRedirect(dest);
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

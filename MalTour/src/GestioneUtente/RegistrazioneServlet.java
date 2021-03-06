package GestioneUtente;

import java.io.IOException;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import GestioneGenerale.BaseServlet;
import GestioneOfferte.MyServletException;



@WebServlet("/Registrazione")
public class RegistrazioneServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private UtenteDAO utenteDAO = new UtenteDAO();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("utente") != null) {
			throw new MyServletException("Utente loggato.");
		}

		String username = request.getParameter("username");
		if (!(username != null && username.length() >= 6 && username.matches("^[0-9a-zA-Z]+$"))) {
			throw new MyServletException("Username non valido.");
		}

		String password = request.getParameter("password");
		if (!(password != null && password.length() >= 8 && !password.toUpperCase().equals(password)
				&& !password.toLowerCase().equals(password) && password.matches(".*[0-9].*"))) {
			throw new MyServletException("Password non valida.");
		}

		String passwordConferma = request.getParameter("passwordConferma");
		if (!password.equals(passwordConferma)) {
			throw new MyServletException("Password e conferma differenti.");
		}

		String nome = request.getParameter("nome");
		if (!(nome != null && nome.trim().length() > 0 && nome.matches("^[ a-zA-Z\u00C0-\u00ff]+$"))) {
			throw new MyServletException("Nome non valido.");
		}

		String email = request.getParameter("email");
		if (!(email != null && email.matches("^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w+)+$"))) {
			throw new MyServletException("Email non valida.");
		}
		int gestore = 1;

		Utente utente = new Utente();
		utente.setUsername(username);
		utente.setPassword(password);
		utente.setNome(nome);
		utente.setEmail(email);
		utente.setGestore(gestore);
		utenteDAO.doSave(utente);
		request.getSession().setAttribute("utente", utente);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("gestioneUtente/registrazioneSuccesso.jsp");
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

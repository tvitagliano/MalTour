
package GestioneOfferte;

import java.io.IOException;




import java.util.Arrays;
import java.util.Collections;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import GestioneGenerale.BaseServlet;
import GestioneServizi.Servizio;
import GestioneUtente.Utente;


@WebServlet("/AggiungiOfferta")
public class AggiungiOffertaServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private final OffertaDAO offertaDAO = new OffertaDAO();
	private String idstr;
	private static Logger logger=Logger.getLogger("AggiungiOffertaServlet.java");
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("Entarto in AggiungiOffertaServlet.java");
		Utente utente = (Utente) request.getSession().getAttribute("utente");
		if (utente == null || (utente.gestore())==1) {
			throw new MyServletException("Utente non autorizzato");
		}

		idstr = request.getParameter("id");
		if (idstr == null) {
				Offerta offerta;
				
				String destinazione = request.getParameter("destinazione");
				String descrizione = request.getParameter("descrizione");
				String data_partenza = request.getParameter("data_partenza");
				String ora_partenza = request.getParameter("ora_partenza");
				String data_ritorno = request.getParameter("data_ritorno");
				String ora_ritorno = request.getParameter("ora_ritorno");
				String partenza_da = request.getParameter("partenza_da");
				String arrivo_a = request.getParameter("arrivo_a");
				String pernottamento = request.getParameter("pernottamento");
				String posti_disponibili = request.getParameter("posti_disponibili");
				String prezzoCent = request.getParameter("prezzoCent");
				
				//aggiunta Offerta
					offerta = new Offerta();
					offerta.setDestinazione(destinazione);
					offerta.setDescrizione(descrizione);
					offerta.setData_partenza(data_partenza);
					offerta.setOra_partenza(ora_partenza);
					offerta.setData_ritorno(data_ritorno);
					offerta.setOra_ritorno(ora_ritorno);
					offerta.setPartenza_da(partenza_da);
					offerta.setArrivo_a(arrivo_a);
					offerta.setPernottamento(pernottamento);
					offerta.setPosti_disponibili(Integer.parseInt(posti_disponibili));
					offerta.setPrezzoCent(Long.parseLong(prezzoCent));

					String[] servizi= request.getParameterValues("servizi");
					offerta.setServizi(servizi != null ? Arrays.stream(servizi).map(id -> {
						Servizio c = new Servizio();
						c.setId(Integer.parseInt(id));
						return c;
					}).collect(Collectors.toList()) : Collections.emptyList());

					if (idstr.isEmpty()) { // aggiunta nuovo prodotto
						offertaDAO.doSave(offerta);
						request.setAttribute("notifica", "Offerta aggiunta con successo.");
					} 
				
				request.setAttribute("offerta", offerta);
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


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
import GestioneOfferte.MyServletException;


@WebServlet("/ModificaServizio")
public class ModificaServizioServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private final ServizioDAO servizioDAO = new ServizioDAO();
	private static Logger logger=Logger.getLogger("AdminServizioServlet.java");

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		checkAdmin(request);

		String idstr = request.getParameter("id");
		if (idstr != null) {
			request.setAttribute("notifica", "aa");
			
			@SuppressWarnings("unchecked")
			List<Servizio> servizi = ((List<Servizio>) request.getAttribute("servizi"));

			Servizio servizio = null;
			
			if (!idstr.isEmpty()) {
				int id = Integer.parseInt(idstr);
				servizio = servizi.stream().filter(c -> c.getId() == id).findAny().get();
			}
			

			if (request.getParameter("rimuovi") != null) {
				servizioDAO.doDelete(servizio.getId());
				servizi.remove(servizio);
				request.setAttribute("notifica", "Servizio rimosso con successo.");
			} else {
				
				String nome = request.getParameter("nome");
				String descrizione = request.getParameter("descrizione");
				
				
				if (nome != null && descrizione != null) { // modifica aggiunta categoria
					if (!(nome != null && nome.trim().length() > 0)) {
                        throw new MyServletException("Non hai inserito alcun nome! Riprova.");
                    }

                    if (!(descrizione != null && descrizione.trim().length() > 0)) {
                        throw new MyServletException("Non hai inserito alcuna descrizione! Riprova.");
                    }
					
					if (servizio == null) { // aggiunta nuovo servizio
						servizio = new Servizio();
						servizio.setNome(nome);
						servizio.setDescrizione(descrizione);
						
						if ((servizioDAO.doRetrieveByNome(nome) != null)) {
                            throw new MyServletException("Il servizio che vuoi inserire è gia presente! Riprova");
                        }
						
						
						servizioDAO.doSave(servizio);
						servizi.add(servizio);
						request.setAttribute("notifica", "Servizio aggiunto con successo.");
						
						
						
					} else { // modifica servizio esistente
						
						if ((servizioDAO.doRetrieveByNome(nome) != null) && (servizioDAO.doRetrieveByDescrizione(descrizione) != null)) {
													throw new MyServletException("Non hai modificato alcun parametro! Riprova");
                        } 
						
						servizio.setNome(nome);
						servizio.setDescrizione(descrizione);
						servizioDAO.doUpdate(servizio);
						request.setAttribute("notifica", "Servizio modificato con successo.");
					}
				}
				request.setAttribute("servizio", servizio);
			}
		}
		logger.info("Entarto in AdminServizioServlet.java");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("gestioneServizi/adminservizio.jsp");
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

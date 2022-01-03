package GestioneOrdini;


import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import GestioneGenerale.BaseServlet;
import GestioneOfferte.MyServletException;

import java.io.IOException;

@WebServlet("/Ordine")
public class AggiungiComponentiServlet extends BaseServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	OrdineDAO ordineDAO = new OrdineDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);


    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {



        if (request.getSession().getAttribute("utente") == null) {
        	
            throw new MyServletException("Registrati!");
        } else {
        	Ordine ordine;
        	ComponentiViaggio componenti;
            int id = Integer.parseInt(request.getParameter(("id")));
            int idutente = Integer.parseInt(request.getParameter(("idutente")));
            int idofferta = Integer.parseInt(request.getParameter(("idofferta")));
            String email = request.getParameter("indirizzo");
            
            String nome = request.getParameter("nome");
            String cognome = request.getParameter("cognome");
            String data_nascita = request.getParameter("data_nascita");

            if (!(email.trim().length() > 0)) {
                throw new MyServletException("Non hai specificato un indirizzo! Riprova.");
            }
            
            ordine = new Ordine();
            ordine.setId(id);
            ordine.setIdutente(idutente);
            ordine.setIdofferta(idofferta);
            ordine.setEmail(email);
            ordine.setStato(false);
            
           componenti = new ComponentiViaggio();
           componenti.setNome(nome);
           componenti.setCognome(cognome);
           componenti.setData_nascita(data_nascita);
            
            

            ordineDAO.doSave(ordine);
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("gestioneOrdini/visualizzaOrdine.jsp");
        requestDispatcher.forward(request, response);


    }
}

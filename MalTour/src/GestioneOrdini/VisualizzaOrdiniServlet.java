package GestioneOrdini;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import GestioneGenerale.BaseServlet;
import GestioneOfferte.MyServletException;
import GestioneUtente.Utente;

import java.io.IOException;
import java.util.List;


@WebServlet("/VIsualizzaOrdini")
public class VisualizzaOrdiniServlet extends BaseServlet {
    private static final long serialVersionUID = 1L;
    private final OrdineDAO ordineDAO = new OrdineDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Utente utente = (Utente) request.getSession().getAttribute("utente");
        if (utente == null) {
            throw new MyServletException("Utente non autorizzato");
        }



        int id = Integer.parseInt(request.getParameter("id"));

        List<Ordine> ordini = ordineDAO.doRetrieveByUtente(id);
        request.setAttribute("ordini", ordini);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("gestioneOrdini/ordini.jsp");
        requestDispatcher.forward(request, response);
    }


}

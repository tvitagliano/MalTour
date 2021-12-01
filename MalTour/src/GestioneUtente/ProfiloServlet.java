package GestioneUtente;


import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import GestioneGenerale.BaseServlet;

import java.io.IOException;
import java.util.logging.Logger;


@WebServlet("/Profilo")
public class ProfiloServlet extends BaseServlet {
    private static final long serialVersionUID = 1L;
    private UtenteDAO utenteDAO = new UtenteDAO();
    private static Logger logger=Logger.getLogger("ProfiloServlet.java");

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        Utente utente=new Utente();
        utente = utenteDAO.doRetrieveById(id);

        request.setAttribute("utente", utente);
        logger.info("Entarto in ProfiloServlet.java");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/gestioneUtente/profiloUtente.jsp");
        requestDispatcher.forward(request, response);

    }


}

package GesioneOdini;

import javax.servlet.RequestDispatcher;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import GestioneGenerale.BaseServlet;

import java.io.IOException;

@WebServlet("/Spedizione")
public class SpedizioneServlet extends BaseServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("gestioneOrdini/acquisto.jsp");
        requestDispatcher.forward(request, response);


    }
}

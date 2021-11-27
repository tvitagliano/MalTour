package GestioneGenerale;




import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/About")
public class AboutServlet extends BaseServlet {
	Logger logger=Logger.getLogger("aboutServlet.java");

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		logger.info("AboutServlet.java");
        doGet(request, response);
        
    }
	


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("gestioneGenerale/about.jsp");
        requestDispatcher.forward(request, response);
    }




}

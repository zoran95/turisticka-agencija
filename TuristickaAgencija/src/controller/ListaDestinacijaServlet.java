package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Destinacija;
import service.TransportService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListaDestinacijaServlet
 */
@WebServlet("/ListaDestinacijaServlet")
public class ListaDestinacijaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaDestinacijaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TransportService service = new TransportService();

		//izvlacim iz baze listu destinacija
		List<Destinacija> listaDestinacija = service.vratiSveDestinacije();

		//popunjavam request object
		request.setAttribute("listaDestinacija", listaDestinacija);

		if(listaDestinacija != null && !listaDestinacija.isEmpty()) {
			//saljem na dodajTransport.jsp
			RequestDispatcher dispatcher = request.getRequestDispatcher("view/dodajTransport.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect("view/adminPage.jsp");
		}



	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

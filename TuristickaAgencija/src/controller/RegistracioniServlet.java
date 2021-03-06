package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.RegistracioniService;

/**
 * Servlet implementation class RegistracioniServlet
 */
@WebServlet(description = "ovo je servlet za registraciju korisnika", urlPatterns = { "/RegistracioniServlet" })
public class RegistracioniServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistracioniServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		//preuzimanje parametara sa forme tj. iz url
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String repeatedPassword = request.getParameter("repeatedPassword");
		
		
		System.out.println(userName);
		System.out.println(password);
		System.out.println(repeatedPassword);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String repeatedPassword = request.getParameter("repeatedPassword");
		
		
		System.out.println(userName);
		System.out.println(password);
		System.out.println(repeatedPassword);
		
		
		//povezujem se sa servisom
		RegistracioniService service = new RegistracioniService();
		
		//provera passworda
		boolean proveraPassworda = service.daLiSuIstiPasswordi(password, repeatedPassword);
		
		//vraca mi popunjenog usera(to mi je model)
		User user = service.vratiUserModel(userName, password);
		
		
		if (proveraPassworda) {
		
			//upisujem usera u bazu
			boolean daLiJeUpisaoUseraUBazu = service.upisiUseraUBazu(user);
			
			if (daLiJeUpisaoUseraUBazu) {
				//idi na uspesno si se registrovao!!!
				response.sendRedirect("htmlFajlovi/uspesnaRegistracija.html");
			}
			else {
				//idi na registracionu formu ponovo
				response.sendRedirect("htmlFajlovi/registracija.html");
			}
			
			
		}
		else {
			//idi na registracionu formu ponovo
			response.sendRedirect("htmlFajlovi/registracija.html");
		}
		
		
		
		
		
		
		
		
	}
	

}

package controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Destinacija;
import model.TipTransporta;
import model.Transport;
import service.TransportService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DodajTransportServlet
 */
@WebServlet("/DodajTransportServlet")
public class DodajTransportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DodajTransportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cena= request.getParameter("cena");
		String popust = request.getParameter("popust");
		String tipPrevoza = request.getParameter("radioDugme");
		String idDestinacije = request.getParameter("destinacija");
		
		
		TransportService servis = new TransportService();
		//model za insert u bazu
		Transport transport = new Transport();
		if (cena != null) {
			transport.setCena(Double.parseDouble(cena));
		}
		if (popust!= null) {
			transport.setPopust(Double.parseDouble(popust));
		}else {
			transport.setPopust(0.0);
		}
		
		if (tipPrevoza != null) {
			
			servis.podesiTipTransporta(transport, tipPrevoza);
		}
		
		List<Destinacija> lista =(List<Destinacija>) request.getAttribute("listaDestinacija");
		System.out.println("Id prve destinacije:" + lista.get(0).getIdDestinacija());
	
		
	}

}

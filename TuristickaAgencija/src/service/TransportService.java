package service;

import java.util.List;

import dao.TransportDAO;
import model.Destinacija;
import model.Transport;
import razno.Common;

public class TransportService {
	TransportDAO dao = new TransportDAO();

	Common zajednicka = new Common();
	public List<Destinacija> vratiSveDestinacije() {

		return dao.vratiSveDestinacije();
	}
	
	public void podesiTipTransporta(Transport transport, String tipPrevoza) {
		zajednicka.podesiTipTransporta( transport, tipPrevoza);
	}
}

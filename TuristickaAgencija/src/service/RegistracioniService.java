package service;

import dao.RegistracijaDAO;
import model.User;
import razno.Common;
import validacija.ValidacijaRegistracije;

public class RegistracioniService {

	
	//povezujem se sa validacijom
	ValidacijaRegistracije validacija = new ValidacijaRegistracije();
	
	
	//povezujem se sa dao klasom
	RegistracijaDAO dao = new RegistracijaDAO();
	
	//povezujem sa klasom razno
	Common razno = new Common();
	
	public boolean daLiSuIstiPasswordi(String password, String repeatedPassword) {
		return validacija.daLiSuIstiPasswordi(password, repeatedPassword);
	}

	public boolean upisiUseraUBazu(User user) {
		
		return dao.upisiUseraUBazu(user);
	}

	public User vratiUserModel(String userName, String password) {
		
		return razno.vratiUserModel(userName, password);
	}
}

package service;

import dao.LoginDAO;
import model.User;

public class LoginService {

	LoginDAO dao = new LoginDAO();

	public User vratiUseraLogin(String userName, String password) {
		
		return dao.vratiUseraLogin(userName,  password);
	}
	
}

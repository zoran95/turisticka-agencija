package dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.User;

public class LoginDAO {

	SessionFactory factory = new Configuration().configure().buildSessionFactory();

	public User vratiUseraLogin(String userName, String password) {
		
		return null;
	}
}

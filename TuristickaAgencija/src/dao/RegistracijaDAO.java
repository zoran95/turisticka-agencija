package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.User;

public class RegistracijaDAO {

	
	SessionFactory factory = new Configuration().configure().buildSessionFactory();
	
	
	public boolean upisiUseraUBazu(User user) {  
		
		
		
		
		Session sesija = factory.openSession();
		sesija.beginTransaction();
		
		try {
			sesija.save(user);
			sesija.getTransaction().commit();
			return true;
		} catch (Exception e) {
			sesija.getTransaction().rollback();
			return false;
		}
		finally {
			sesija.close();
		}
		
	}

}

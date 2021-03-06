package  com.cryptocurrency.entity.tests;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.cryptocurrency.entity.objects.Cryptocurrency;
import com.cryptocurrency.entity.objects.CurrencyDailyPrice;



public class GetCurrencyTopfiveTestConsole {

	public static void main(String[] args) {
		
		List<Cryptocurrency> currencies=new ArrayList<>();
		
		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Cryptocurrency.class)
			//	.addAnnotatedClass(CurrencyDailyPrice.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			  Query<Cryptocurrency> query = session.createQuery("from Cryptocurrency", Cryptocurrency.class);
		 
		        query.setFirstResult(0);
		        query.setMaxResults(5);

		        List<Cryptocurrency> labels = query.list();
					for(Cryptocurrency currency : labels) {
			System.out.println("sf:->   "+currency);
			currencies.add(currency);
		}
			
			session.getTransaction().commit();
			System.out.println("Session committed!");

		} catch (Exception err) {
			err.printStackTrace();

		} finally {
			session.close();
			factory.close();
		}
		for(Cryptocurrency currency : currencies) {
			System.out.println("currencies List: -->   "+currency);
		}
		System.out.println("\n\nend of line");
	}

}

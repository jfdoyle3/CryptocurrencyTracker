package  testhibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class EntityDBWriteOneRecordTest {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Cryptocurrency.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			Cryptocurrency currency = new Cryptocurrency("WHO", "BTC", "BTC", "Bitcoin","1",
				"https://s3.us-east-2.amazonaws.com/nomics-api/static/images/currencies/btc.svg");

		//	Cryptocurrencies currency = new Cryptocurrencies();
			
		//	currency.setSymbol("BTC");
			
			session.beginTransaction();

			System.out.println("||Saving Currency: " + currency);

			session.save(currency);

			session.getTransaction().commit();
			System.out.println("Done!");

		} catch (Exception err) {
			err.printStackTrace();

		} finally {
			session.close();
			factory.close();
		}

	}

}

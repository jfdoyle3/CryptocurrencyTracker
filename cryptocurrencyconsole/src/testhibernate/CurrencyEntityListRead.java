package testhibernate;

import java.util.List;

import org.hibernate.Session;

import kong.unirest.json.JSONArray;

public class CurrencyEntityListRead {

	public static void main(String[] args) {
		Session session = HibernateCurrencyFactory.getSessionFactory().openSession();
		session.beginTransaction();

		JSONArray json = APIEntity.Currencies("", "7d");
		List<Cryptocurrencies> list = APIEntity.CurrencyID(json);

		for (Cryptocurrencies currency : list) {
			System.out.println(currency);
			session.save(currency);
		}

		session.getTransaction().commit();
		HibernateUtilTemplateNoAnnotations.shutdown();
	}
}
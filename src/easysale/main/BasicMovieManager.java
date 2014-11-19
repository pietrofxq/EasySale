package easysale.main;
import org.hibernate.*;
import org.hibernate.boot.registry.*;
import org.hibernate.cfg.*;
import org.hibernate.service.*;

import java.util.*;

public class BasicMovieManager {
	
	private SessionFactory sessionFactory = null;
	
	public BasicMovieManager() {
		initSessionFactory();
	}

	private void initSessionFactory() {
		try {
			
		
		Configuration config = new Configuration().configure();
		// Build a Registry with our configuration properties
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
				config.getProperties()).build();
		// create the session factory
		sessionFactory = config.buildSessionFactory(serviceRegistry);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void persistMovie(Movie movie) {
		try {
			
		
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			session.save(movie);
			System.out.println("Movie inserted");
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void findMovie(int movieId) {
		try {
			
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			Movie movie = (Movie)session.load(Movie.class, movieId);
			System.out.println("Movie:"+movie);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void findAll() {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			List<Movie> movies = session.createQuery("from Movie").list();
			session.getTransaction().commit();
			System.out.println("Todos os filmes:");
			for (Movie filme : movies) {
				System.out.println(filme.getTitle());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package easysale.controller;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import easysale.model.Funcionario;

public class FuncionarioController {
	private SessionFactory sessionFactory;
	
	public FuncionarioController(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void persist(Funcionario func) {
		
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			session.saveOrUpdate(func);
			session.getTransaction().commit();
			System.out.println("Salvo com sucesso");
			
		} catch(HibernateException e) {
			e.printStackTrace();
		}
		
	}
	
	public void delete(Funcionario func) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			session.delete(func);
			session.getTransaction().commit();
			System.out.println("Excluido com sucesso");
			
		} catch(HibernateException e) {
			e.printStackTrace();
		}
	}
	
	public List<Funcionario> findAll() {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			List<Funcionario> funcionarios = session.createQuery("from Funcionario").list();
			session.getTransaction().commit();
			return funcionarios;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


}

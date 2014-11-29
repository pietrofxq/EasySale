package easysale.controller;

import java.util.List;

import org.controlsfx.dialog.Dialogs;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import easysale.model.*;
import easysale.util.EasyUtil;

public class ClienteController {
	
	private SessionFactory sessionFactory;
	
	
	public ClienteController(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void persist(Cliente cliente) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			System.out.println("ID do cliente:" + cliente.getId());
			session.saveOrUpdate(cliente);
			System.out.println("Cliente " + cliente.getNome() + " inserido no bd");
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Cliente> findAll() {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			List<Cliente> clientes = session.createQuery("from Cliente").list();
			for (Cliente cliente : clientes) {
				System.out.println(cliente.getNome());
			}
			session.getTransaction().commit();
			
			return clientes;
			
		} catch (Exception e) {
			e.printStackTrace();
			
			return null;
		}
	}
	
	public Cliente findByCpf(String cpf) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			String select = "from Cliente where cpf = :cpf";
			Query query = session.createQuery(select);
			query.setString("cpf", cpf);
			query.setMaxResults(1);
			Cliente cliente = (Cliente) query.uniqueResult();
			if (cliente != null) {
				session.getTransaction().commit();
				return cliente;
			} else {
				return null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void delete(Cliente cliente) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			session.delete(cliente);
			
			System.out.println("Cliente " + cliente.getNome() + " deletado do bd");
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

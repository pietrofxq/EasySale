package easysale.controller;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
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
			session.saveOrUpdate(cliente);
			System.out.println("ID do cliente:" + cliente.getId());
			System.out.println("Cliente " + cliente.getNome() + " inserido/alterado no bd");
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public Set<Cliente> findAll() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Set<Cliente> clientes = (Set<Cliente>) session.createCriteria(Cliente.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		session.getTransaction().commit();
		return clientes;
		/*try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			List<Cliente> clientes = EasyUtil.castList(Cliente.class, session.createQuery("from Cliente").list());
			for (Cliente cliente : clientes) {
				System.out.println(cliente.getNome());
				System.out.println(cliente.getCompras());
			}
			session.getTransaction().commit();
			
			return clientes;
			
		} catch (Exception e) {
			e.printStackTrace();
			
			return null;
		}*/
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

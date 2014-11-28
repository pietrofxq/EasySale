package easysale.controller;

import java.util.List;

import org.hibernate.*;

import easysale.model.*;
import easysale.main.*;
import easysale.util.*;

public class ProdutoController {
	
	private SessionFactory sessionFactory;
	
	public ProdutoController(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public void persist(Produto produto) {
		try {
			
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			System.out.println("ID do produto:" + produto.getId());
			session.saveOrUpdate(produto);
			System.out.println("Produto " + produto.getNome() + " inserido no bd");
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Produto> findAll() {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			List<Produto> produtos = EasyUtil.castList(Produto.class, session.createQuery("from Produto").list());

			session.getTransaction().commit();
			
			return produtos;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void delete(Produto produto) {
		try {
			
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			session.delete(produto);
			System.out.println("Produto " + produto.getNome() + " deletado do bd");
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

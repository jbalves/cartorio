package br.com.academia.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.academia.model.bean.Cliente;
import br.com.academia.util.JPAUtil;

public class ClienteDAO extends AbstractDAO<Cliente, Integer> {
	EntityManager manager;
	
	public ClienteDAO() {
		super(Cliente.class);
		manager = new JPAUtil().getEntityManager();
	}

	public List<Cliente> buscarNome(Cliente cliente) {
		try{
			Query query = manager
					.createQuery("Select c from Cliente c where c.nome like :pCliente");
			query.setParameter("pCliente", "%" + cliente.getNome() + "%");
			return query.getResultList();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			manager.close();
		}
	}

}

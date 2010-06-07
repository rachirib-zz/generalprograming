package co.com.fc.bd.logic;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import co.com.fc.bd.config.oracle.HibernateSessionFactoryOracle;
import co.com.fc.bd.model.FacrPParametro;
import co.com.fc.bd.model.FacrPParametroDAO;

public class ParametroLogica {
	
	public FacrPParametroDAO parametroDAO = new FacrPParametroDAO();

	public void save(FacrPParametro parametro) throws Exception{
		Transaction transaction = null;
		try {
			transaction = HibernateSessionFactoryOracle.getSession().beginTransaction();
			
			
			parametroDAO.save(parametro);
			
			transaction.commit();
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw e;
		}	
	}
	
	public List<FacrPParametro> findAll() throws Exception{
		List<FacrPParametro> losParametros = parametroDAO.findAll();
		
		return losParametros;
	}
	
	public FacrPParametro findById(Long id) throws Exception{
		FacrPParametro parametro = parametroDAO.findById(id);
		
		return parametro;
	}
	
	public List<FacrPParametro> findByTipoParametro(Long codTipoParametro) throws Exception{
		Criteria criteria = HibernateSessionFactoryOracle.getSession().createCriteria(FacrPParametro.class);
		criteria.add(Restrictions.eq("facrPTipoParametro.consTipoParametro", codTipoParametro));
		
		List<FacrPParametro> losParametros = (List<FacrPParametro>) criteria.list();
		
		return losParametros;
	}
	
	
}

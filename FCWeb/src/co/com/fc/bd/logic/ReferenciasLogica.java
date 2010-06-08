package co.com.fc.bd.logic;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import co.com.fc.bd.config.oracle.HibernateSessionFactoryOracle;
import co.com.fc.bd.model.FacrReferencias;
import co.com.fc.bd.model.FacrReferenciasDAO;

public class ReferenciasLogica {

	private FacrReferenciasDAO referenciasDAO = new FacrReferenciasDAO();
	
	public List<FacrReferencias> findBySolicitante(String numId) throws Exception{
		
		Criteria criteria = HibernateSessionFactoryOracle.getSession().createCriteria(FacrReferencias.class);
		
		criteria.add(Restrictions.eq("facrSolicitante.numId", numId));
		
		List<FacrReferencias> lasReferencias = (List<FacrReferencias>)criteria.list();
		
		return lasReferencias;
		
	}
	
	public FacrReferencias findById(Long consReferencias) throws Exception{
		
		FacrReferencias facrReferencias = referenciasDAO.findById(consReferencias);
		
		return facrReferencias;
		
	}
	
	public FacrReferencias findByIdentificacion(String numId) throws Exception{
		
		Criteria criteria = HibernateSessionFactoryOracle.getSession().createCriteria(FacrReferencias.class);
		
		criteria.add(Restrictions.eq("identificacion", numId));
		
		FacrReferencias referencia = (FacrReferencias)criteria.uniqueResult();
		
		return referencia;
		
	}
	
	public void save(FacrReferencias referencias) throws Exception{
		Transaction transaction = null;
		try {
			
			transaction = HibernateSessionFactoryOracle.getSession().beginTransaction();
			
			FacrReferencias referencias2 = findByIdentificacion(referencias.getIdentificacion());
			if (referencias2 == null) {
				referenciasDAO.save(referencias);
			}
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw e;
		}
	}
	
}

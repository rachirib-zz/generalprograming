package co.com.fc.bd.logic;

import org.hibernate.Transaction;

import co.com.fc.bd.config.oracle.HibernateSessionFactoryOracle;
import co.com.fc.bd.model.FacrPTipoParametro;
import co.com.fc.bd.model.FacrPTipoParametroDAO;

public class TipoParametroLogica {

	public void save(FacrPTipoParametro tipoParametro) throws Exception{
		Transaction transaction = null;
		try {
			transaction = HibernateSessionFactoryOracle.getSession().beginTransaction();
			
			FacrPTipoParametroDAO facrPTipoParametroDAO = new FacrPTipoParametroDAO();
			facrPTipoParametroDAO.save(tipoParametro);
			
			transaction.commit();
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw e;
		}	
	}
	
}

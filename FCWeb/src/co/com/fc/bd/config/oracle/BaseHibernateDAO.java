package co.com.fc.bd.config.oracle;

import org.hibernate.Session;

import co.com.fc.bd.config.oracle.HibernateSessionFactoryOracle;


/**
 * Data access object (DAO) for domain model
 * @author MyEclipse Persistence Tools
 */
public class BaseHibernateDAO implements IBaseHibernateDAO {
	
	public Session getSession() {
		return HibernateSessionFactoryOracle.getSession();
	}
	
}
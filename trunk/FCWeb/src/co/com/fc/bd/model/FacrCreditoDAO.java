package co.com.fc.bd.model;

import java.util.Date;
import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

import co.com.fc.bd.config.oracle.BaseHibernateDAO;

/**
 	* A data access object (DAO) providing persistence and search support for FacrCredito entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see co.com.fc.bd.model.FacrCredito
  * @author MyEclipse Persistence Tools 
 */

public class FacrCreditoDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(FacrCreditoDAO.class);
	//property constants
	public static final String MONTO_CREDITO = "montoCredito";
	public static final String ESTADO_CREDITO = "estadoCredito";



    
    public void save(FacrCredito transientInstance) {
        log.debug("saving FacrCredito instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(FacrCredito persistentInstance) {
        log.debug("deleting FacrCredito instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public FacrCredito findById( java.lang.Long id) {
        log.debug("getting FacrCredito instance with id: " + id);
        try {
            FacrCredito instance = (FacrCredito) getSession()
                    .get("co.com.fc.bd.model.FacrCredito", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(FacrCredito instance) {
        log.debug("finding FacrCredito instance by example");
        try {
            List results = getSession()
                    .createCriteria("co.com.fc.bd.model.FacrCredito")
                    .add(Example.create(instance))
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding FacrCredito instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from FacrCredito as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByMontoCredito(Object montoCredito
	) {
		return findByProperty(MONTO_CREDITO, montoCredito
		);
	}
	
	public List findByEstadoCredito(Object estadoCredito
	) {
		return findByProperty(ESTADO_CREDITO, estadoCredito
		);
	}
	

	public List findAll() {
		log.debug("finding all FacrCredito instances");
		try {
			String queryString = "from FacrCredito";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public FacrCredito merge(FacrCredito detachedInstance) {
        log.debug("merging FacrCredito instance");
        try {
            FacrCredito result = (FacrCredito) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(FacrCredito instance) {
        log.debug("attaching dirty FacrCredito instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(FacrCredito instance) {
        log.debug("attaching clean FacrCredito instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}
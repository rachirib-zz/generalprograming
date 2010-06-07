package co.com.fc.bd.model;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

import co.com.fc.bd.config.oracle.BaseHibernateDAO;

/**
 	* A data access object (DAO) providing persistence and search support for FacrLog entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see co.com.fc.bd.model.FacrLog
  * @author MyEclipse Persistence Tools 
 */

public class FacrLogDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(FacrLogDAO.class);
	//property constants
	public static final String DESCRIPCION = "descripcion";
	public static final String NUM_ID_SOLICITANTE = "numIdSolicitante";
	public static final String NUM_CREDITO = "numCredito";



    
    public void save(FacrLog transientInstance) {
        log.debug("saving FacrLog instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(FacrLog persistentInstance) {
        log.debug("deleting FacrLog instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public FacrLog findById( java.lang.Long id) {
        log.debug("getting FacrLog instance with id: " + id);
        try {
            FacrLog instance = (FacrLog) getSession()
                    .get("co.com.fc.bd.model.FacrLog", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(FacrLog instance) {
        log.debug("finding FacrLog instance by example");
        try {
            List results = getSession()
                    .createCriteria("co.com.fc.bd.model.FacrLog")
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
      log.debug("finding FacrLog instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from FacrLog as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByDescripcion(Object descripcion
	) {
		return findByProperty(DESCRIPCION, descripcion
		);
	}
	
	public List findByNumIdSolicitante(Object numIdSolicitante
	) {
		return findByProperty(NUM_ID_SOLICITANTE, numIdSolicitante
		);
	}
	
	public List findByNumCredito(Object numCredito
	) {
		return findByProperty(NUM_CREDITO, numCredito
		);
	}
	

	public List findAll() {
		log.debug("finding all FacrLog instances");
		try {
			String queryString = "from FacrLog";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public FacrLog merge(FacrLog detachedInstance) {
        log.debug("merging FacrLog instance");
        try {
            FacrLog result = (FacrLog) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(FacrLog instance) {
        log.debug("attaching dirty FacrLog instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(FacrLog instance) {
        log.debug("attaching clean FacrLog instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}
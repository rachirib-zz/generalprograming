package co.com.fc.bd.model;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

import co.com.fc.bd.config.oracle.BaseHibernateDAO;

/**
 	* A data access object (DAO) providing persistence and search support for FacrPParametro entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see co.com.fc.bd.model.FacrPParametro
  * @author MyEclipse Persistence Tools 
 */

public class FacrPParametroDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(FacrPParametroDAO.class);
	//property constants
	public static final String DESCRIPCION = "descripcion";
	public static final String VALOR = "valor";



    
    public void save(FacrPParametro transientInstance) {
        log.debug("saving FacrPParametro instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(FacrPParametro persistentInstance) {
        log.debug("deleting FacrPParametro instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public FacrPParametro findById( java.lang.Long id) {
        log.debug("getting FacrPParametro instance with id: " + id);
        try {
            FacrPParametro instance = (FacrPParametro) getSession()
                    .get("co.com.fc.bd.model.FacrPParametro", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(FacrPParametro instance) {
        log.debug("finding FacrPParametro instance by example");
        try {
            List results = getSession()
                    .createCriteria("co.com.fc.bd.model.FacrPParametro")
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
      log.debug("finding FacrPParametro instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from FacrPParametro as model where model." 
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
	
	public List findByValor(Object valor
	) {
		return findByProperty(VALOR, valor
		);
	}
	

	public List findAll() {
		log.debug("finding all FacrPParametro instances");
		try {
			String queryString = "from FacrPParametro";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public FacrPParametro merge(FacrPParametro detachedInstance) {
        log.debug("merging FacrPParametro instance");
        try {
            FacrPParametro result = (FacrPParametro) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(FacrPParametro instance) {
        log.debug("attaching dirty FacrPParametro instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(FacrPParametro instance) {
        log.debug("attaching clean FacrPParametro instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}
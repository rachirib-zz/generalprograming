package co.com.fc.bd.model;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

import co.com.fc.bd.config.oracle.BaseHibernateDAO;

/**
 	* A data access object (DAO) providing persistence and search support for FacrPTipoParametro entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see co.com.fc.bd.model.FacrPTipoParametro
  * @author MyEclipse Persistence Tools 
 */

public class FacrPTipoParametroDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(FacrPTipoParametroDAO.class);
	//property constants
	public static final String DESCRIPCION = "descripcion";
	public static final String VALOR = "valor";



    
    public void save(FacrPTipoParametro transientInstance) {
        log.debug("saving FacrPTipoParametro instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(FacrPTipoParametro persistentInstance) {
        log.debug("deleting FacrPTipoParametro instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public FacrPTipoParametro findById( java.lang.Long id) {
        log.debug("getting FacrPTipoParametro instance with id: " + id);
        try {
            FacrPTipoParametro instance = (FacrPTipoParametro) getSession()
                    .get("co.com.fc.bd.model.FacrPTipoParametro", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(FacrPTipoParametro instance) {
        log.debug("finding FacrPTipoParametro instance by example");
        try {
            List results = getSession()
                    .createCriteria("co.com.fc.bd.model.FacrPTipoParametro")
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
      log.debug("finding FacrPTipoParametro instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from FacrPTipoParametro as model where model." 
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
		log.debug("finding all FacrPTipoParametro instances");
		try {
			String queryString = "from FacrPTipoParametro";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public FacrPTipoParametro merge(FacrPTipoParametro detachedInstance) {
        log.debug("merging FacrPTipoParametro instance");
        try {
            FacrPTipoParametro result = (FacrPTipoParametro) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(FacrPTipoParametro instance) {
        log.debug("attaching dirty FacrPTipoParametro instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(FacrPTipoParametro instance) {
        log.debug("attaching clean FacrPTipoParametro instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}
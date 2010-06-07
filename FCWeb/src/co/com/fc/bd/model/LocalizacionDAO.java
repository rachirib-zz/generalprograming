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
 	* A data access object (DAO) providing persistence and search support for Localizacion entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see co.com.fc.bd.model.Localizacion
  * @author MyEclipse Persistence Tools 
 */

public class LocalizacionDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(LocalizacionDAO.class);
	//property constants
	public static final String DESCRIPCION = "descripcion";
	public static final String NIVEL = "nivel";



    
    public void save(Localizacion transientInstance) {
        log.debug("saving Localizacion instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Localizacion persistentInstance) {
        log.debug("deleting Localizacion instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Localizacion findById( java.lang.Long id) {
        log.debug("getting Localizacion instance with id: " + id);
        try {
            Localizacion instance = (Localizacion) getSession()
                    .get("co.com.fc.bd.model.Localizacion", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Localizacion instance) {
        log.debug("finding Localizacion instance by example");
        try {
            List results = getSession()
                    .createCriteria("co.com.fc.bd.model.Localizacion")
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
      log.debug("finding Localizacion instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Localizacion as model where model." 
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
	
	public List findByNivel(Object nivel
	) {
		return findByProperty(NIVEL, nivel
		);
	}
	

	public List findAll() {
		log.debug("finding all Localizacion instances");
		try {
			String queryString = "from Localizacion";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Localizacion merge(Localizacion detachedInstance) {
        log.debug("merging Localizacion instance");
        try {
            Localizacion result = (Localizacion) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Localizacion instance) {
        log.debug("attaching dirty Localizacion instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Localizacion instance) {
        log.debug("attaching clean Localizacion instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}
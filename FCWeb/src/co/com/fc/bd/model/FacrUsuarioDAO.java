package co.com.fc.bd.model;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

import co.com.fc.bd.config.oracle.BaseHibernateDAO;

/**
 	* A data access object (DAO) providing persistence and search support for FacrUsuario entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see co.com.fc.bd.model.FacrUsuario
  * @author MyEclipse Persistence Tools 
 */

public class FacrUsuarioDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(FacrUsuarioDAO.class);
	//property constants
	public static final String NOMBRE = "nombre";
	public static final String ROL = "rol";
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";



    
    public void save(FacrUsuario transientInstance) {
        log.debug("saving FacrUsuario instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(FacrUsuario persistentInstance) {
        log.debug("deleting FacrUsuario instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public FacrUsuario findById( java.lang.Long id) {
        log.debug("getting FacrUsuario instance with id: " + id);
        try {
            FacrUsuario instance = (FacrUsuario) getSession()
                    .get("co.com.fc.bd.model.FacrUsuario", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(FacrUsuario instance) {
        log.debug("finding FacrUsuario instance by example");
        try {
            List results = getSession()
                    .createCriteria("co.com.fc.bd.model.FacrUsuario")
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
      log.debug("finding FacrUsuario instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from FacrUsuario as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByNombre(Object nombre
	) {
		return findByProperty(NOMBRE, nombre
		);
	}
	
	public List findByRol(Object rol
	) {
		return findByProperty(ROL, rol
		);
	}
	
	public List findByUsername(Object username
	) {
		return findByProperty(USERNAME, username
		);
	}
	
	public List findByPassword(Object password
	) {
		return findByProperty(PASSWORD, password
		);
	}
	

	public List findAll() {
		log.debug("finding all FacrUsuario instances");
		try {
			String queryString = "from FacrUsuario";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public FacrUsuario merge(FacrUsuario detachedInstance) {
        log.debug("merging FacrUsuario instance");
        try {
            FacrUsuario result = (FacrUsuario) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(FacrUsuario instance) {
        log.debug("attaching dirty FacrUsuario instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(FacrUsuario instance) {
        log.debug("attaching clean FacrUsuario instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}
package co.com.fc.bd.model;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

import co.com.fc.bd.config.oracle.BaseHibernateDAO;

/**
 	* A data access object (DAO) providing persistence and search support for FacrInmuebleGarantia entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see co.com.fc.bd.model.FacrInmuebleGarantia
  * @author MyEclipse Persistence Tools 
 */

public class FacrInmuebleGarantiaDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(FacrInmuebleGarantiaDAO.class);
	//property constants
	public static final String TIPO_INMUEBLE = "tipoInmueble";
	public static final String VALOR_COMERCIAL = "valorComercial";
	public static final String REGISTRO_ESCRITURAS = "registroEscrituras";



    
    public void save(FacrInmuebleGarantia transientInstance) {
        log.debug("saving FacrInmuebleGarantia instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(FacrInmuebleGarantia persistentInstance) {
        log.debug("deleting FacrInmuebleGarantia instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public FacrInmuebleGarantia findById( java.lang.Long id) {
        log.debug("getting FacrInmuebleGarantia instance with id: " + id);
        try {
            FacrInmuebleGarantia instance = (FacrInmuebleGarantia) getSession()
                    .get("co.com.fc.bd.model.FacrInmuebleGarantia", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(FacrInmuebleGarantia instance) {
        log.debug("finding FacrInmuebleGarantia instance by example");
        try {
            List results = getSession()
                    .createCriteria("co.com.fc.bd.model.FacrInmuebleGarantia")
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
      log.debug("finding FacrInmuebleGarantia instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from FacrInmuebleGarantia as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByTipoInmueble(Object tipoInmueble
	) {
		return findByProperty(TIPO_INMUEBLE, tipoInmueble
		);
	}
	
	public List findByValorComercial(Object valorComercial
	) {
		return findByProperty(VALOR_COMERCIAL, valorComercial
		);
	}
	
	public List findByRegistroEscrituras(Object registroEscrituras
	) {
		return findByProperty(REGISTRO_ESCRITURAS, registroEscrituras
		);
	}
	

	public List findAll() {
		log.debug("finding all FacrInmuebleGarantia instances");
		try {
			String queryString = "from FacrInmuebleGarantia";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public FacrInmuebleGarantia merge(FacrInmuebleGarantia detachedInstance) {
        log.debug("merging FacrInmuebleGarantia instance");
        try {
            FacrInmuebleGarantia result = (FacrInmuebleGarantia) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(FacrInmuebleGarantia instance) {
        log.debug("attaching dirty FacrInmuebleGarantia instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(FacrInmuebleGarantia instance) {
        log.debug("attaching clean FacrInmuebleGarantia instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}
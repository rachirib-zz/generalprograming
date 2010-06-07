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
 	* A data access object (DAO) providing persistence and search support for FacrSolicitante entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see co.com.fc.bd.model.FacrSolicitante
  * @author MyEclipse Persistence Tools 
 */

public class FacrSolicitanteDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(FacrSolicitanteDAO.class);
	//property constants
	public static final String TIPO_ID = "tipoId";
	public static final String NOMBRE_SOLICITANTE = "nombreSolicitante";
	public static final String INGRESOS = "ingresos";
	public static final String EGRESOS = "egresos";
	public static final String TIPO_SOLICITANTE = "tipoSolicitante";
	public static final String TIPO_CONTRATO = "tipoContrato";
	public static final String TIEMPO_FUNCIONAMIENTO = "tiempoFuncionamiento";
	public static final String DIRECCION = "direccion";
	public static final String TELEFONO_CONTACTO = "telefonoContacto";
	public static final String TELEFONO_RESIDENCIA = "telefonoResidencia";
	public static final String NUM_PERSONAS_MENORES = "numPersonasMenores";
	public static final String NUM_PERSONAS_MAYORES = "numPersonasMayores";
	public static final String CALIFICACION = "calificacion";



    
    public void save(FacrSolicitante transientInstance) {
        log.debug("saving FacrSolicitante instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(FacrSolicitante persistentInstance) {
        log.debug("deleting FacrSolicitante instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public FacrSolicitante findById( java.lang.String id) {
        log.debug("getting FacrSolicitante instance with id: " + id);
        try {
            FacrSolicitante instance = (FacrSolicitante) getSession()
                    .get("co.com.fc.bd.model.FacrSolicitante", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(FacrSolicitante instance) {
        log.debug("finding FacrSolicitante instance by example");
        try {
            List results = getSession()
                    .createCriteria("co.com.fc.bd.model.FacrSolicitante")
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
      log.debug("finding FacrSolicitante instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from FacrSolicitante as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByTipoId(Object tipoId
	) {
		return findByProperty(TIPO_ID, tipoId
		);
	}
	
	public List findByNombreSolicitante(Object nombreSolicitante
	) {
		return findByProperty(NOMBRE_SOLICITANTE, nombreSolicitante
		);
	}
	
	public List findByIngresos(Object ingresos
	) {
		return findByProperty(INGRESOS, ingresos
		);
	}
	
	public List findByEgresos(Object egresos
	) {
		return findByProperty(EGRESOS, egresos
		);
	}
	
	public List findByTipoSolicitante(Object tipoSolicitante
	) {
		return findByProperty(TIPO_SOLICITANTE, tipoSolicitante
		);
	}
	
	public List findByTipoContrato(Object tipoContrato
	) {
		return findByProperty(TIPO_CONTRATO, tipoContrato
		);
	}
	
	public List findByTiempoFuncionamiento(Object tiempoFuncionamiento
	) {
		return findByProperty(TIEMPO_FUNCIONAMIENTO, tiempoFuncionamiento
		);
	}
	
	public List findByDireccion(Object direccion
	) {
		return findByProperty(DIRECCION, direccion
		);
	}
	
	public List findByTelefonoContacto(Object telefonoContacto
	) {
		return findByProperty(TELEFONO_CONTACTO, telefonoContacto
		);
	}
	
	public List findByTelefonoResidencia(Object telefonoResidencia
	) {
		return findByProperty(TELEFONO_RESIDENCIA, telefonoResidencia
		);
	}
	
	public List findByNumPersonasMenores(Object numPersonasMenores
	) {
		return findByProperty(NUM_PERSONAS_MENORES, numPersonasMenores
		);
	}
	
	public List findByNumPersonasMayores(Object numPersonasMayores
	) {
		return findByProperty(NUM_PERSONAS_MAYORES, numPersonasMayores
		);
	}
	
	public List findByCalificacion(Object calificacion
	) {
		return findByProperty(CALIFICACION, calificacion
		);
	}
	

	public List findAll() {
		log.debug("finding all FacrSolicitante instances");
		try {
			String queryString = "from FacrSolicitante";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public FacrSolicitante merge(FacrSolicitante detachedInstance) {
        log.debug("merging FacrSolicitante instance");
        try {
            FacrSolicitante result = (FacrSolicitante) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(FacrSolicitante instance) {
        log.debug("attaching dirty FacrSolicitante instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(FacrSolicitante instance) {
        log.debug("attaching clean FacrSolicitante instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}
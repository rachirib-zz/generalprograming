package co.com.fc.bd.logic;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import co.com.fc.bd.config.oracle.HibernateSessionFactoryOracle;
import co.com.fc.bd.model.Localizacion;

public class LocalizacionLogica {

	public List<Localizacion> findByNivel(Long nivel) throws Exception{
		
		Criteria criteria = HibernateSessionFactoryOracle.getSession().createCriteria(Localizacion.class);
		
		criteria.add(Restrictions.eq("nivel", nivel));
		
		List<Localizacion> lasLocalizaciones = (List<Localizacion>)criteria.list();
		
		return lasLocalizaciones;
		
	}
	
}

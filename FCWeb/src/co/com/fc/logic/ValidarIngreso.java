package co.com.fc.logic;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transaction.JBossTransactionManagerLookup;
import org.jbpm.JbpmContext;
import org.jbpm.identity.User;
import org.jbpm.identity.hibernate.IdentitySession;

import co.com.fc.bd.config.oracle.HibernateSessionFactoryOracle;
import co.com.fc.bd.model.FacrUsuario;
import co.com.fc.bd.model.FacrUsuarioDAO;
import co.com.motor.bpm.utils.LogicaFlujo;

public class ValidarIngreso {

	private static ValidarIngreso validarIngreso = null;

	private ValidarIngreso() {

	}

	public static ValidarIngreso getInstance() {
		if (validarIngreso == null)
			validarIngreso = new ValidarIngreso();
		return validarIngreso;
	}

	public void validarUsuario(String userId, String password) throws Exception {
		FacrUsuario user = null;
		try {
			// TODO findByUserPass
			user = findbyUserPass(userId, password);
			if (user == null) {
				throw new Exception(
						"[No se ha encontrado un usuario con esa identificación ..]");
			}

		} catch (Exception ex) {
			throw new Exception(ex.getMessage());
		} finally {
			user = null;
		}
	}

	public FacrUsuario findbyUserPass(String userId, String password)
			throws Exception {
		Criteria criteria = HibernateSessionFactoryOracle.getSession()
				.createCriteria(FacrUsuario.class);

		criteria.add(Restrictions.eq("username", userId));
		criteria.add(Restrictions.eq("password", password));

		List<FacrUsuario> list = criteria.list();

		if (list.isEmpty()) {
			return null;
		} else
			return list.get(0);

	}

}

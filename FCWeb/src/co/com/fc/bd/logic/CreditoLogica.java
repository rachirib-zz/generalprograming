package co.com.fc.bd.logic;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import co.com.fc.bd.config.oracle.HibernateSessionFactoryOracle;
import co.com.fc.bd.model.FacrCredito;
import co.com.fc.bd.model.FacrCreditoDAO;
import co.com.fc.rules.delegado.DelegadoAporbacionRules;
import co.com.fc.rules.dto.AprobacionCreditoDTO;

public class CreditoLogica {

	private FacrCreditoDAO creditoDAO = new FacrCreditoDAO();
	
	public Long save(FacrCredito credito) throws Exception{
		Transaction transaction = null;
		try {
			
			transaction = HibernateSessionFactoryOracle.getSession().beginTransaction();
			
			DelegadoAporbacionRules aporbacionRules = new DelegadoAporbacionRules();
			
			AprobacionCreditoDTO creditoDTO = new AprobacionCreditoDTO();
			creditoDTO.setAcierta(credito.getFacrSolicitante().getCalificacion());
			creditoDTO.setEdad(credito.getFacrSolicitante().getEdad());
			creditoDTO.setEstadoCivil(credito.getFacrSolicitante().getEstadoCivil());
			Long estado = aporbacionRules.aprobacionCredito(creditoDTO);
			if (estado == null) {
				throw new Exception("No hay reglas que soporten la expresion");
			}
			credito.setEstadoCredito(estado);
			
			creditoDAO.save(credito);
			
			transaction.commit();
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw e;
		}
		return credito.getEstadoCredito();
	}
	
	public List<FacrCredito> findBySolicitante(String numId)throws Exception{
			
			Criteria criteria = HibernateSessionFactoryOracle.getSession().createCriteria(FacrCredito.class);
			
			criteria.add(Restrictions.eq("facrSolicitante.numId", numId));
			
			List<FacrCredito> losCreditos = (List<FacrCredito>)criteria.list();
			
			return losCreditos;
			
	}
	
}

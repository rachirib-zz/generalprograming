package co.com.fc.bd.facade;

import java.util.List;

import co.com.fc.bd.logic.CreditoLogica;
import co.com.fc.bd.model.FacrCredito;

public class CreditoFacade {

	private CreditoLogica creditoLogica = new CreditoLogica();
	
	public Long save(FacrCredito credito) throws Exception{
		return creditoLogica.save(credito);
	}
	
	public List<FacrCredito> findBySolicitante(String numId)throws Exception{
		return creditoLogica.findBySolicitante(numId);
	}
}

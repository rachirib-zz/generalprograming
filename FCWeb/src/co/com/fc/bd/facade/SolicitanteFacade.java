package co.com.fc.bd.facade;

import co.com.fc.bd.logic.SolicitanteLogica;
import co.com.fc.bd.model.FacrSolicitante;

public class SolicitanteFacade {

	private SolicitanteLogica solicitanteLogica = new SolicitanteLogica();
	
	public void saveOrUpdate(FacrSolicitante solicitante) throws Exception{
		solicitanteLogica.saveOrUpdate(solicitante);
	}
	
	public FacrSolicitante findByIdentificacion(String numId) throws Exception{
		return solicitanteLogica.findByIdentificacion(numId);
	}
	
}

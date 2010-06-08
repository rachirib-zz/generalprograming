package co.com.fc.bd.facade;

import java.util.List;

import co.com.fc.bd.logic.ReferenciasLogica;
import co.com.fc.bd.model.FacrReferencias;

public class ReferenciasFacade {
	
	private ReferenciasLogica referenciasLogica = new ReferenciasLogica();

	public List<FacrReferencias> findBySolicitante(String numId) throws Exception{
		return referenciasLogica.findBySolicitante(numId);
	}
	
	public FacrReferencias findById(Long consReferencias) throws Exception{
		return referenciasLogica.findById(consReferencias);
	}
	
	public FacrReferencias findByIdentificacion(String numId) throws Exception{
		return referenciasLogica.findByIdentificacion(numId);
	}
	
	public void save(FacrReferencias referencias) throws Exception{
		referenciasLogica.save(referencias);
	}
	
}

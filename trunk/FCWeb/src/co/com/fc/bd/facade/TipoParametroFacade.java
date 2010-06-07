package co.com.fc.bd.facade;

import java.util.List;

import co.com.fc.bd.logic.TipoParametroLogica;
import co.com.fc.bd.model.FacrPTipoParametro;

public class TipoParametroFacade {
	
	private TipoParametroLogica tipoParametroLogica = new TipoParametroLogica();
	
	public void save(FacrPTipoParametro tipoParametro) throws Exception{
		tipoParametroLogica.save(tipoParametro);
	}
	
	public List<FacrPTipoParametro> findAll() throws Exception{
		return tipoParametroLogica.findAll();
	}
	
	public FacrPTipoParametro findById(Long id) throws Exception{
		return tipoParametroLogica.findById(id);
	}
	
}

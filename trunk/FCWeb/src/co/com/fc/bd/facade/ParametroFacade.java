package co.com.fc.bd.facade;

import java.util.List;

import co.com.fc.bd.logic.ParametroLogica;
import co.com.fc.bd.model.FacrPParametro;


public class ParametroFacade {

private ParametroLogica parametroLogica = new ParametroLogica();
	
	public void save(FacrPParametro parametro) throws Exception{
		parametroLogica.save(parametro);
	}
	
	public List<FacrPParametro> findAll() throws Exception{
		return parametroLogica.findAll();
	}
	
	public FacrPParametro findById(Long id) throws Exception{
		return parametroLogica.findById(id);
	}
	
	public List<FacrPParametro> findByTipoParametro(Long codTipoParametro) throws Exception{
		return parametroLogica.findByTipoParametro(codTipoParametro);
	}
	
}

package co.com.fc.bd.facade;

import co.com.fc.bd.logic.TipoParametroLogica;
import co.com.fc.bd.model.FacrPTipoParametro;

public class TipoParametroFacade {
	
	private TipoParametroLogica tipoParametroLogica = new TipoParametroLogica();
	
	public void save(FacrPTipoParametro tipoParametro) throws Exception{
		tipoParametroLogica.save(tipoParametro);
	}
	
}

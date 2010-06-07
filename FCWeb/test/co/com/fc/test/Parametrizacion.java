package co.com.fc.test;

import co.com.fc.bd.facade.TipoParametroFacade;
import co.com.fc.bd.model.FacrPTipoParametro;

public class Parametrizacion {

	
	public static void main(String[] args) {
		tipoParametro();
	}
	
	public static void tipoParametro(){
		
		try {
			FacrPTipoParametro tipoParametro = new FacrPTipoParametro();
			TipoParametroFacade parametroFacade = new TipoParametroFacade();
			tipoParametro.setValor("Tipo Documentos");
			tipoParametro.setDescripcion("Tipo Documentos");
			parametroFacade.save(tipoParametro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

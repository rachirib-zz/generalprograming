package co.com.fc.test;

import co.com.fc.bd.facade.ParametroFacade;
import co.com.fc.bd.facade.TipoParametroFacade;
import co.com.fc.bd.model.FacrPParametro;
import co.com.fc.bd.model.FacrPTipoParametro;

public class Parametrizacion {

	
	public static void main(String[] args) {
//		tipoParametro();
		parametros();
	}
	
	public static void tipoParametro(){
		
		try {
			FacrPTipoParametro tipoParametro = new FacrPTipoParametro();
			TipoParametroFacade parametroFacade = new TipoParametroFacade();
			tipoParametro.setValor("Tipos Referencias");
			tipoParametro.setDescripcion("Tipos Referencias");
			parametroFacade.save(tipoParametro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void parametros(){
		try {
			FacrPParametro parametro = new FacrPParametro();
			ParametroFacade parametroFacade = new ParametroFacade();
			FacrPTipoParametro facrPTipoParametro = new FacrPTipoParametro();
			facrPTipoParametro.setConsTipoParametro(26L);
			parametro.setValor("Negado a revision");
			parametro.setDescripcion("Negado a revision");
			parametro.setFacrPTipoParametro(facrPTipoParametro);
			parametroFacade.save(parametro);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

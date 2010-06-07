package co.com.fc.test;
import java.util.List;

import co.com.fc.bd.facade.ParametroFacade;
import co.com.fc.bd.model.FacrPParametro;
import co.com.fc.bd.model.FacrUsuario;
import co.com.fc.bd.model.FacrUsuarioDAO;
import junit.framework.TestCase;


public class TestConexionMain{
	
	
	public static void main(String[] args) {
		TestBusquedaId();
	}
	
	private static void TestBusquedaId() {
		ParametroFacade facade = new ParametroFacade();
		try {
			
			List<FacrPParametro> parametros = facade.findByTipoParametro(26L);
			
			if (parametros != null) {
				for (FacrPParametro facrPParametro : parametros) {
					System.out.println(facrPParametro.getConsParamtro());
					System.out.println(facrPParametro.getDescripcion());
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}

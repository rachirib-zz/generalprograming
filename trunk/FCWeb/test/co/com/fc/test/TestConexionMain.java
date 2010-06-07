package co.com.fc.test;
import co.com.fc.bd.model.FacrUsuario;
import co.com.fc.bd.model.FacrUsuarioDAO;
import junit.framework.TestCase;


public class TestConexionMain{
	
	
	public static void main(String[] args) {
		TestBusquedaId();
	}
	
	private static void TestBusquedaId() {
		FacrUsuarioDAO facrUsuarioDAO = new FacrUsuarioDAO();
		FacrUsuario facrUsuario = facrUsuarioDAO.findById(1l);
		
	}
}

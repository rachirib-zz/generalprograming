package co.com.fc.test;
import co.com.fc.bd.model.FacrUsuario;
import co.com.fc.bd.model.FacrUsuarioDAO;
import junit.framework.TestCase;


public class TestConexion extends TestCase {
	
	public void TestBusquedaId() {
		FacrUsuarioDAO facrUsuarioDAO = new FacrUsuarioDAO();
		FacrUsuario facrUsuario = facrUsuarioDAO.findById(1l);
		
		assertNotNull(facrUsuario);
	}
}

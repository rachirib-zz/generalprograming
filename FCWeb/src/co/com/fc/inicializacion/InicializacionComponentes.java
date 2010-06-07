package co.com.fc.inicializacion;

/**
 * Esta  clase inicializa la conexión con la base de datos en el momento
 * en que se suba el servidor de aplicaciones.
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import co.com.fc.bd.config.oracle.HibernateSessionFactoryOracle;
import co.com.fc.bd.config.postgres.HibernateSessionFactoryPostgres;


public class InicializacionComponentes extends HttpServlet {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public InicializacionComponentes() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occure
	 */
	public void init() throws ServletException 
	{
		System.out.println("##########################################################");
		System.out.println("         INICIALIZANDO COMPONENTES");
		System.out.println("##########################################################");
		System.out.println("         [INICIALIZANDO SESSION DE BD FACR....]");
		Session session = HibernateSessionFactoryOracle.getSession();
//		Session sessionBPM = HibernateSessionFactoryPostgres.getSession();
		System.out.println("############################################################");
		System.out.println("         COMPONENTES INCIALIZADOS CORRECTAMENTE");
		System.out.println("############################################################");		
	}
}

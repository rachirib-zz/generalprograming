package co.com.fc.handler;

import org.jbpm.graph.def.ActionHandler;
import org.jbpm.graph.exe.ExecutionContext;

public class MatricularSolicitudHandler implements ActionHandler{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2738520208671158449L;

	@Override
	public void execute(ExecutionContext context) throws Exception {
		context.setVariable("actorDigitalizacion", "usuario2");
		
	}

}

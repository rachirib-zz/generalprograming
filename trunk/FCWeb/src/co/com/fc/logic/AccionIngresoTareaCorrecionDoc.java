package co.com.fc.logic;

import org.jbpm.graph.def.ActionHandler;
import org.jbpm.graph.exe.ExecutionContext;

public class AccionIngresoTareaCorrecionDoc implements ActionHandler{

	public void execute(ExecutionContext executionContext) throws Exception {
		System.out.println("###### INGRESANDO EN TAREA CORRECCION DOCUMENTOS #####");
	}

}

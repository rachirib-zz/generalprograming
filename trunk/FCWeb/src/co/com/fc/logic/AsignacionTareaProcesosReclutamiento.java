package co.com.fc.logic;


import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.jbpm.graph.exe.ExecutionContext;
import org.jbpm.identity.Membership;
import org.jbpm.identity.User;
import org.jbpm.identity.hibernate.IdentitySession;
import org.jbpm.taskmgmt.def.AssignmentHandler;
import org.jbpm.taskmgmt.exe.Assignable;

public class AsignacionTareaProcesosReclutamiento implements AssignmentHandler {

	public void assign(Assignable assignable, ExecutionContext executionContext)
			throws Exception {
		
		//String[] userId = (String[]) executionContext.getVariable("actorAssigment");
		System.out.println("############ ASIGNANDO TAREA DE PROCESOS RECLUTAMIENTO ####");
		String docOk = (String)executionContext.getVariable("documentos_ok");
		assignable.setActorId("andres");
		//asignaaci�n a un usuario
		//	assignable.setActorId(userId[0]);
		//asignaci�n a un grupo de usuaerios
		//assignable.setPooledActors(userId);
	}

}

package co.com.motor.bpm.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.jbpm.JbpmConfiguration;
import org.jbpm.JbpmContext;
import org.jbpm.db.GraphSession;
import org.jbpm.graph.def.ProcessDefinition;
import org.jbpm.graph.exe.ProcessInstance;
import org.jbpm.identity.hibernate.IdentitySession;
import org.jbpm.taskmgmt.exe.TaskInstance;

public class LogicaFlujo {
	private static LogicaFlujo logicaFlujo = null;
	
	private LogicaFlujo(){
		
	}
	
	public static LogicaFlujo getInstance(){
		if(logicaFlujo == null)
			logicaFlujo = new LogicaFlujo();
		return logicaFlujo;
	}
	
	public JbpmContext creaContextPersistencia()throws Exception{
		
		JbpmConfiguration jbpmConfiguration = JbpmConfiguration.getInstance();
		JbpmContext jbpmContext = jbpmConfiguration.createJbpmContext();
		
		if(jbpmContext == null)
			throw new Exception("[ Error - No se pudo crear el contexto de persistencia]");
		
		return jbpmContext;
	}
	
	/**
	 * Crea una instancia de proceso
	 * @param jbpmContext
	 * @return
	 * @throws Exception 
	 */
	public void creaInstanciaProceso(String nombreProceso,String idUser,HashMap params) throws Exception{
		JbpmContext jbpmContext =  creaContextPersistencia();
		ProcessInstance processInstance  = null;
		if(jbpmContext!=null){
			GraphSession graphSession = jbpmContext.getGraphSession();
			if(graphSession!=null){
				//recupera la última versión del proceso especificado
				ProcessDefinition processDefinition = graphSession.findLatestProcessDefinition(nombreProceso);
				System.out.println("[versión de proceso ejecutandose] :"+processDefinition.getVersion());
				//crea la instancia del proceso para la definicón de proceso especificada.
				processInstance = new ProcessInstance(processDefinition);
				//crea la tarea inicial del proceso.
				//asignandola al usuario ingresado por parámetro
				jbpmContext.setActorId(idUser);
				TaskInstance taskInstance =  processInstance.getTaskMgmtInstance().createStartTaskInstance();
				
				if(taskInstance!=null){
					//recorre el mapa de variables para asignarlas
					//como variables de proceso.
					//setea las variables del proceso
					setProcessVariables(params, processInstance);
					try {
						taskInstance.start();
						taskInstance.end();
						jbpmContext.save(processInstance);
						
					} catch (Exception e) {
						System.out.println("Exception ex :"+e.getMessage());
					}finally{
						if(jbpmContext!=null)
							jbpmContext.close();
					}
					
					
				}//fin if
			}//fin if
		}//fin if
	}
	
	/**
	 *  Continua la ejecución de una instancia de proceso.
	 * @param jbpmContext
	 * @return
	 */
	public void terminarInstanciaTarea(TaskInstance taskInstance){
		
		taskInstance.end();
		
	}
	
	/**
	 *  Continua la ejecución de una instancia de proceso.
	 * @param jbpmContext
	 * @return
	 */
	public void terminarInstanciaTarea(TaskInstance taskInstance,String transitionName){
		
		taskInstance.end(transitionName);
		
	}
	
	public void setProcessVariables(HashMap params,ProcessInstance processInstance){
		if(params!=null){
			Set mapaParametros = params.keySet();
			for (Iterator iterator = mapaParametros.iterator(); iterator
				.hasNext();) {
				String nombreVaribale = (String) iterator.next();
				//setea variables de proceso
				processInstance.getContextInstance().setVariable(nombreVaribale, params.get(nombreVaribale));
			}//fin for
		}//fin if
	}

}

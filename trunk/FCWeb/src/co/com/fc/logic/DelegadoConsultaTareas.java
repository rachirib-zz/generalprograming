package co.com.fc.logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.jbpm.JbpmContext;
import org.jbpm.db.GraphSession;
import org.jbpm.db.TaskMgmtSession;
import org.jbpm.graph.def.ProcessDefinition;
import org.jbpm.graph.exe.ProcessInstance;
import org.jbpm.taskmgmt.exe.TaskInstance;

import co.com.fc.model.TaskVo;
import co.com.motor.bpm.utils.DateManipultate;
import co.com.motor.bpm.utils.LogicaFlujo;

/**
 * Esta clase contempla servicios a manera de demostración
 * sobre la utilización del API JBPM, se proporcionan  métodos
 * para la consulta de tareas pendientes en un proceso.
 * @author Giovanni Arzayus.
 *
 */

public class DelegadoConsultaTareas {
	private static DelegadoConsultaTareas delegadoConsultaTareas;
	
	private DelegadoConsultaTareas(){
		
	}
	
	public static DelegadoConsultaTareas getInstance(){
		if(delegadoConsultaTareas == null)
			delegadoConsultaTareas = new DelegadoConsultaTareas();
		
		return delegadoConsultaTareas;
	}
	
	/**
	 * Crea la instancia de proceso
	 * @param idUser
	 * @throws Exception
	 */
	public void creaInstanciaProceso(String idUser,HashMap params,String nombreProceso) throws Exception{
		LogicaFlujo logicaFlujo = LogicaFlujo.getInstance();
		//al crear la instancia de proceso debe especificarse el 
		//nombre del proceso.
		logicaFlujo.creaInstanciaProceso(nombreProceso,idUser,params);
	}
	
	
	/**
	 * Consulta las tareas pendientes de un usuario para un proceso
	 * de negocio determinado.
	 * @param idUser
	 * @return
	 * @throws Exception
	 */
	public List<TaskVo> consultaTareasPendientesUsuario(String idUser,String  nombreProceso) throws Exception{
		
		List<TaskVo> listaTareas = null;
		LogicaFlujo logicaFlujo = LogicaFlujo.getInstance();
		//1.crea el contexto de persitencia para poder
		//  realizar consultas a la bd.
		JbpmContext jbpmContext =  logicaFlujo.creaContextPersistencia();
		//2.Obtiene el objeto GraphSession para manipular el proceso
		//  almacenado en la bd.
		GraphSession graphSession = jbpmContext.getGraphSession();
		if(graphSession == null)
			throw new Exception("[Error - No se pudo obtener el objeto de sesión gráfica de proceso ..]");

		//3. Obtiene la última definición de proceso que se haya almacenado
		//   en la base de datos
		ProcessDefinition processDefinition = graphSession.findLatestProcessDefinition(nombreProceso);
		
		if(processDefinition == null)
			throw new Exception("[No se ha encontrado ningún proceso de negocio en el motor de procesos ..]");
		
		String[] taskUser = new String[1];
		taskUser[0] = idUser;
		
		
		
		//4. crea la instancia del proceso para la definicón de proceso especificada.
		//ProcessInstance processInstance  =  new ProcessInstance(processDefinition);
		//5. Obtiene el objeto TaskMgmtSession que permite consultar las 
		//   tareas pendientes para un usuario determinado, en este caso el que 
		//   se logue en la aplicación.
		TaskMgmtSession taskMgmtSession = jbpmContext.getTaskMgmtSession();
		List taskByUser = taskMgmtSession.findTaskInstances(taskUser[0]);
		
//		taskMgmtSession.findTaskInstances(
		
		if(taskByUser == null || taskByUser.size() == 0)
			throw new Exception("[No se han econtrado tareas pendientes ..]");
		else
			listaTareas = new ArrayList<TaskVo>();
		
		for (Iterator iterator = taskByUser.iterator(); iterator.hasNext();) {
			TaskInstance taskInstance = (TaskInstance) iterator.next();
			//solo consulta las que no esten bloqueadas y que esten pendientes
			if(taskInstance!=null && !taskInstance.isBlocking()){
				TaskVo taskVo =  new TaskVo();
				//asigna el nombre de la tarea
				taskVo.setTaskName(taskInstance.getName());
				String fechaCreacionTarea = DateManipultate.dateToStringConFormato(taskInstance.getCreate(), "dd/MM/yyyy");
				//asigna la fecha de creación de la tarea
				taskVo.setCreateDate(fechaCreacionTarea);
				//asigna el consecutivo de la instancia del proceso
				taskVo.setProcessId(String.valueOf(taskInstance.getToken().getProcessInstance().getId()));
				Date fechaActual = new Date();
				//6. calcula el número de días transcurridos entre la fecha
				//   actual y la fecha de creación de cada tarea consultada.
	    		String diasProceso = String.valueOf(DateManipultate.calculaTiempoTranascurridoDias(fechaActual,taskInstance.getCreate())); 
				
				taskVo.setNumberProcessDays(diasProceso); 
				//obtiene el id del cliente del contexto del proceso
				
				String customerId = "";
				
				try{
					customerId = (String) taskInstance.getToken().getProcessInstance().getContextInstance().getVariable("identificacion");
				}catch(Exception ex){
					
				}
				
				String customerName = (String) taskInstance.getToken().getProcessInstance().getContextInstance().getVariable("nombreCliente");

				//obtiene el nombre del cliente del contexto del proceso.
//				taskVo.setCustumerName(customerName!=null?customerName:"- sin valor -");
				taskVo.setTaskId(String.valueOf(taskInstance.getId()));
				
				listaTareas.add(taskVo);
				
			}//fin if
			
			
			
		}//fin for
			
		jbpmContext.close();
		
		return listaTareas;
	}
	
	/**
	 * Consulta una instancia de tarea basandose en un id de proceso
	 * y el id de la instancia de tarea.
	 * @param processId
	 * @param taskId
	 * @return
	 * @throws Exception 
	 */
	public TaskVo consultaTareaProceso(String taskId) throws Exception{
		TaskVo taskVo = null;
		LogicaFlujo logicaFlujo = LogicaFlujo.getInstance();
		//1.crea el contexto de persitencia para poder
		//  realizar consultas a la bd.
		JbpmContext jbpmContext =  logicaFlujo.creaContextPersistencia();
		
		
		TaskMgmtSession taskMgmtSession = jbpmContext.getTaskMgmtSession();
		 List tasksIdList = new ArrayList();
		 tasksIdList.add(new Long(taskId));
		 List taskFoundList = taskMgmtSession.findTaskInstancesByIds(tasksIdList);
		 if(taskFoundList!=null && taskFoundList.size()>0){
			 TaskInstance taskInstance = (TaskInstance) taskFoundList.get(0);
			 
				if(taskInstance!=null){
					taskVo =  new TaskVo();
					//asigna el nombre de la tarea
					taskVo.setTaskName(taskInstance.getName());
					String fechaCreacionTarea = DateManipultate.dateToStringConFormato(taskInstance.getCreate(), "dd/MM/yyyy");
					//asigna la fecha de creación de la tarea
					taskVo.setCreateDate(fechaCreacionTarea);
					//asigna el consecutivo de la instancia del proceso
					taskVo.setProcessId(String.valueOf(taskInstance.getToken().getProcessInstance().getId()));
					Date fechaActual = new Date();
					//6. calcula el número de días transcurridos entre la fecha
					//   actual y la fecha de creación de cada tarea consultada.
		    		String diasProceso = String.valueOf(DateManipultate.calculaTiempoTranascurridoDias(fechaActual,taskInstance.getCreate())); 
					
					taskVo.setNumberProcessDays(diasProceso); 
					//obtiene el id del cliente del contexto del proceso
					
					String customerId = (String) taskInstance.getToken().getProcessInstance().getContextInstance().getVariable("identificacion");
					String customerName = (String) taskInstance.getToken().getProcessInstance().getContextInstance().getVariable("nombreCliente");
					String observaciones = (String) taskInstance.getToken().getProcessInstance().getContextInstance().getVariable("observaciones");
					String nombreCargo = (String) taskInstance.getToken().getProcessInstance().getContextInstance().getVariable("nombreCargo");
					

					//obtiene el nombre del cliente del contexto del proceso.
//					taskVo.setCustumerName(customerName!=null?customerName:"- sin valor -");
					taskVo.setTaskId(String.valueOf(taskInstance.getId()));
					
					
				}//fin if
		 }//fin if
		 
		 //evita memory leaks
		 tasksIdList.remove(0);
		 tasksIdList = null;
		 jbpmContext.close();
		
		return taskVo;
		
	}
	
	/**
	 * Gestionar la tarea de un usuario determinado.
	 * y el id de la instancia de tarea.
	 * @param processId
	 * @param taskId
	 * @return
	 * @throws Exception 
	 */
	public TaskVo gestionarTareaUsuaro(String taskId,HashMap params) throws Exception{
		TaskVo taskVo = null;
		LogicaFlujo logicaFlujo = LogicaFlujo.getInstance();
		//1.crea el contexto de persitencia para poder
		//  realizar consultas a la bd.
		JbpmContext jbpmContext =  logicaFlujo.creaContextPersistencia();
		
		
		TaskMgmtSession taskMgmtSession = jbpmContext.getTaskMgmtSession();
		 List tasksIdList = new ArrayList();
		 tasksIdList.add(new Long(taskId));
		 List taskFoundList = taskMgmtSession.findTaskInstancesByIds(tasksIdList);
		 if(taskFoundList!=null && taskFoundList.size()>0){
			 TaskInstance taskInstance = (TaskInstance) taskFoundList.get(0);
			 //setea las variables del proceso.
			 logicaFlujo.setProcessVariables(params, taskInstance.getToken().getProcessInstance());
			 /*if(valorSolicitudCredito!=null)
				 taskInstance.getToken().getProcessInstance().getContextInstance().setVariable("valor_solicitud", valorSolicitudCredito);
			 */
				if(taskInstance!=null){
					logicaFlujo.terminarInstanciaTarea(taskInstance);
					jbpmContext.save(taskInstance);
				}//fin if
		 }//fin if
		 
		 
		 
		 //evita memory leaks
		 tasksIdList.remove(0);
		 tasksIdList = null;
		 jbpmContext.close();
		
		return taskVo;
		
	}
	
}

package co.com.fc.view;

import java.util.HashMap;


import co.com.faces.utils.FacesUtils;
import co.com.fc.logic.DelegadoConsultaTareas;
import co.com.fc.model.TaskVo;
import co.com.fc.view.Ingreso;

public class SolicitudPersonal {
	//variables de la solicitud de personal
	// son los que se toman desde la pantalla
	private String identificacionCliente;
	private String nombreCliente;
	private String nombreCargo;
	private String taskId;
	private String observaciones;
	private String bitacoraObservaciones;

	public String getBitacoraObservaciones() {
		return bitacoraObservaciones;
	}

	public void setBitacoraObservaciones(String bitacoraObservaciones) {
		this.bitacoraObservaciones = bitacoraObservaciones;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public SolicitudPersonal(){
		incializaBean();
	}
	
	public String getIdentificacionCliente() {
		return identificacionCliente;
	}

	public void setIdentificacionCliente(String identificacionCliente) {
		this.identificacionCliente = identificacionCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	
	public void incializaBean(){
		String processId = (String)FacesUtils.getHttpSession(true).getAttribute("orderId");
		String taskId  = (String)FacesUtils.getHttpSession(true).getAttribute("taskId");
		DelegadoConsultaTareas delegadoConsultaTareas = DelegadoConsultaTareas.getInstance();
		try {
			TaskVo taskVo = null;
			if(processId!=null && taskId!=null ){
				taskVo = delegadoConsultaTareas.consultaTareaProceso(taskId);
				this.identificacionCliente = taskVo.getCustomerId();
				this.nombreCliente  = taskVo.getCustumerName();
				this.nombreCargo = taskVo.getNombreCargo();
				this.taskId = taskVo.getTaskId();
				this.bitacoraObservaciones = taskVo.getObservations();
			}//fin if
			else{
				this.identificacionCliente = null;
				this.nombreCliente  = null;
				this.nombreCargo = null;
			}
			//se marca objeto que no se usa mas
			taskVo = null;
			FacesUtils.getHttpSession(true).removeAttribute("orderId");
			FacesUtils.getHttpSession(true).removeAttribute("taskId");
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
		
	}
	
	
	/**
	 * Radica la solicitud de personal en el sistema, inicia el flujo
	 * del proceso.
	 */
	public String radicarSolicitudPersonal(){
		String gui="";
		DelegadoConsultaTareas delegadoConsultaTareas = DelegadoConsultaTareas.getInstance();
		try {
			HashMap<String,String> params = new HashMap<String,String>();
			Ingreso ingreso = (Ingreso) FacesUtils.getManagedBean("ingreso");
			//se registran variables de proceso
			//que fueron tomadas de la pantalla
			params.put("identificacion", this.identificacionCliente);
			params.put("nombreCliente", this.nombreCliente);
			params.put("nombreCargo", this.nombreCargo);
			params.put("observaciones", this.observaciones);
			//se crea la instancia de proceso.
			//esto inicia el flujo del proceso.
			String nombreProceso = "grh";
			// se especifica el login del usuario al que desea realizarse la asignación
			//en este caso se asigna la tarea a la misma persona que hace la radicació
			//de la solicitud, por eso se toma del login del usuario que ingreso al sistema.
			String asignarA = ingreso.getLogin();
			delegadoConsultaTareas.creaInstanciaProceso(asignarA,params,nombreProceso);
			FacesUtils.addInfoMessage("Se radicó la solicitud exitosamente");
			//se deja la pantalla en blanco nuevamente
			limpiar();
			
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
		return gui;
	}
	
	/**
	 * Borra el contenido de los campos en pantalla
	 */
	public String limpiar(){
		String gui="";
		this.nombreCargo = null;
		this.nombreCliente = null;
		this.identificacionCliente = null;
		this.observaciones = null;
		return gui;
	}

	public String getNombreCargo() {
		return nombreCargo;
	}

	public void setNombreCargo(String nombreCargo) {
		this.nombreCargo = nombreCargo;
	}
	
}


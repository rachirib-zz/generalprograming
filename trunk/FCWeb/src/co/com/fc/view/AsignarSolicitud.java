package co.com.fc.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import co.com.faces.utils.FacesUtils;
import co.com.fc.logic.DelegadoConsultaTareas;
import co.com.fc.model.TaskVo;

public class AsignarSolicitud {

	//variables de la solicitud de personal
	// son los que se toman desde la pantalla
	private String identificacionCliente;
	private String nombreCliente;
	private String nombreCargo;
	private String taskId;
	private String usuarioAsignado;
	private String observaciones;
	
	public AsignarSolicitud() {
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
	public String getNombreCargo() {
		return nombreCargo;
	}
	public void setNombreCargo(String nombreCargo) {
		this.nombreCargo = nombreCargo;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getUsuarioAsignado() {
		return usuarioAsignado;
	}
	public void setUsuarioAsignado(String usuarioAsignado) {
		this.usuarioAsignado = usuarioAsignado;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	public String asignar_solicitudes(){
		
		String gui = "bandeja_solicitudes";
		DelegadoConsultaTareas delegadoConsultaTareas = DelegadoConsultaTareas.getInstance();
		Ingreso ingreso = (Ingreso) FacesUtils.getManagedBean("ingreso");
		try {
			TaskVo taskVo = null;
			if(taskId!=null ){
				HashMap params = new HashMap();
				//se registran variables de proceso
				//que fueron tomadas de la pantalla
				params.put("observaciones", this.observaciones);
				params.put("usuario_asignado", this.usuarioAsignado);
				taskVo = delegadoConsultaTareas.gestionarTareaUsuaro(taskId,params);
				FacesUtils.addInfoMessage("Se asignó solicitud exitosamente");
			}//fin if
			else{
				this.identificacionCliente = null;
				this.nombreCliente  = null;
				this.nombreCargo = null;
				this.usuarioAsignado = null;
				gui = "";
				FacesUtils.addInfoMessage("No se pudo asignar la solicitud");
			}
			
			//se marca objeto que no se usa mas
			taskVo = null;
			FacesUtils.getHttpSession(true).removeAttribute("orderId");
			FacesUtils.getHttpSession(true).removeAttribute("taskId");
			List<TaskVo> listaTareasPendientes = new ArrayList<TaskVo>();
			try {
				listaTareasPendientes =  delegadoConsultaTareas.consultaTareasPendientesUsuario(ingreso.getLogin(),"grh");
				ingreso.setListaTareasPendientes(listaTareasPendientes);
			} catch (Exception e) {
				listaTareasPendientes = new ArrayList<TaskVo>();
				ingreso.setListaTareasPendientes(listaTareasPendientes);
				FacesUtils.setManagedBeanInSession("ingreso", ingreso);
				FacesUtils.addErrorMessage(e.getMessage());
			}
			
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
		return gui;
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
	
	public String limpiar(){
		String gui="";
		this.observaciones = null;
		this.usuarioAsignado = null;
		return gui;
	}
	
}

package co.com.fc.view;

import java.util.ArrayList;
import java.util.List;

import co.com.faces.utils.FacesUtils;
import co.com.fc.logic.DelegadoConsultaTareas;
import co.com.fc.logic.ValidarIngreso;
import co.com.fc.model.TaskVo;

public class Ingreso {
	private String login;
	private String password;
	
	List<TaskVo> listaTareasPendientes = new ArrayList<TaskVo>();

	public List<TaskVo> getListaTareasPendientes() {
		return listaTareasPendientes;
	}

	public void setListaTareasPendientes(List<TaskVo> listaTareasPendientes) {
		this.listaTareasPendientes = listaTareasPendientes;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String validarIngresoUsuario(){
		String gui = "bandeja_solicitudes";
		ValidarIngreso validarIngreso = ValidarIngreso.getInstance();
		FacesUtils.getHttpSession(true).removeAttribute("prefiltro");
		try{
			
			if(login!=null && !login.equals("") && 
			   password!=null && !password.equals(""))
				validarIngreso.validarUsuario(login,password);
			else
				throw new Exception("[Debe ingresar el usuario y la clave.. ]");
			
			//consulta las tareas pendientes del usuario logueado.
			DelegadoConsultaTareas delegadoConsultaTareas = DelegadoConsultaTareas.getInstance();
			//consulta las tareas pendientes de los usuarios para el proceso persistido en la bd.
			String nombreProceso = "FabricaCredito"; 
			try {
				listaTareasPendientes =  delegadoConsultaTareas.consultaTareasPendientesUsuario(login,nombreProceso);				
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

			
		}catch(Exception ex){
			gui = "";
			FacesUtils.addErrorMessage(ex.getMessage());
		}
		return gui;
	}
	
	public String volverABandejaSolicitudes(){
		String gui = "bandeja_solicitudes";
		
		FacesUtils.getHttpSession(true).removeAttribute("prefiltro");
		try{
			String nombreProceso = "FabricaCredito";
			DelegadoConsultaTareas delegadoConsultaTareas = DelegadoConsultaTareas.getInstance();
			listaTareasPendientes =  delegadoConsultaTareas.consultaTareasPendientesUsuario(login,nombreProceso);
			
		}catch(Exception ex){
			gui = "";
			FacesUtils.addErrorMessage(ex.getMessage());
		}
		return gui;
	}
	
	public String irARadicarSolicitudPersonal(){
		String gui = "solicitud_personal";
		FacesUtils.resetManagedBean("solicitudPersonal");
		return gui;
	}
	
	public String limpiarDatos(){
		String gui="";
		login = null;
		password = null;
		return gui;
	}
	
	public String salir(){
		String gui ="salir";
		FacesUtils.resetManagedBean("ingreso");
//		FacesUtils.resetManagedBean("solicitudPersonal");
		FacesUtils.getHttpSession(true).removeAttribute("orderId");
		FacesUtils.getHttpSession(true).removeAttribute("taskId");
		return gui;
	}
	
	public String verDetalleSolicitud(){
		String gui = "solicitud_credito";
//		FacesUtils.resetManagedBean("solicitudCredito");
		String processId = FacesUtils.getRequestParameter("orderId");
		String taskId  = FacesUtils.getRequestParameter("taskId");
		FacesUtils.getHttpSession(true).setAttribute("orderId", processId);
		FacesUtils.getHttpSession(true).setAttribute("taskId", taskId);
		gui = validaPantallaMostrar();
		
		return gui;
	}
	
	public String validaPantallaMostrar(){
		String gui = "";
		String taskName = FacesUtils.getRequestParameter("taskName");
		if(taskName!=null){
			//si la tarea seleccionada corresponde a verificacion de documentos
			//muestra la jsp asociada a esta actividad.
			if(taskName.indexOf("verificacion documentos")!=-1 || taskName.indexOf("correccion documentos")!=-1){
					gui = "verificacionDocumentos";
			}//fin if
			//aca se pueden validar el resto de las pantallas 
			//que dependiendo del proceso que se haya seleccionado
			//desde la bandeja de solicitudes deba llevarlo.
			if(taskName.indexOf("asignar procesos reclutamiento")!=-1 ){
				gui = "asignarSolicitud";
			}
			
		}//fin if
		return gui;
	}
	
	
}

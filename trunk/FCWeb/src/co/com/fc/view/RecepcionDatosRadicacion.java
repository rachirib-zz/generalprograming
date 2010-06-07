package co.com.fc.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.faces.model.SelectItem;


import co.com.faces.utils.FacesUtils;
import co.com.fc.bd.facade.LocalizacionFacade;
import co.com.fc.bd.facade.ParametroFacade;
import co.com.fc.bd.model.FacrPParametro;
import co.com.fc.bd.model.Localizacion;
import co.com.fc.logic.DelegadoConsultaTareas;
import co.com.fc.model.TaskVo;
import co.com.fc.view.Ingreso;

public class RecepcionDatosRadicacion {
	//variables de la solicitud de personal
	// son los que se toman desde la pantalla
	private String identificacionCliente;
	private String nombreCliente;
	private String nombreCargo;
	private String taskId;
	private String observaciones;
	private String bitacoraObservaciones;
	
	private ParametroFacade parametroFacade = new ParametroFacade();
	private LocalizacionFacade localizacionFacade = new LocalizacionFacade();
	
	private List<SelectItem> tipoId;
	private List<SelectItem> tipoSolicitante;
	private List<SelectItem> tipoContrato;
	private List<SelectItem> ciudades;
	
	
	
	public List<SelectItem> getTipoSolicitante() {
		tipoSolicitante = cargarValoresParametros(tipoSolicitante, 22L);
		return tipoSolicitante;
	}

	public void setTipoSolicitante(List<SelectItem> tipoSolicitante) {
		this.tipoSolicitante = tipoSolicitante;
	}

	public List<SelectItem> getTipoContrato() {
		tipoContrato = cargarValoresParametros(tipoContrato, 23L);
		return tipoContrato;
	}

	public void setTipoContrato(List<SelectItem> tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	public List<SelectItem> getCiudades() {
		if (ciudades == null) {
			ciudades = new ArrayList<SelectItem>();
		}else{
			ciudades.clear();
		}
		List<Localizacion> lasLocalizaciones = null;
		try {
			ciudades.add(new SelectItem("-1", "[---Seleccione---]"));
			
			lasLocalizaciones = localizacionFacade.findByNivel(3L);
			
			if (lasLocalizaciones != null && !lasLocalizaciones.isEmpty()) {
				for (Localizacion localizacion : lasLocalizaciones) {
					ciudades.add(new SelectItem(localizacion.getConsLocalizacion().toString(), localizacion.getDescripcion()));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			lasLocalizaciones = null;
		}
		
		return ciudades;
	}

	public void setCiudades(List<SelectItem> ciudades) {
		this.ciudades = ciudades;
	}

	public List<SelectItem> getTipoId() {
		tipoId = cargarValoresParametros(tipoId, 21L);
		return tipoId;
	}

	public void setTipoId(List<SelectItem> tipoId) {
		this.tipoId = tipoId;
	}

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

	public RecepcionDatosRadicacion(){
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
	
	public List<SelectItem> cargarValoresParametros(List<SelectItem> listaSelects, Long codTipoParametro){
		List<FacrPParametro> losParametros = null;
		try {
			if (listaSelects == null) {
				listaSelects = new ArrayList<SelectItem>();
			}else{
				listaSelects.clear();
			}
			
			listaSelects.add(new SelectItem("-1", "[---Seleccione---]"));
			
			losParametros = parametroFacade.findByTipoParametro(codTipoParametro);
			
			if (losParametros != null && !losParametros.isEmpty()) {
				for (FacrPParametro facrPParametro : losParametros) {
					listaSelects.add(new SelectItem(facrPParametro.getConsParamtro().toString(), facrPParametro.getValor()));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			 losParametros = null;
		}
		
		return listaSelects;
		
		
	}
	
}


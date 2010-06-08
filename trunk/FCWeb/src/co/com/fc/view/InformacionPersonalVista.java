package co.com.fc.view;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;

import co.com.faces.utils.FacesUtils;
import co.com.faces.utils.Validaciones;
import co.com.fc.bd.facade.LocalizacionFacade;
import co.com.fc.bd.facade.ParametroFacade;
import co.com.fc.bd.facade.SolicitanteFacade;
import co.com.fc.bd.model.FacrPParametro;
import co.com.fc.bd.model.FacrSolicitante;
import co.com.fc.bd.model.Localizacion;

public class InformacionPersonalVista {

	private ParametroFacade parametroFacade = new ParametroFacade();
	private LocalizacionFacade localizacionFacade = new LocalizacionFacade();
	private SolicitanteFacade solicitanteFacade = new SolicitanteFacade();
	
	private List<SelectItem> tipoId;
	private List<SelectItem> tipoSolicitante;
	private List<SelectItem> tipoContrato;
	private List<SelectItem> estadoCivil;
	private List<SelectItem> ciudades;
	
	
	private HtmlSelectOneMenu cmbTipoId;
	private HtmlSelectOneMenu cmbTipoSolicitante;
	private HtmlSelectOneMenu cmbTipoContrato;
	private HtmlSelectOneMenu cmbEstadoCivil;
	private HtmlSelectOneMenu cmbCiudades;
	
	private HtmlInputText txtNumId;
	private HtmlInputText txtNombre;
	private HtmlInputText txtEdad;
	private HtmlInputText txtTiempoFuncionamiento;
	private HtmlInputText txtDireccion;
	private HtmlInputText txtTelefonoContacto;
	private HtmlInputText txtTelefonoPersonal;
	private HtmlInputText txtIngresos;
	private HtmlInputText txtEgresos;
	private HtmlInputText txtNumPersonasMayores;
	private HtmlInputText txtNumPersonasMenores;
	private HtmlInputText txtCalificacion;
	
	public HtmlInputText getTxtCalificacion() {
		return txtCalificacion;
	}

	public void setTxtCalificacion(HtmlInputText txtCalificacion) {
		this.txtCalificacion = txtCalificacion;
	}

	public HtmlSelectOneMenu getCmbTipoId() {
		return cmbTipoId;
	}

	public void setCmbTipoId(HtmlSelectOneMenu cmbTipoId) {
		this.cmbTipoId = cmbTipoId;
	}

	public HtmlSelectOneMenu getCmbTipoSolicitante() {
		return cmbTipoSolicitante;
	}

	public void setCmbTipoSolicitante(HtmlSelectOneMenu cmbTipoSolicitante) {
		this.cmbTipoSolicitante = cmbTipoSolicitante;
	}

	public HtmlSelectOneMenu getCmbTipoContrato() {
		return cmbTipoContrato;
	}

	public void setCmbTipoContrato(HtmlSelectOneMenu cmbTipoContrato) {
		this.cmbTipoContrato = cmbTipoContrato;
	}

	public HtmlSelectOneMenu getCmbEstadoCivil() {
		return cmbEstadoCivil;
	}

	public void setCmbEstadoCivil(HtmlSelectOneMenu cmbEstadoCivil) {
		this.cmbEstadoCivil = cmbEstadoCivil;
	}

	public HtmlSelectOneMenu getCmbCiudades() {
		return cmbCiudades;
	}

	public void setCmbCiudades(HtmlSelectOneMenu cmbCiudades) {
		this.cmbCiudades = cmbCiudades;
	}

	public HtmlInputText getTxtNumId() {
		return txtNumId;
	}

	public void setTxtNumId(HtmlInputText txtNumId) {
		this.txtNumId = txtNumId;
	}

	public HtmlInputText getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(HtmlInputText txtNombre) {
		this.txtNombre = txtNombre;
	}

	public HtmlInputText getTxtEdad() {
		return txtEdad;
	}

	public void setTxtEdad(HtmlInputText txtEdad) {
		this.txtEdad = txtEdad;
	}

	public HtmlInputText getTxtTiempoFuncionamiento() {
		return txtTiempoFuncionamiento;
	}

	public void setTxtTiempoFuncionamiento(HtmlInputText txtTiempoFuncionamiento) {
		this.txtTiempoFuncionamiento = txtTiempoFuncionamiento;
	}

	public HtmlInputText getTxtDireccion() {
		return txtDireccion;
	}

	public void setTxtDireccion(HtmlInputText txtDireccion) {
		this.txtDireccion = txtDireccion;
	}

	public HtmlInputText getTxtTelefonoContacto() {
		return txtTelefonoContacto;
	}

	public void setTxtTelefonoContacto(HtmlInputText txtTelefonoContacto) {
		this.txtTelefonoContacto = txtTelefonoContacto;
	}

	public HtmlInputText getTxtTelefonoPersonal() {
		return txtTelefonoPersonal;
	}

	public void setTxtTelefonoPersonal(HtmlInputText txtTelefonoPersonal) {
		this.txtTelefonoPersonal = txtTelefonoPersonal;
	}

	public HtmlInputText getTxtIngresos() {
		return txtIngresos;
	}

	public void setTxtIngresos(HtmlInputText txtIngresos) {
		this.txtIngresos = txtIngresos;
	}

	public HtmlInputText getTxtEgresos() {
		return txtEgresos;
	}

	public void setTxtEgresos(HtmlInputText txtEgresos) {
		this.txtEgresos = txtEgresos;
	}

	public HtmlInputText getTxtNumPersonasMayores() {
		return txtNumPersonasMayores;
	}

	public void setTxtNumPersonasMayores(HtmlInputText txtNumPersonasMayores) {
		this.txtNumPersonasMayores = txtNumPersonasMayores;
	}

	public HtmlInputText getTxtNumPersonasMenores() {
		return txtNumPersonasMenores;
	}

	public void setTxtNumPersonasMenores(HtmlInputText txtNumPersonasMenores) {
		this.txtNumPersonasMenores = txtNumPersonasMenores;
	}

	public List<SelectItem> getEstadoCivil() {
		estadoCivil = cargarValoresParametros(estadoCivil, 28L);
		return estadoCivil;
	}

	public void setEstadoCivil(List<SelectItem> estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

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
			FacesContext.getCurrentInstance().addMessage("msg", new FacesMessage(e.getMessage()));
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
	
	public InformacionPersonalVista() {
		init();
	}
	
	public String init(){
		try {
			cmbTipoId = new HtmlSelectOneMenu();
			cmbTipoSolicitante = new HtmlSelectOneMenu();
			cmbTipoContrato = new HtmlSelectOneMenu();
			cmbEstadoCivil = new HtmlSelectOneMenu();
			cmbCiudades = new HtmlSelectOneMenu();
			
			txtNumId = new HtmlInputText();
			txtNombre = new HtmlInputText();
			txtEdad = new HtmlInputText();
			txtTiempoFuncionamiento = new HtmlInputText();
			txtDireccion = new HtmlInputText();
			txtTelefonoContacto = new HtmlInputText();
			txtTelefonoPersonal = new HtmlInputText();
			txtIngresos = new HtmlInputText();
			txtEgresos = new HtmlInputText();
			txtNumPersonasMayores = new HtmlInputText();
			txtNumPersonasMenores = new HtmlInputText();
			txtCalificacion = new HtmlInputText();
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage("msg", new FacesMessage(e.getMessage()));
		}
		return "";
	}
	
	public String save() throws Exception{
			Validaciones.validar(txtNumId.getValue(), "Nunmero ID obligatorio");
			Validaciones.validar(txtNombre.getValue(), "Nombre obligatorio");
			Validaciones.validarCombos(cmbTipoId.getValue(), "Tipo ID Obligatorio");
			Validaciones.validarCombos(cmbTipoSolicitante.getValue(), "Tipo ID Obligatorio");
			Validaciones.validarCombos(cmbCiudades.getValue(), "Tipo ID Obligatorio");
			Validaciones.validarCombos(cmbEstadoCivil.getValue(), "Estado Civil Obligatorio");
			Validaciones.validar(txtDireccion.getValue(), "Direccion obligatoria");
			Validaciones.validar(txtTelefonoPersonal.getValue(), "Telefono Personal obligatorio");
			Validaciones.validar(txtTelefonoContacto.getValue(), "Telefono Contacto obligatorio");
			Validaciones.validar(txtEdad.getValue(), "Edad obligatoria");
			Validaciones.validar(txtCalificacion.getValue(), "Calificacion obligatoria");
			Validaciones.validar(txtIngresos.getValue(), "Ingresos obligatoria");
			Validaciones.validar(txtEgresos.getValue(), "Egresos obligatoria");
			
			FacrSolicitante solicitante = new FacrSolicitante();
			
			solicitante.setNumId(txtNumId.getValue().toString().trim());
			solicitante.setNombreSolicitante(txtNombre.getValue().toString().trim());
			solicitante.setCalificacion(Validaciones.isNumericoEntero(txtCalificacion.getValue().toString().trim()));
			solicitante.setTipoId(Validaciones.isNumericoEntero(cmbTipoId.getValue().toString().trim()));
			solicitante.setTipoSolicitante(Validaciones.isNumericoEntero(cmbTipoSolicitante.getValue().toString().trim()));
			Localizacion localizacion = new Localizacion();
			localizacion.setConsLocalizacion(Validaciones.isNumericoEntero(cmbCiudades.getValue().toString().trim()));
			solicitante.setLocalizacion(localizacion);
			solicitante.setDireccion(txtDireccion.getValue().toString().trim());
			solicitante.setTelefonoContacto(txtTelefonoContacto.getValue().toString().trim());
			solicitante.setTelefonoResidencia(txtTelefonoPersonal.getValue().toString().trim());
			solicitante.setEdad(Validaciones.isNumericoEntero(txtEdad.getValue().toString().trim()));
			solicitante.setEstadoCivil(Validaciones.isNumericoEntero(cmbEstadoCivil.getValue().toString().trim()));
			solicitante.setIngresos(Validaciones.isNumericoDecimal(txtIngresos.getValue().toString().trim()));
			solicitante.setEgresos(Validaciones.isNumericoDecimal(txtEgresos.getValue().toString().trim()));
			
			if (txtTiempoFuncionamiento.getValue() != null && !txtTiempoFuncionamiento.getValue().toString().trim().equalsIgnoreCase("")) {
				solicitante.setTiempoFuncionamiento(Validaciones.isNumericoEntero(txtTiempoFuncionamiento.getValue().toString().trim()));
			}else{
				solicitante.setTiempoFuncionamiento(null);
			}
			if (cmbTipoContrato.getValue() != null && !cmbTipoContrato.getValue().toString().trim().equalsIgnoreCase("-1")) {
				solicitante.setTipoContrato(Validaciones.isNumericoEntero(cmbTipoContrato.getValue().toString().trim()));
			}else{
				solicitante.setTipoContrato(null);
			}
			if (txtNumPersonasMenores.getValue() != null && !txtNumPersonasMenores.getValue().toString().trim().equalsIgnoreCase("")) {
				solicitante.setNumPersonasMenores(Validaciones.isNumericoEntero(txtNumPersonasMenores.getValue().toString().trim()));
			}else{
				solicitante.setNumPersonasMenores(null);
			}
			if (txtNumPersonasMayores.getValue() != null && !txtNumPersonasMayores.getValue().toString().trim().equalsIgnoreCase("")) {
				solicitante.setNumPersonasMayores(Validaciones.isNumericoEntero(txtNumPersonasMayores.getValue().toString().trim()));
			}else{
				solicitante.setNumPersonasMayores(null);
			}
			
			
			solicitanteFacade.saveOrUpdate(solicitante);
			FacesContext.getCurrentInstance().addMessage("msg", new FacesMessage("Grabado Exitosamente"));
			FacesUtils.setSessionParameter("solicitante", txtNumId.getValue().toString());
			
			
		return "";
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
			FacesContext.getCurrentInstance().addMessage("msg", new FacesMessage(e.getMessage()));
		}finally{
			 losParametros = null;
		}
		
		return listaSelects;
	}
	
	public void listenerCedula(ValueChangeEvent event){
		try {
			if (event != null && event.getNewValue() != null && !event.getNewValue().toString().trim().equalsIgnoreCase("")) {
				FacrSolicitante solicitante = solicitanteFacade.findByIdentificacion(event.getNewValue().toString().trim());
				if (solicitante != null) {
					
					cmbTipoId.setValue(solicitante.getTipoId());
					cmbTipoSolicitante.setValue(solicitante.getTipoSolicitante());
					if (solicitante.getTipoContrato() != null) {
						cmbTipoContrato.setValue(solicitante.getTipoContrato());
					}else{
						cmbTipoContrato.setValue("-1");
					}
					
					cmbEstadoCivil.setValue(solicitante.getEstadoCivil());
					cmbCiudades.setValue(solicitante.getLocalizacion().getConsLocalizacion());
					
					txtNombre.setValue(solicitante.getNombreSolicitante());
					txtEdad.setValue(solicitante.getEdad().toString());
					if (solicitante.getTiempoFuncionamiento() != null) {
						txtTiempoFuncionamiento.setValue(solicitante.getTiempoFuncionamiento().toString());
					}else{
						txtTiempoFuncionamiento.setValue("");
					}
					txtDireccion.setValue(solicitante.getDireccion());
					txtTelefonoContacto.setValue(solicitante.getTelefonoContacto());
					txtTelefonoPersonal.setValue(solicitante.getTelefonoResidencia());
					if (solicitante.getIngresos() != null) {
						txtIngresos.setValue(solicitante.getIngresos().toString());
					}else{
						txtIngresos.setValue("");
					}
					if (solicitante.getEgresos() != null) {
						txtEgresos.setValue(solicitante.getEgresos().toString());
					}else{
						txtEgresos.setValue("");
					}
					if (solicitante.getNumPersonasMayores() != null) {
						txtNumPersonasMayores.setValue(solicitante.getNumPersonasMayores().toString());
					}else{
						txtNumPersonasMayores.setValue("");
					}
					if (solicitante.getNumPersonasMenores() != null) {
						txtNumPersonasMenores.setValue(solicitante.getNumPersonasMenores().toString());
					}else{
						txtNumPersonasMenores.setValue("");
					}
					txtCalificacion.setValue(solicitante.getCalificacion().toString());
					
				}else{
					cmbTipoId.setValue("-1");
					cmbTipoSolicitante.setValue("-1");
					cmbTipoContrato.setValue("-1");
					cmbEstadoCivil.setValue("-1");
					cmbCiudades.setValue("-1");
					
					txtNombre.setValue("");
					txtEdad.setValue("");
					txtTiempoFuncionamiento.setValue("");
					txtDireccion.setValue("");
					txtTelefonoContacto.setValue("");
					txtTelefonoPersonal.setValue("");
					txtIngresos.setValue("");
					txtEgresos.setValue("");
					txtNumPersonasMayores.setValue("");
					txtNumPersonasMenores.setValue("");
					txtCalificacion.setValue("");
					
				}
			}else{
				limpiarForma();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage("msg", new FacesMessage(e.getMessage()));
		}
	}
	
	public String limpiarForma(){
		
		cmbTipoId.setValue("-1");
		cmbTipoSolicitante.setValue("-1");
		cmbTipoContrato.setValue("-1");
		cmbEstadoCivil.setValue("-1");
		cmbCiudades.setValue("-1");
		
		txtNumId.setValue("");
		txtNombre.setValue("");
		txtEdad.setValue("");
		txtTiempoFuncionamiento.setValue("");
		txtDireccion.setValue("");
		txtTelefonoContacto.setValue("");
		txtTelefonoPersonal.setValue("");
		txtIngresos.setValue("");
		txtEgresos.setValue("");
		txtNumPersonasMayores.setValue("");
		txtNumPersonasMenores.setValue("");
		txtCalificacion.setValue("");
		
		return "";
	}
	
}

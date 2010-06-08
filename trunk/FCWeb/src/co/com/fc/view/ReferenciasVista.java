package co.com.fc.view;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;

import co.com.faces.utils.FacesUtils;
import co.com.faces.utils.Validaciones;
import co.com.fc.bd.facade.ParametroFacade;
import co.com.fc.bd.facade.ReferenciasFacade;
import co.com.fc.bd.facade.SolicitanteFacade;
import co.com.fc.bd.model.FacrPParametro;
import co.com.fc.bd.model.FacrReferencias;
import co.com.fc.bd.model.FacrSolicitante;

public class ReferenciasVista {

	private ParametroFacade parametroFacade = new ParametroFacade();
	private ReferenciasFacade referenciasFacade = new ReferenciasFacade();
	private SolicitanteFacade solicitanteFacade = new SolicitanteFacade();

	private List<SelectItem> parentesco;
	private List<SelectItem> tipoReferencia;

	private List<FacrReferencias> lasReferencias;

	private boolean guardar = true;

	private HtmlInputText txtNumId;
	private HtmlInputText txtNombre;
	private HtmlInputText txtTelefono;
	private HtmlInputText txtDireccion;

	private HtmlSelectOneMenu cmbParentesco;
	private HtmlSelectOneMenu cmbTipoReferencia;

	private String numID;

	public HtmlInputText getTxtDireccion() {
		return txtDireccion;
	}
	public void setTxtDireccion(HtmlInputText txtDireccion) {
		this.txtDireccion = txtDireccion;
	}
	public List<SelectItem> getParentesco() {
		parentesco = cargarValoresParametros(parentesco, 29L);
		return parentesco;
	}
	public void setParentesco(List<SelectItem> parentesco) {
		this.parentesco = parentesco;
	}
	public List<SelectItem> getTipoReferencia() {
		tipoReferencia = cargarValoresParametros(tipoReferencia, 30L);
		return tipoReferencia;
	}
	public void setTipoReferencia(List<SelectItem> tipoReferencia) {
		this.tipoReferencia = tipoReferencia;
	}
	public List<FacrReferencias> getLasReferencias() {

		if (lasReferencias == null) {
			lasReferencias = new ArrayList<FacrReferencias>();
		}else{
			lasReferencias.clear();
		}
		try {
			if (FacesUtils.getSessionParameter("solicitante")!=null) {
				numID = FacesUtils.getSessionParameter("solicitante").toString().trim(); 
			}

			if (numID != null) {
				lasReferencias = referenciasFacade.findBySolicitante(numID);
			}
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage("msg", new FacesMessage(e.getMessage()));
		}

		return lasReferencias;
	}
	public void setLasReferencias(List<FacrReferencias> lasReferencias) {
		this.lasReferencias = lasReferencias;
	}
	public boolean isGuardar() {
		return guardar;
	}
	public void setGuardar(boolean guardar) {
		this.guardar = guardar;
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
	public HtmlInputText getTxtTelefono() {
		return txtTelefono;
	}
	public void setTxtTelefono(HtmlInputText txtTelefono) {
		this.txtTelefono = txtTelefono;
	}
	public HtmlSelectOneMenu getCmbParentesco() {
		return cmbParentesco;
	}
	public void setCmbParentesco(HtmlSelectOneMenu cmbParentesco) {
		this.cmbParentesco = cmbParentesco;
	}
	public HtmlSelectOneMenu getCmbTipoReferencia() {
		return cmbTipoReferencia;
	}
	public void setCmbTipoReferencia(HtmlSelectOneMenu cmbTipoReferencia) {
		this.cmbTipoReferencia = cmbTipoReferencia;
	}

	public ReferenciasVista() {
		init();
	}

	public String init(){
		try {
			txtNumId = new HtmlInputText();
			txtNombre = new HtmlInputText();
			txtTelefono = new HtmlInputText();
			txtDireccion = new HtmlInputText();

			cmbParentesco = new HtmlSelectOneMenu();
			cmbTipoReferencia = new HtmlSelectOneMenu();
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage("msg", new FacesMessage(e.getMessage()));
		}
		return "";
	}

	public String save(){
		try {

			Validaciones.validar(txtNumId.getValue(), "Id obligatorio");
			Validaciones.validar(txtNombre.getValue(), "Nombre obligatorio");
			Validaciones.validar(txtTelefono, "Telefono Obligatorio");
			Validaciones.validar(txtDireccion.getValue(), "Direccion obligatoria");
			Validaciones.validarCombos(cmbTipoReferencia.getValue(), "Tipo de referencia obligatorio");
			Validaciones.validarCombos(cmbParentesco.getValue(), "Parentesco obligatorio");
			
			FacrReferencias facrReferencias = new FacrReferencias();
			
			facrReferencias.setIdentificacion(txtNumId.getValue().toString().trim());
			facrReferencias.setNombre(txtNombre.getValue().toString().trim());
			facrReferencias.setDireccion(txtDireccion.getValue().toString().trim());
			facrReferencias.setTelefono(txtTelefono.getValue().toString().trim());
			facrReferencias.setParentesco(Validaciones.isNumericoEntero(cmbParentesco.getValue().toString().trim()));
			facrReferencias.setTipoReferencia(Validaciones.isNumericoEntero(cmbTipoReferencia.getValue().toString().trim()));
			numID = FacesUtils.getSessionParameter("solicitante").toString().trim();
			FacrSolicitante facrSolicitante = solicitanteFacade.findByIdentificacion(numID);
			if (facrSolicitante == null) {
				throw new Exception("Solicitante vacio");
			}
			facrReferencias.setFacrSolicitante(facrSolicitante);
			referenciasFacade.save(facrReferencias);
			getLasReferencias();
			FacesContext.getCurrentInstance().addMessage("msg", new FacesMessage("Grabado Exitosamente"));
			
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage("msg", new FacesMessage(e.getMessage()));
		}
		return "";
	}

	public String update(){
		try {

		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage("msg", new FacesMessage(e.getMessage()));
		}
		return "";
	}

	public String delete(){
		try {

		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage("msg", new FacesMessage(e.getMessage()));
		}
		return "";
	}

	public String limpiarForma(){

		cmbParentesco.setValue("-1");
		cmbTipoReferencia.setValue("-1");

		txtNumId.setValue("");
		txtNombre.setValue("");
		txtTelefono.setValue("");
		txtDireccion.setValue("");

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

}

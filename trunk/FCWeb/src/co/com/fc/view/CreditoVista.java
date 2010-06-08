package co.com.fc.view;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;

import co.com.faces.utils.FacesUtils;
import co.com.faces.utils.Validaciones;
import co.com.fc.bd.facade.CreditoFacade;
import co.com.fc.bd.facade.ParametroFacade;
import co.com.fc.bd.facade.SolicitanteFacade;
import co.com.fc.bd.model.FacrCredito;
import co.com.fc.bd.model.FacrPParametro;
import co.com.fc.bd.model.FacrSolicitante;

public class CreditoVista {

	private SolicitanteFacade solicitanteFacade = new SolicitanteFacade();
	private CreditoFacade creditoFacade = new CreditoFacade();

	private HtmlInputText txtMontoCredito;
	private SelectInputDate fechaCredito;

	public HtmlInputText getTxtMontoCredito() {
		return txtMontoCredito;
	}

	public void setTxtMontoCredito(HtmlInputText txtMontoCredito) {
		this.txtMontoCredito = txtMontoCredito;
	}

	public SelectInputDate getFechaCredito() {
		return fechaCredito;
	}

	public void setFechaCredito(SelectInputDate fechaCredito) {
		this.fechaCredito = fechaCredito;
	}

	public CreditoVista() {
		init();
	}

	public String init(){

		try {

		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage("msg", new FacesMessage(e.getMessage()));
		}

		return "";
	}

	public String save() throws Exception{


		Validaciones.validar(txtMontoCredito.getValue(), "Monto obligatorio");
//		Validaciones.validar(fechaCredito.getValue(), "Fecha obligatoria");

		FacrCredito credito = new FacrCredito();

		credito.setMontoCredito(Validaciones.isNumericoDecimal(txtMontoCredito.getValue().toString().trim()));
		String numId = FacesUtils.getSessionParameter("solicitante").toString().trim();
		FacrSolicitante solicitante = solicitanteFacade.findByIdentificacion(numId);
		if (solicitante == null) {
			throw new Exception("No solicitante");
		}
		credito.setFacrSolicitante(solicitante);
		credito.setFechaSolicitud(new Date());
		credito.setEstadoCredito(53L);
		
		Long estado = creditoFacade.save(credito);
		
		ParametroFacade parametroFacade = new ParametroFacade();
		FacrPParametro parametro = parametroFacade.findById(estado);
		
		FacesContext.getCurrentInstance().addMessage("msg", new FacesMessage("Grabado Exitosamente con estado: "+ parametro.getValor()));

		return "";
	}

}

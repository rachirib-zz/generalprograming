package co.com.fc.bd.facade;

import java.util.List;

import co.com.fc.bd.logic.LocalizacionLogica;
import co.com.fc.bd.model.Localizacion;

public class LocalizacionFacade {
	
	private LocalizacionLogica localizacionLogica = new LocalizacionLogica();

	public List<Localizacion> findByNivel(Long nivel) throws Exception{
		return localizacionLogica.findByNivel(nivel);
	}
	
}

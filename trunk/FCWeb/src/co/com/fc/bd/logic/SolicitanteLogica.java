package co.com.fc.bd.logic;

import org.hibernate.Transaction;

import co.com.fc.bd.config.oracle.HibernateSessionFactoryOracle;
import co.com.fc.bd.model.FacrSolicitante;
import co.com.fc.bd.model.FacrSolicitanteDAO;

public class SolicitanteLogica {

	private FacrSolicitanteDAO facrSolicitanteDAO = new FacrSolicitanteDAO();
	
	public void saveOrUpdate(FacrSolicitante solicitante) throws Exception{
		Transaction transaction = null;
		try {
			
			transaction = HibernateSessionFactoryOracle.getSession().beginTransaction();
			
			FacrSolicitante solicitante2 = findByIdentificacion(solicitante.getNumId());
			
			if (solicitante2 == null) {
				facrSolicitanteDAO.save(solicitante);
			}else{
				solicitante2.setCalificacion(solicitante.getCalificacion());
				solicitante2.setDireccion(solicitante.getDireccion());
				solicitante2.setEdad(solicitante.getEdad());
				solicitante2.setEgresos(solicitante.getEgresos());
				solicitante2.setEstadoCivil(solicitante.getEstadoCivil());
				solicitante2.setIngresos(solicitante.getIngresos());
				solicitante2.setLocalizacion(solicitante.getLocalizacion());
				solicitante2.setNombreSolicitante(solicitante.getNombreSolicitante());
				solicitante2.setNumId(solicitante.getNumId());
				solicitante2.setNumPersonasMayores(solicitante.getNumPersonasMayores());
				solicitante2.setNumPersonasMenores(solicitante.getNumPersonasMenores());
				solicitante2.setTelefonoContacto(solicitante.getTelefonoContacto());
				solicitante2.setTelefonoResidencia(solicitante.getTelefonoResidencia());
				solicitante2.setTiempoFuncionamiento(solicitante.getTiempoFuncionamiento());
				solicitante2.setTipoContrato(solicitante.getTipoContrato());
				solicitante2.setTipoId(solicitante.getTipoId());
				solicitante2.setTipoSolicitante(solicitante.getTipoSolicitante());
			}
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		
		
	}
	
	public FacrSolicitante findByIdentificacion(String numId) throws Exception{
		FacrSolicitante facrSolicitante = facrSolicitanteDAO.findById(numId);
		
		return facrSolicitante;
		
	}
}

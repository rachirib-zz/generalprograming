package co.com.fc.rules.test;

import co.com.fc.rules.delegado.DelegadoAporbacionRules;
import co.com.fc.rules.dto.AprobacionCreditoDTO;

public class Test {

	public static void main(String[] args) {
		
		try {
			
			DelegadoAporbacionRules aporbacionRules = new DelegadoAporbacionRules();
			
			AprobacionCreditoDTO creditoDTO = new AprobacionCreditoDTO();
			
			creditoDTO.setEdad(25L);
			creditoDTO.setAcierta(500L);
			creditoDTO.setEstadoCivil(42L);
			creditoDTO.setAprobado(0L);
			
			System.out.println(aporbacionRules.aprobacionCredito(creditoDTO));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}

package co.com.fc.rules.delegado;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;

import co.com.fc.rules.dto.AprobacionCreditoDTO;

public class DelegadoAporbacionRules {

	public Long aprobacionCredito(AprobacionCreditoDTO creditoDTO) throws Exception{
		
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder(); 
//		kbuilder.add( ResourceFactory.newUrlResource("file:ChangeSet.xml"), ResourceType.CHANGE_SET);
		kbuilder.add( ResourceFactory.newUrlResource("http://localhost:9092/drools-guvnor/org.drools.guvnor.Guvnor/package/aprobacionCreditos/LATEST/AprobacionCredito.drl"), ResourceType.DRL);
//		kbuilder.add(ResourceFactory.newClassPathResource("AprobacionCredito.drl", getClass()), ResourceType.DRL);
		
		if(kbuilder.hasErrors()) {
			System.err.println(kbuilder.getErrors().toString());
		}
		
		KnowledgeBase kbase= KnowledgeBaseFactory.newKnowledgeBase();
		kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
		
		StatefulKnowledgeSession ksession= kbase.newStatefulKnowledgeSession();
		
		ksession.insert(creditoDTO);
		
		ksession.fireAllRules();
		
		return creditoDTO.getAprobado();
	}
	
}

package com.github.scompo.testsdn4j.batch.tasklets;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import com.github.scompo.testsdn4j.domain.OperazioneOne;
import com.github.scompo.testsdn4j.repositories.OperazioneOneRepository;

public class ImportOperazioneOneTasklet implements Tasklet {

	private OperazioneOneRepository operazioneOneRepository;

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

		Collection<OperazioneOne> entities = new ArrayList<OperazioneOne>();
		
		OperazioneOne op1 = null;
		OperazioneOne op2 = null;
		OperazioneOne op3 = null;
		OperazioneOne op4 = null;
		OperazioneOne op5 = null;
		OperazioneOne op6 = null;
		
		op1 = new OperazioneOne();
		op1.setData("data1");
		op1.setIdMutazioneStart(1L);
		op1.setIdMutazioneEnd(null);
		
		op2 = new OperazioneOne();
		op2.setData("data2");
		op2.setIdMutazioneStart(1L);
		op2.setIdMutazioneEnd(2L);
		
		op3 = new OperazioneOne();   
		op3.setData("data3");        
		op3.setIdMutazioneStart(2L); 
		op3.setIdMutazioneEnd(null);
		
		op4 = new OperazioneOne();   
		op4.setData("data4");        
		op4.setIdMutazioneStart(2L); 
		op4.setIdMutazioneEnd(3L);
		
		op5 = new OperazioneOne();   
		op5.setData("data5");        
		op5.setIdMutazioneStart(3L); 
		op5.setIdMutazioneEnd(null);
		
		op6 = new OperazioneOne();   
		op6.setData("data6");        
		op6.setIdMutazioneStart(4L); 
		op6.setIdMutazioneEnd(null);

		entities.add(op1);
		entities.add(op2);
		entities.add(op3);
		entities.add(op4);
		entities.add(op5);
		entities.add(op6);
		
		operazioneOneRepository.save(entities);
		
		return RepeatStatus.FINISHED;
	}

	public OperazioneOneRepository getOperazioneOneRepository() {
		return operazioneOneRepository;
	}

	public void setOperazioneOneRepository(OperazioneOneRepository operazioneOneRepository) {
		this.operazioneOneRepository = operazioneOneRepository;
	}

}

package com.github.scompo.testsdn4j.batch.tasklets;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import com.github.scompo.testsdn4j.domain.OperazioneMacroOne;
import com.github.scompo.testsdn4j.domain.OperazioneOne;
import com.github.scompo.testsdn4j.domain.Prerequisito;
import com.github.scompo.testsdn4j.repositories.OperazioneMacroOneRepository;
import com.github.scompo.testsdn4j.repositories.OperazioneOneRepository;

public class LinkMacroOperazioneOneTasklet implements Tasklet {

	private OperazioneMacroOneRepository operazioneMacroOneRepository;

	private OperazioneOneRepository operazioneOneRepository;

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		
		Map<Long, Set<Long>> associazioni = new HashMap<Long, Set<Long>>();
		
		for (OperazioneOne op : operazioneOneRepository.findAll()) {
			
			Long start = op.getIdMutazioneStart();
			
			Long end = op.getIdMutazioneEnd();
			
			if(end != null){
				
				if(!associazioni.containsKey(start)){
					
					associazioni.put(start, new HashSet<Long>());
				}
				
				associazioni.get(start).add(end);
			}
		}
		
		for (Entry<Long, Set<Long>> entry : associazioni.entrySet()) {
			
			OperazioneMacroOne start = operazioneMacroOneRepository.findByMutazioneId(entry.getKey());
			
			for (Long endId : entry.getValue()) {
				
				OperazioneMacroOne end = operazioneMacroOneRepository.findByMutazioneId(endId);
				
				end.getPrerequisiti().add(new Prerequisito(end, start));
				
				operazioneMacroOneRepository.save(end);
			}
		}

		return RepeatStatus.FINISHED;
	}

	public OperazioneMacroOneRepository getOperazioneMacroOneRepository() {
		return operazioneMacroOneRepository;
	}

	public void setOperazioneMacroOneRepository(OperazioneMacroOneRepository operazioneMacroOneRepository) {
		this.operazioneMacroOneRepository = operazioneMacroOneRepository;
	}

	public OperazioneOneRepository getOperazioneOneRepository() {
		return operazioneOneRepository;
	}

	public void setOperazioneOneRepository(OperazioneOneRepository operazioneOneRepository) {
		this.operazioneOneRepository = operazioneOneRepository;
	}

}

package com.github.scompo.testsdn4j.batch.tasklets;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import com.github.scompo.testsdn4j.repositories.OperazioneMacroOneRepository;
import com.github.scompo.testsdn4j.repositories.OperazioneOneRepository;

public class ClearTasklet implements Tasklet {

	private OperazioneMacroOneRepository operazioneMacroOneRepository;

	private OperazioneOneRepository operazioneOneRepository;

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

		RepeatStatus res = RepeatStatus.FINISHED;

		operazioneOneRepository.deleteAll();
		operazioneMacroOneRepository.deleteAll();
		
		return res;
	}

	public OperazioneOneRepository getOperazioneOneRepository() {
		return operazioneOneRepository;
	}

	public void setOperazioneOneRepository(OperazioneOneRepository operazioneOneRepository) {
		this.operazioneOneRepository = operazioneOneRepository;
	}

	public OperazioneMacroOneRepository getOperazioneMacroOneRepository() {
		return operazioneMacroOneRepository;
	}

	public void setOperazioneMacroOneRepository(OperazioneMacroOneRepository operazioneMacroOneRepository) {
		this.operazioneMacroOneRepository = operazioneMacroOneRepository;
	}

}

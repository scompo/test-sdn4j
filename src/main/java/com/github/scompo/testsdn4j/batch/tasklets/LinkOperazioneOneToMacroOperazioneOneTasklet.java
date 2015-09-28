package com.github.scompo.testsdn4j.batch.tasklets;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import com.github.scompo.testsdn4j.domain.OperazioneMacroOne;
import com.github.scompo.testsdn4j.domain.OperazioneOne;
import com.github.scompo.testsdn4j.domain.SottoMutazioneOne;
import com.github.scompo.testsdn4j.repositories.OperazioneMacroOneRepository;
import com.github.scompo.testsdn4j.repositories.OperazioneOneRepository;

public class LinkOperazioneOneToMacroOperazioneOneTasklet implements Tasklet {

	private OperazioneMacroOneRepository operazioneMacroOneRepository;

	private OperazioneOneRepository operazioneOneRepository;

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

		for (OperazioneOne operazioneOne : operazioneOneRepository.findAll()) {

			Long startId = operazioneOne.getIdMutazioneStart();

			OperazioneMacroOne macroOne = operazioneMacroOneRepository.findByMutazioneId(startId);

			SottoMutazioneOne subMutazione = new SottoMutazioneOne();
			subMutazione.setMacroOp(macroOne);
			subMutazione.setSubOp(operazioneOne);

			macroOne.getSottoMutazioni().add(subMutazione);

			operazioneMacroOneRepository.save(macroOne);
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

package com.github.scompo.testsdn4j.batch.tasklets;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import com.github.scompo.testsdn4j.domain.OperazioneMacroOne;
import com.github.scompo.testsdn4j.repositories.OperazioneMacroOneRepository;
import com.github.scompo.testsdn4j.repositories.OperazioneOneRepository;

public class CreateMacroOperazioneOneTasklet implements Tasklet {

	private OperazioneMacroOneRepository operazioneMacroOneRepository;

	private OperazioneOneRepository operazioneOneRepository;

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

		Collection<Integer> starts = operazioneOneRepository.findAllDistinctMutazioneStart();
		Collection<Integer> ends = operazioneOneRepository.findAllDistinctMutazioneEnd();

		Collection<Integer> all = new HashSet<Integer>();

		all.addAll(starts);
		all.addAll(ends);

		for (Integer integer : all) {

			if (integer != null) {

				OperazioneMacroOne entity = new OperazioneMacroOne(new Long(integer));
				operazioneMacroOneRepository.save(entity);
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

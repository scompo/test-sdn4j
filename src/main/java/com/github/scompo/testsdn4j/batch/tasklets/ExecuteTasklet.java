package com.github.scompo.testsdn4j.batch.tasklets;

import java.util.Collection;
import java.util.Stack;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import com.github.scompo.testsdn4j.domain.OperazioneMacroOne;
import com.github.scompo.testsdn4j.domain.OperazioneOne;
import com.github.scompo.testsdn4j.domain.Prerequisito;
import com.github.scompo.testsdn4j.domain.SottoMutazioneOne;
import com.github.scompo.testsdn4j.repositories.OperazioneMacroOneRepository;
import com.github.scompo.testsdn4j.repositories.OperazioneOneRepository;

public class ExecuteTasklet implements Tasklet {

	private OperazioneMacroOneRepository operazioneMacroOneRepository;

	private OperazioneOneRepository operazioneOneRepository;

	private Stack<OperazioneMacroOne> execStack = new Stack<OperazioneMacroOne>();

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

		RepeatStatus res = RepeatStatus.FINISHED;

		OperazioneMacroOne op = operazioneMacroOneRepository.findFirstNonEseguitaOrderedByMutazioneId();

		populateStack(op);

		while (!execStack.isEmpty()) {

			OperazioneMacroOne todo = execStack.pop();
			
			System.err.println(todo.getMutazioneId());

			Collection<SottoMutazioneOne> opChild = todo.getSottoMutazioni();

			for (SottoMutazioneOne sottoMutazioneOne : opChild) {

				OperazioneOne subOp = sottoMutazioneOne.getSubOp();

				subOp.setEseguito(true);

				operazioneOneRepository.save(subOp);
			}

			todo.setEseguito(true);

			operazioneMacroOneRepository.save(todo);

		}

		if (operazioneMacroOneRepository.countNonEseguite() > 0) {

			res = RepeatStatus.CONTINUABLE;
		}

		return res;
	}

	private void populateStack(OperazioneMacroOne tmp) {

		if (tmp != null && !tmp.isEseguito()) {

			execStack.push(tmp);

			if (tmp.getPrerequisiti() != null && !tmp.getPrerequisiti().isEmpty()) {

				for (Prerequisito prereq : tmp.getPrerequisiti()) {

					populateStack(prereq.getFiglio());
				}
			}
		}

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

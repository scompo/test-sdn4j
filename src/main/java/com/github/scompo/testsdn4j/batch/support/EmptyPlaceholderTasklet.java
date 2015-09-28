package com.github.scompo.testsdn4j.batch.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.scope.context.StepContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class EmptyPlaceholderTasklet implements Tasklet {

	private static final Logger logger = LoggerFactory.getLogger(EmptyPlaceholderTasklet.class);

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

		StepContext stepContext = chunkContext.getStepContext();

		String jobName = stepContext.getJobName();

		String stepName = stepContext.getStepName();

		logger.info("Executing empty placehoder tasklet for job={} and step={}", jobName, stepName);
		return RepeatStatus.FINISHED;
	}

}

package com.github.scompo.testsdn4j.configuration;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations = { "classpath:/batch/import-job.xml", "classpath:/batch/batch-support.xml",
		"classpath:/batch/execute-job.xml" , "classpath:/batch/clear-job.xml", "classpath:/batch/full-job.xml"})
@EnableBatchProcessing
public class BatchConfig {

}

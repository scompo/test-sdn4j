package com.github.scompo.testsdn4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.scompo.testsdn4j.repositories.OperazioneMacroOneRepository;

@Component
public class CmdLineRunner implements CommandLineRunner {
	
	private static final Logger logger = LoggerFactory.getLogger(CmdLineRunner.class);

	@Autowired
	private OperazioneMacroOneRepository operazioneMacroOneRepository;

	@Override
	public void run(String... args) throws Exception {
		
		logger.info("running!");
	}

}

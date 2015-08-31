package com.github.scompo.testsdn4j.repositories;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.github.scompo.testsdn4j.domain.OperazioneMacroOne;

public interface OperazioneMacroOneRepository extends GraphRepository<OperazioneMacroOne> {

	OperazioneMacroOne findByMutazioneId(Long mutazioneId);

}

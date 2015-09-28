package com.github.scompo.testsdn4j.repositories;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

import com.github.scompo.testsdn4j.domain.OperazioneMacroOne;

public interface OperazioneMacroOneRepository extends GraphRepository<OperazioneMacroOne> {

	OperazioneMacroOne findByMutazioneId(Long mutazioneId);

	@Query(value = "MATCH (n:OperazioneMacroOne) WHERE n.eseguito = false RETURN n ORDER BY n.mutazioneId DESC LIMIT 1")
	OperazioneMacroOne findFirstNonEseguitaOrderedByMutazioneId();

	@Query(value = "MATCH (n:OperazioneMacroOne) WHERE n.eseguito = false RETURN count(n)")
	Long countNonEseguite();

}

package com.github.scompo.testsdn4j.repositories;

import java.util.Collection;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

import com.github.scompo.testsdn4j.domain.OperazioneOne;

public interface OperazioneOneRepository extends GraphRepository<OperazioneOne> {

	@Query(value = "MATCH (n:OperazioneOne) RETURN DISTINCT n.idMutazioneStart")
	Collection<Integer> findAllDistinctMutazioneStart();

	@Query(value = "MATCH (n:OperazioneOne) RETURN DISTINCT n.idMutazioneEnd")
	Collection<Integer> findAllDistinctMutazioneEnd();

}

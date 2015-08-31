package com.github.scompo.testsdn4j.repositories;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.github.scompo.testsdn4j.domain.Operazione;

public interface OperazioniRepository extends GraphRepository<Operazione> {

	Operazione findByMutazioneId(Long mutazioneId);

}

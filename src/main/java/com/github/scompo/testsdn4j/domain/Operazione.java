package com.github.scompo.testsdn4j.domain;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Operazione {

	@GraphId
	private Long id;
	
	private Long mutazioneId;
	
	public Operazione() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMutazioneId() {
		return mutazioneId;
	}

	public void setMutazioneId(Long mutazioneId) {
		this.mutazioneId = mutazioneId;
	}

	@Override
	public String toString() {
		return "Operazione [id=" + id + ", mutazioneId=" + mutazioneId + "]";
	}
}

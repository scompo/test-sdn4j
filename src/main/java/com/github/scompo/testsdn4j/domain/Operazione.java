package com.github.scompo.testsdn4j.domain;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Operazione {

	private Long mutazioneId;
	
	public Operazione() {
		
	}

	public Long getMutazioneId() {
		return mutazioneId;
	}

	public void setMutazioneId(Long mutazioneId) {
		this.mutazioneId = mutazioneId;
	}

	@Override
	public String toString() {
		return "Operazione [mutazioneId=" + mutazioneId + "]";
	}
}

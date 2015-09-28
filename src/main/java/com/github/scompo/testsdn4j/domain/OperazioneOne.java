package com.github.scompo.testsdn4j.domain;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class OperazioneOne {

	@GraphId
	private Long id;
	
	private String data;
	
	private Long idMutazioneStart;
	
	private Long idMutazioneEnd;
	
	public OperazioneOne(){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Long getIdMutazioneStart() {
		return idMutazioneStart;
	}

	public void setIdMutazioneStart(Long idMutazioneStart) {
		this.idMutazioneStart = idMutazioneStart;
	}

	public Long getIdMutazioneEnd() {
		return idMutazioneEnd;
	}

	public void setIdMutazioneEnd(Long idMutazioneEnd) {
		this.idMutazioneEnd = idMutazioneEnd;
	}

	@Override
	public String toString() {
		return "OperazioneOne [id=" + id + ", data=" + data + ", idMutazioneStart=" + idMutazioneStart
				+ ", idMutazioneEnd=" + idMutazioneEnd + "]";
	}
}

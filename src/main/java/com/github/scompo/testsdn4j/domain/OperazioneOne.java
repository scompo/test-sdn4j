package com.github.scompo.testsdn4j.domain;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class OperazioneOne extends AbstractEseguibileNodeEntity {

	private String data;

	private Long idMutazioneStart;

	private Long idMutazioneEnd;

	public OperazioneOne() {

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
		return "OperazioneOne [data=" + data + ", idMutazioneStart=" + idMutazioneStart + ", idMutazioneEnd="
				+ idMutazioneEnd + "]";
	}
}

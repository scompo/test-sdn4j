package com.github.scompo.testsdn4j.domain;

import java.util.Collection;
import java.util.HashSet;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class OperazioneMacroOne extends AbstractNodeEntity {

	private Long mutazioneId;

	private Collection<Prerequisito> prerequisiti;

	private Collection<SottoMutazioneOne> sottoMutazioni;

	public OperazioneMacroOne() {

		this(null);
	}

	public OperazioneMacroOne(Long mutazioneId) {

		super();
		this.mutazioneId = mutazioneId;
		this.prerequisiti = new HashSet<Prerequisito>();
		this.sottoMutazioni = new HashSet<SottoMutazioneOne>();
	}

	public Long getMutazioneId() {
		return mutazioneId;
	}

	public void setMutazioneId(Long mutazioneId) {
		this.mutazioneId = mutazioneId;
	}

	public Collection<Prerequisito> getPrerequisiti() {
		return prerequisiti;
	}

	public void setPrerequisiti(Collection<Prerequisito> prerequisiti) {
		this.prerequisiti = prerequisiti;
	}

	public Collection<SottoMutazioneOne> getSottoMutazioni() {
		return sottoMutazioni;
	}

	public void setSottoMutazioni(Collection<SottoMutazioneOne> sottoMutazioni) {
		this.sottoMutazioni = sottoMutazioni;
	}

	@Override
	public String toString() {
		return "OperazioneMacroOne [mutazioneId=" + mutazioneId + ", prerequisiti=" + prerequisiti + ", sottoMutazioni="
				+ sottoMutazioni + "]";
	}

}

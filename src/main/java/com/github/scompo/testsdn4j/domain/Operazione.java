package com.github.scompo.testsdn4j.domain;

import java.util.Collection;
import java.util.HashSet;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Operazione {

	@GraphId
	private Long id;
	
	private Long mutazioneId;
	
	private Collection<Prerequisito> prerequisiti;
	
	public Operazione() {
		
		this(null);
	}
	
	public Operazione(Long mutazioneId) {
		
		this.mutazioneId = mutazioneId;
		prerequisiti = new HashSet<Prerequisito>();
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

	public Collection<Prerequisito> getPrerequisiti() {
		return prerequisiti;
	}

	public void setPrerequisiti(Collection<Prerequisito> prerequisiti) {
		this.prerequisiti = prerequisiti;
	}

	@Override
	public String toString() {
		return "Operazione [id=" + id + ", mutazioneId=" + mutazioneId + ", prerequisiti=" + prerequisiti + "]";
	}
}

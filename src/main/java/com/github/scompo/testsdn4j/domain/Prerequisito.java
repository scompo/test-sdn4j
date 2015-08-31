package com.github.scompo.testsdn4j.domain;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity(type = "PREREQUISITO")
public class Prerequisito {

	@GraphId
	private Long id;

	@StartNode
	private Operazione padre;

	@EndNode
	private Operazione figlio;

	public Prerequisito() {

		this(null, null);
	}

	public Prerequisito(Operazione padre, Operazione figlio) {
		this.padre = padre;
		this.figlio = figlio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Operazione getPadre() {
		return padre;
	}

	public void setPadre(Operazione padre) {
		this.padre = padre;
	}

	public Operazione getFiglio() {
		return figlio;
	}

	public void setFiglio(Operazione figlio) {
		this.figlio = figlio;
	}

	@Override
	public String toString() {
		return "Prerequisito [id=" + id + ", padre=" + (padre != null ? padre.getMutazioneId() : "null") + ", figlio="
				+ (figlio != null ? figlio.getMutazioneId() : "null") + "]";
	}
}

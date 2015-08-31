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
	private OperazioneMacroOne padre;

	@EndNode
	private OperazioneMacroOne figlio;

	public Prerequisito() {

		this(null, null);
	}

	public Prerequisito(OperazioneMacroOne padre, OperazioneMacroOne figlio) {
		this.padre = padre;
		this.figlio = figlio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OperazioneMacroOne getPadre() {
		return padre;
	}

	public void setPadre(OperazioneMacroOne padre) {
		this.padre = padre;
	}

	public OperazioneMacroOne getFiglio() {
		return figlio;
	}

	public void setFiglio(OperazioneMacroOne figlio) {
		this.figlio = figlio;
	}

	@Override
	public String toString() {
		return "Prerequisito [id=" + id + ", padre=" + (padre != null ? padre.getMutazioneId() : "null") + ", figlio="
				+ (figlio != null ? figlio.getMutazioneId() : "null") + "]";
	}
}

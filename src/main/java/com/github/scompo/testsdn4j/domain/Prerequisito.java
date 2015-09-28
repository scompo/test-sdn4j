package com.github.scompo.testsdn4j.domain;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity(type = Prerequisito.NAME)
public class Prerequisito extends AbstractNodeEntity{

	public static final String NAME = "PREREQUISITO";

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
		return "Prerequisito [padre=" + (padre != null ? padre.getMutazioneId() : "null") + ", figlio="
				+ (figlio != null ? figlio.getMutazioneId() : "null") + "]";
	}
}

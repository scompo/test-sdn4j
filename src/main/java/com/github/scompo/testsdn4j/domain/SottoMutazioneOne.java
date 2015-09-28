package com.github.scompo.testsdn4j.domain;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity(type = SottoMutazioneOne.NAME)
public class SottoMutazioneOne extends AbstractNodeEntity {

	public static final String NAME = "SOTTOMUTAZIONE";

	@StartNode
	private OperazioneMacroOne macroOp;

	@EndNode
	private OperazioneOne subOp;

	public SottoMutazioneOne() {

		super();
	}

	public OperazioneMacroOne getMacroOp() {
		return macroOp;
	}

	public void setMacroOp(OperazioneMacroOne macroOp) {
		this.macroOp = macroOp;
	}

	public OperazioneOne getSubOp() {
		return subOp;
	}

	public void setSubOp(OperazioneOne subOp) {
		this.subOp = subOp;
	}

	@Override
	public String toString() {
		return "SottoMutazioneOne [macroOp=" + (macroOp != null ? macroOp.getId() : "null") + ", subOp="
				+ (subOp != null ? subOp.getId() : "null") + "]";
	}
}

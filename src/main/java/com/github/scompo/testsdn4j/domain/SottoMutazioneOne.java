package com.github.scompo.testsdn4j.domain;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.StartNode;

@NodeEntity
public class SottoMutazioneOne extends AbstractNodeEntity {

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
		return "SottoMutazioneOne [macroOp=" + macroOp + ", subOp=" + subOp + "]";
	}
}

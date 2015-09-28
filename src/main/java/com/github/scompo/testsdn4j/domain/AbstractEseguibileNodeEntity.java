package com.github.scompo.testsdn4j.domain;

public abstract class AbstractEseguibileNodeEntity extends AbstractNodeEntity implements Eseguibile {

	private boolean eseguito = false;

	public AbstractEseguibileNodeEntity() {

		super();
	}

	@Override
	public boolean isEseguito() {

		return eseguito;
	}

	@Override
	public void setEseguito(boolean eseguito) {

		this.eseguito = eseguito;
	}

}

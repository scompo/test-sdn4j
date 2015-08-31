package com.github.scompo.testsdn4j.domain;

import org.neo4j.ogm.annotation.GraphId;

public abstract class AbstractNodeEntity {

	@GraphId
	private Long id;

	public AbstractNodeEntity() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "AbstractNodeEntity [id=" + id + "]";
	}
}

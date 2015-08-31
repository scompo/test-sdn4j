package com.github.scompo.testsdn4j.configuration;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.server.Neo4jServer;
import org.springframework.data.neo4j.server.RemoteServer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableNeo4jRepositories(basePackages = "com.github.scompo.testsdn4j.repositories")
@EnableTransactionManagement
public class Neo4jConfig extends Neo4jConfiguration {

	public Neo4jConfig() {

		System.setProperty("username", "neo4j");
		System.setProperty("password", "test");
	}

	@Bean
	@Override
	public SessionFactory getSessionFactory() {

		return new SessionFactory("com.github.scompo.testsdn4j.domain");
	}

	@Bean
	@Override
	public Neo4jServer neo4jServer() {

		return new RemoteServer("http://localhost:7474");
	}

}

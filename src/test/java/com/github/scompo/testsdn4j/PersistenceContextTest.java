package com.github.scompo.testsdn4j;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.test.context.ContextConfiguration;

@Retention(RetentionPolicy.RUNTIME)
@ContextConfiguration(classes = Neo4jConfigTest.class)
public @interface PersistenceContextTest {

}

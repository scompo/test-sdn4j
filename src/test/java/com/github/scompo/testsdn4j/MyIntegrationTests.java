package com.github.scompo.testsdn4j;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Retention(RetentionPolicy.RUNTIME)
@SpringApplicationConfiguration(classes = Application.class)
@Transactional(propagation = Propagation.REQUIRED)
@Rollback(value = true)
public @interface MyIntegrationTests {

}

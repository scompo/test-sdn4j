package com.github.scompo.testsdn4j;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@PersistenceContextTest
@Transactional(propagation = Propagation.REQUIRED)
@Rollback(value = true)
public class ApplicationContextTest {

	@Test
	public void shouldStart() {

		assertTrue(true);
	}
}

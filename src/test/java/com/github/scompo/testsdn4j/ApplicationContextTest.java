package com.github.scompo.testsdn4j;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@PersistenceContextTest
public class ApplicationContextTest {

	@Test
	public void shouldStart() {

		assertTrue(true);
	}
}

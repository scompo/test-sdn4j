package com.github.scompo.testsdn4j.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.scompo.testsdn4j.PersistenceContextTest;
import com.github.scompo.testsdn4j.domain.OperazioneMacroOne;
import com.github.scompo.testsdn4j.domain.Prerequisito;

@RunWith(SpringJUnit4ClassRunner.class)
@PersistenceContextTest
public class OperazioneMacroOneRepositoryTest {

	private static final long FIRST_MUTAZIONE = 1L;

	private static final long SECOND_MUTAZIONE = 2L;

	@Autowired
	private OperazioneMacroOneRepository macroOneRepository;

	@Test
	public void shouldCreateAnOperazione() {

		OperazioneMacroOne testOperazione = new OperazioneMacroOne(FIRST_MUTAZIONE);

		OperazioneMacroOne res = macroOneRepository.save(testOperazione);

		assertNotNull(res);
		assertNotNull(res.getId());
		assertEquals(FIRST_MUTAZIONE, res.getMutazioneId().longValue());
	}
	
	@Test
	public void findByMutazioneIdTest() {

		OperazioneMacroOne testOperazione = new OperazioneMacroOne(FIRST_MUTAZIONE);

		macroOneRepository.save(testOperazione);
		
		OperazioneMacroOne res = macroOneRepository.findByMutazioneId(FIRST_MUTAZIONE);

		assertNotNull(res);
		assertNotNull(res.getId());
		assertEquals(FIRST_MUTAZIONE, res.getMutazioneId().longValue());
	}

	@Test
	public void shouldAddAPrerequisito() {

		OperazioneMacroOne testOperazione1 = new OperazioneMacroOne(FIRST_MUTAZIONE);

		OperazioneMacroOne testOperazione2 = new OperazioneMacroOne(SECOND_MUTAZIONE);

		macroOneRepository.save(testOperazione1);
		macroOneRepository.save(testOperazione2);

		OperazioneMacroOne op1 = null;
		OperazioneMacroOne op2 = null;

		op1 = macroOneRepository.findByMutazioneId(FIRST_MUTAZIONE);
		op2 = macroOneRepository.findByMutazioneId(SECOND_MUTAZIONE);

		op1.getPrerequisiti().add(new Prerequisito(op2, op1));

		macroOneRepository.save(op1);

		OperazioneMacroOne res1 = macroOneRepository.findByMutazioneId(FIRST_MUTAZIONE);
		OperazioneMacroOne res2 = macroOneRepository.findByMutazioneId(SECOND_MUTAZIONE);

		assertNotNull(res1.getPrerequisiti());
		assertEquals(1, res1.getPrerequisiti().size());
		assertEquals(SECOND_MUTAZIONE, getOnlyElement(res1.getPrerequisiti()).getPadre().getMutazioneId().longValue());

		assertNotNull(res2.getPrerequisiti());
		assertTrue("prerequisiti should be empty on second mutazione", res2.getPrerequisiti().isEmpty());
	}

	public static <T> T getOnlyElement(Collection<T> collection) {

		if (collection.size() != 1) {

			fail("collection should have only one element, found: " + collection.size());
		}

		return new ArrayList<T>(collection).get(0);
	}
}

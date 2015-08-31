package com.github.scompo.testsdn4j.services;

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
import com.github.scompo.testsdn4j.domain.Operazione;
import com.github.scompo.testsdn4j.domain.Prerequisito;

@RunWith(SpringJUnit4ClassRunner.class)
@PersistenceContextTest
public class OperazioniBusinessServiceTest {

	private static final long FIRST_MUTAZIONE = 1L;

	private static final long SECOND_MUTAZIONE = 2L;

	@Autowired
	private OperazioniService operazioniService;

	@Test
	public void shouldCreateAnOperazione() {

		Operazione testOperazione = new Operazione(FIRST_MUTAZIONE);

		Operazione res = operazioniService.save(testOperazione);

		assertNotNull(res);
		assertNotNull(res.getId());
		assertEquals(FIRST_MUTAZIONE, res.getMutazioneId().longValue());
	}

	@Test
	public void shouldAddAPrerequisito() {

		Operazione testOperazione1 = new Operazione(FIRST_MUTAZIONE);

		Operazione testOperazione2 = new Operazione(SECOND_MUTAZIONE);

		operazioniService.save(testOperazione1);
		operazioniService.save(testOperazione2);

		Operazione op1 = null;
		Operazione op2 = null;

		op1 = operazioniService.getByMutazioneId(FIRST_MUTAZIONE);
		op2 = operazioniService.getByMutazioneId(SECOND_MUTAZIONE);

		op1.getPrerequisiti().add(new Prerequisito(op2, op1));

		operazioniService.save(op1);

		Operazione res1 = operazioniService.getByMutazioneId(FIRST_MUTAZIONE);
		Operazione res2 = operazioniService.getByMutazioneId(SECOND_MUTAZIONE);

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

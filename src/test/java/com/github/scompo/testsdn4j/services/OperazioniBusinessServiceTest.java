package com.github.scompo.testsdn4j.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.scompo.testsdn4j.PersistenceContextTest;
import com.github.scompo.testsdn4j.domain.Operazione;

@RunWith(SpringJUnit4ClassRunner.class)
@PersistenceContextTest
public class OperazioniBusinessServiceTest {
	
	private static final long FIRST_MUTAZIONE = 1L;
	
	@Autowired
	private OperazioniService operazioniService;

	@Test
	public void shouldCreateAnOperazione(){
		
		Operazione testOperazione = new Operazione();
		
		testOperazione.setMutazioneId(FIRST_MUTAZIONE);
		
		Operazione res = operazioniService.save(testOperazione);
		
		assertNotNull(res);
		assertNotNull(res.getId());
		assertEquals(FIRST_MUTAZIONE, res.getMutazioneId().longValue());
	}
}

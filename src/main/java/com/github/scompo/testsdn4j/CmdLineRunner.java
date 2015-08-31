package com.github.scompo.testsdn4j;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.scompo.testsdn4j.domain.Operazione;
import com.github.scompo.testsdn4j.domain.Prerequisito;
import com.github.scompo.testsdn4j.services.OperazioniService;

@Component
public class CmdLineRunner implements CommandLineRunner {

	private Map<Long, Collection<Long>> data = new HashMap<Long, Collection<Long>>();

	@Autowired
	private OperazioniService operazioniService;

	@Override
	public void run(String... args) throws Exception {

		data.put(1L, Arrays.asList(2L));
		data.put(2L, Arrays.asList(3L, 4L));
		data.put(3L, Collections.emptyList());
		data.put(4L, Arrays.asList(5L));
		data.put(5L, Collections.emptyList());

		for (Long id : data.keySet()) {

			operazioniService.save(new Operazione(id));
		}

		for (Entry<Long, Collection<Long>> entry : data.entrySet()) {

			Long idPadre = entry.getKey();

			Operazione padre = operazioniService.getById(idPadre);

			Collection<Long> figli = entry.getValue();

			for (Long figlioId : figli) {

				Operazione figlio = operazioniService.getById(figlioId);

				figlio.getPrerequisiti().add(new Prerequisito(padre, figlio));
				operazioniService.save(figlio);
			}
		}
	}

}

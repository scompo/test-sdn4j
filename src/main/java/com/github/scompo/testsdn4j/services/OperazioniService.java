package com.github.scompo.testsdn4j.services;

import com.github.scompo.testsdn4j.domain.Operazione;

public interface OperazioniService {

	Operazione save(Operazione testOperazione);

	Operazione getById(Long id);

	Operazione getByMutazioneId(Long idPadre);

}

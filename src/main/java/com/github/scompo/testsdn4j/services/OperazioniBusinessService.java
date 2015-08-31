package com.github.scompo.testsdn4j.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.scompo.testsdn4j.domain.Operazione;
import com.github.scompo.testsdn4j.repositories.OperazioniRepository;

@Service
@Transactional
public class OperazioniBusinessService implements OperazioniService {

	@Autowired
	private OperazioniRepository operazioniRepository;

	@Override
	public Operazione save(Operazione testOperazione) {

		return operazioniRepository.save(testOperazione);
	}

	@Override
	public Operazione getById(Long id){
		
		return operazioniRepository.findOne(id);
	}

	@Override
	public Operazione getByMutazioneId(Long idPadre) {
		
		return operazioniRepository.findByMutazioneId(idPadre);
	}
}

package com.github.scompo.testsdn4j.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.scompo.testsdn4j.domain.Operazione;
import com.github.scompo.testsdn4j.repositories.OperazioniRepository;

@Service
@Transactional
public class OperazioniBusinessService implements OperazioniService{

	@Autowired
	private OperazioniRepository operazioniRepository;

	@Override
	public Operazione save(Operazione testOperazione) {
		
		return null;
	}

}

package br.com.Ti.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.Ti.entities.AutomoveisModel;
import br.com.Ti.repository.AutormoveisRepository;
import br.com.Ti.services.AutomovelService;

@Service
public class AutomovelServiceImplemts implements AutomovelService {

	@Autowired
	private AutormoveisRepository arp;
	
	@Override
	public List<AutomoveisModel> listAll(Pageable pageable) {
		var page = arp.findAll(pageable).getContent();

		return page;
	}

	@Override
	public boolean update(AutomoveisModel automovel) {
		try {
			arp.save(automovel);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public AutomoveisModel getId(Long id) {		
		return arp.findById(id).get();
	}

	@Override
	public AutomoveisModel salvar(AutomoveisModel automovel) {
		arp.save(automovel);
		return automovel;
	}

	@Override
	public void delete(Long id) {
		arp.deleteById(id);
		
	}

	
}

package br.com.Ti.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

import br.com.Ti.entities.AutomoveisModel;

public interface AutomovelService {
	
List<AutomoveisModel> listAll(Pageable pageable);

boolean update(AutomoveisModel automovel);

AutomoveisModel getId(Long id);

AutomoveisModel salvar(AutomoveisModel automovel);

void delete(Long id);
}

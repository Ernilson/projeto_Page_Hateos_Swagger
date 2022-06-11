package br.com.Ti.services.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import br.com.Ti.entities.AutomoveisModel;
import br.com.Ti.exceptions.EntityNotFoundException;
import br.com.Ti.services.impl.AutomovelServiceImplemts;

@RestController
@RequestMapping(value = "/car")
public class AutomovelController {

	@Autowired
	private AutomovelServiceImplemts automovel;

	@GetMapping
	public List<AutomoveisModel> listAll(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit,
			@RequestParam(value = "direction", defaultValue = "asc") String direction) {
		var sortDirection = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC;
		Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, "id"));
		List<AutomoveisModel> lts = automovel.listAll(pageable);
		if (lts.isEmpty()) {
			throw new EntityNotFoundException("Nada encontrado!");
		} else {
			for (AutomoveisModel auto : lts) {				
				auto.add(linkTo(methodOn(AutomovelController.class).findById(auto.getid())).withRel("Lista de Automoveis"));  //.withSelfRel());
			}
		}
		return automovel.listAll(pageable);
		//return lts;
	}

	@RequestMapping(value = "/{id}")
	public ResponseEntity findById(@PathVariable Long id) {		
		AutomoveisModel auto = automovel.getId(id);		
		if (auto.equals(null)) {
			throw new EntityNotFoundException("Id não pode ser vazio!");
		}else {
			auto.add(linkTo(methodOn(AutomovelController.class).listAll(0, 10, "asc")).withRel("Lista de Automoveis"));
		}
		return ResponseEntity.ok(auto);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity savar(@RequestBody AutomoveisModel auto) {
		automovel.salvar(auto);
		return ResponseEntity.ok("Ok");
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable("id") Long id) {
		AutomoveisModel auto = automovel.getId(id);
		if (auto.equals(null)) {
			throw new EntityNotFoundException("Id não pode ser vazio!");
		}
		automovel.delete(id);
		ResponseEntity.ok().build();
	}
}

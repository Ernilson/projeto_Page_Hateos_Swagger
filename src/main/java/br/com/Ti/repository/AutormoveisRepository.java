package br.com.Ti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.Ti.entities.AutomoveisModel;

@Repository
public interface AutormoveisRepository extends JpaRepository<AutomoveisModel, Long> {

}

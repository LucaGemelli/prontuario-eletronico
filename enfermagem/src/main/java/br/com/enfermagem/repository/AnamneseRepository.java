package br.com.enfermagem.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.enfermagem.model.Anamnese;

public interface AnamneseRepository extends PagingAndSortingRepository<Anamnese, Long> {

}

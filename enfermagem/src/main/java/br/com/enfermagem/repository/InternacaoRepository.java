package br.com.enfermagem.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.enfermagem.model.Internacao;

public interface InternacaoRepository extends PagingAndSortingRepository<Internacao, Long> {
}

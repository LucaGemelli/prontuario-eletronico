package br.com.enfermagem.repository;

import br.com.enfermagem.model.Pacientes;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PacientesRepository extends PagingAndSortingRepository<Pacientes, Long> {
}

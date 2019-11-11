package br.com.enfermagem.repository;

import br.com.enfermagem.model.Paciente;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PacientesRepository extends PagingAndSortingRepository<Paciente, Long> {
}

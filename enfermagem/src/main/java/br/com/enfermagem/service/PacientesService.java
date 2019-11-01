package br.com.enfermagem.service;

import br.com.enfermagem.model.Pacientes;
import br.com.enfermagem.repository.PacientesRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PacientesService {

    private final PacientesRepository pacientesRepository;

    public PacientesService(PacientesRepository pacientesRepository) {
        this.pacientesRepository = pacientesRepository;
    }

    public Page<Pacientes> findAll(Pageable pageable){
        return pacientesRepository.findAll(pageable);
    }
}

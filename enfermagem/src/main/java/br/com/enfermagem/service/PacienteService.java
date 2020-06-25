package br.com.enfermagem.service;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.enfermagem.exception.NotFoundException;
import br.com.enfermagem.model.Paciente;
import br.com.enfermagem.repository.PacienteRepository;

@Service
public class PacienteService {

    private final PacienteRepository repository;

    public PacienteService(final PacienteRepository repository) {
        this.repository = repository;
    }

    public Page<Paciente> findAll(final Pageable pageable) {
         return repository.findAll(pageable);
    }

    public Paciente findById(final Long id) {
        return this.findPacienteById(id);
    }

    public Long save(final Paciente dto) {
        if (Objects.isNull(dto.getDataHora())) {
            dto.setDataHora(LocalDateTime.now());
        }
        return repository.save(dto).getId();
    }

    public Long update(final Paciente dto) {
        this.findPacienteById(dto.getId());
        return repository.save(dto).getId();
    }

    public Long delete(Long id) {
        this.findPacienteById(id);
        this.repository.deleteById(id);
        return id;
    }

    private Paciente findPacienteById(final Long id) {
        return repository.findById(id)
                         .orElseThrow(() -> new NotFoundException("Paciente não encontrado!"));
    }
}

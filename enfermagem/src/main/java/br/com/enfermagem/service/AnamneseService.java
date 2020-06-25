package br.com.enfermagem.service;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.enfermagem.exception.NotFoundException;
import br.com.enfermagem.model.Anamnese;
import br.com.enfermagem.repository.AnamneseRepository;

@Service
public class AnamneseService {

    private final AnamneseRepository repository;

    public AnamneseService(final AnamneseRepository repository) {
        this.repository = repository;
    }

    public Page<Anamnese> findAll(final Pageable pageable) {
         return repository.findAll(pageable);
    }

    public Anamnese findById(final Long id) {
        return this.findPacienteById(id);
    }

    public Long save(final Anamnese dto) {
        if (Objects.isNull(dto.getDataHoraCriacao())) {
            dto.setDataHoraCriacao(LocalDateTime.now());
        }
        return repository.save(dto).getId();
    }

    public Long update(final Anamnese dto) {
        this.findPacienteById(dto.getId());
        return repository.save(dto).getId();
    }

    public Long delete(Long id) {
        this.findPacienteById(id);
        this.repository.deleteById(id);
        return id;
    }

    private Anamnese findPacienteById(final Long id) {
        return repository.findById(id)
                         .orElseThrow(() -> new NotFoundException("Paciente não encontrado!"));
    }
}

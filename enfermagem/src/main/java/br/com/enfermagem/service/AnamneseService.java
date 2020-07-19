package br.com.enfermagem.service;

import br.com.enfermagem.exception.NotFoundException;
import br.com.enfermagem.model.Anamnese;
import br.com.enfermagem.repository.AnamneseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
        return findAnamneseById(id);
    }

    public Long save(final Anamnese dto) {
        return repository.save(dto).getId();
    }

    public Long update(final Anamnese dto) {
        findAnamneseById(dto.getId());
        return repository.save(dto).getId();
    }

    public Long delete(Long id) {
        this.findAnamneseById(id);
        this.repository.deleteById(id);
        return id;
    }

    private Anamnese findAnamneseById(final Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Anamnese não encontrada!"));
    }
}

package br.com.enfermagem.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.enfermagem.exception.NotFoundException;
import br.com.enfermagem.model.SinaisVitais;
import br.com.enfermagem.repository.SinaisVitaisRepository;

@Service
public class SinaisVitaisService  {

    private final SinaisVitaisRepository repository;

    public SinaisVitaisService(SinaisVitaisRepository repository) {
        this.repository = repository;
    }

    public Page<SinaisVitais> findAll(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

    public SinaisVitais findFluxoById(Long id) {
        return this.repository.findById(id).orElseThrow(() -> new NotFoundException("Fluxo24hs não encontrado!"));
    }

    public Long save(SinaisVitais dto) {
        return this.repository.save(dto).getId();
    }

    public Long update(SinaisVitais dto) {
        this.findFluxoById(dto.getId());
        return this.repository.save(dto).getId();
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }
}

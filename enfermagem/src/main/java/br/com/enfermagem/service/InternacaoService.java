package br.com.enfermagem.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.enfermagem.exception.NotFoundException;
import br.com.enfermagem.model.Internacao;
import br.com.enfermagem.repository.InternacaoRepository;

@Service
public class InternacaoService {

    private final InternacaoRepository repository;

    public InternacaoService(InternacaoRepository repository) {
        this.repository = repository;
    }

    public Page<Internacao> findAll(Pageable pageable) {
        return  this.repository.findAll(pageable);
    }

    public Internacao findInternacaoById(Long id) {
        return this.repository.findById(id).orElseThrow(() -> new NotFoundException("Evolução não encontrada!"));
    }

    public Long save(Internacao dto) {
        return this.repository.save(dto).getId();
    }

    public Long update(Internacao dto) {
        this.findInternacaoById(dto.getId());
        return this.repository.save(dto).getId();
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }
}

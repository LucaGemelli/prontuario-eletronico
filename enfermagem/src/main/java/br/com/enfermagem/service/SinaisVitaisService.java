package br.com.enfermagem.service;

import br.com.enfermagem.exception.BusinessException;
import br.com.enfermagem.exception.NotFoundException;
import br.com.enfermagem.model.SinaisVitais;
import br.com.enfermagem.repository.SinaisVitaisRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class SinaisVitaisService {

    private final SinaisVitaisRepository repository;
    private final InternacaoService internacaoService;

    public SinaisVitaisService(SinaisVitaisRepository repository, InternacaoService internacaoService) {
        this.repository = repository;
        this.internacaoService = internacaoService;
    }

    public Page<SinaisVitais> findAll(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

    public SinaisVitais findSinalVitalById(Long id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Sinal Vital não encontrado!"));
    }

    public Long save(SinaisVitais dto) {
        findInternacaoBySinaisVitais(dto);
        return this.repository.save(dto).getId();
    }

    public Long update(SinaisVitais dto) {
        this.findSinalVitalById(dto.getId());
        findInternacaoBySinaisVitais(dto);
        return this.repository.save(dto).getId();
    }

    public void delete(Long id) {
        findSinalVitalById(id);
        this.repository.deleteById(id);
    }

    public void findInternacaoBySinaisVitais(SinaisVitais dto) {
        if (Objects.isNull(dto.getInternacao())) {
            throw new BusinessException("Preencher Campo INTERNAÇÃO");
        }

        internacaoService.findInternacaoById(dto.getInternacao().getId());
    }
}

package br.com.enfermagem.service;

import br.com.enfermagem.exception.BusinessException;
import br.com.enfermagem.exception.NotFoundException;
import br.com.enfermagem.model.Internacao;
import br.com.enfermagem.repository.InternacaoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class InternacaoService {

    private final InternacaoRepository repository;
    private final AnamneseService anamneseService;

    public InternacaoService(InternacaoRepository repository, AnamneseService anamneseService) {
        this.repository = repository;
        this.anamneseService = anamneseService;
    }

    public Page<Internacao> findAll(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

    public Internacao findInternacaoById(Long id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Internação não encontrada!"));
    }

    public Long save(Internacao dto) {
        findAnamneseByInternacao(dto);
        return this.repository.save(dto).getId();
    }

    public Long update(Internacao dto) {
        this.findInternacaoById(dto.getId());
        findAnamneseByInternacao(dto);
        return this.repository.save(dto).getId();
    }

    public void delete(Long id) {
        findInternacaoById(id);
        this.repository.deleteById(id);
    }

    public void findAnamneseByInternacao(Internacao dto) {
        if (Objects.isNull(dto.getAnamnese())) {
            throw new BusinessException("Preencher Campo ANAMNESE");
        }

        anamneseService.findById(dto.getAnamnese().getId());
    }
}

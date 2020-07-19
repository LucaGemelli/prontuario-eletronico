package br.com.enfermagem.service;

import br.com.enfermagem.exception.BusinessException;
import br.com.enfermagem.exception.NotFoundException;
import br.com.enfermagem.model.Evolucao;
import br.com.enfermagem.repository.EvolucaoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class EvolucaoService {

    private final EvolucaoRepository repository;
    private final InternacaoService internacaoService;

    public EvolucaoService(EvolucaoRepository repository, InternacaoService internacaoService) {
        this.repository = repository;
        this.internacaoService = internacaoService;
    }

    public Page<Evolucao> findAll(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

    public Evolucao findEvolucaoById(Long id) {
        return this.repository.findById(id).orElseThrow(() -> new NotFoundException("Evolução não encontrada!"));
    }

    public Long save(Evolucao dto) {
        findInternacaoByEvolucao(dto);
        return this.repository.save(dto).getId();
    }

    public Long update(Evolucao dto) {
        findEvolucaoById(dto.getId());
        findInternacaoByEvolucao(dto);
        return this.repository.save(dto).getId();
    }

    public void delete(Long id) {
        findEvolucaoById(id);
        this.repository.deleteById(id);
    }

    public void findInternacaoByEvolucao(Evolucao dto) {
        if (Objects.isNull(dto.getInternacao())) {
            throw new BusinessException("Preencher Campo INTERNAÇÃO");
        }

        internacaoService.findInternacaoById(dto.getInternacao().getId());
    }
}

package br.com.enfermagem.service;

import br.com.enfermagem.exception.BusinessException;
import br.com.enfermagem.exception.NotFoundException;
import br.com.enfermagem.model.Anamnese;
import br.com.enfermagem.repository.AnamneseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AnamneseService {

    private final AnamneseRepository repository;
    private final InternacaoService internacaoService;

    public AnamneseService(final AnamneseRepository repository, InternacaoService internacaoService) {
        this.repository = repository;
        this.internacaoService = internacaoService;
    }

    public Page<Anamnese> findAll(final Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Anamnese findById(final Long id) {
        return findAnamneseById(id);
    }

    public Long save(final Anamnese dto) {
        findInternacaoById(dto);
        return repository.save(dto).getId();
    }

    public Long update(final Anamnese dto) {
        findAnamneseById(dto.getId());
        findInternacaoById(dto);
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

    private void findInternacaoById(Anamnese dto) {
        if (Objects.isNull(dto.getInternacao())) {
            throw new BusinessException("O campo internação deve ser informado!");
        }

        internacaoService.findInternacaoById(dto.getInternacao().getId());
    }
}

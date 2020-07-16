package br.com.enfermagem.service;

import br.com.enfermagem.exception.BusinessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.enfermagem.exception.NotFoundException;
import br.com.enfermagem.model.Evolucao;
import br.com.enfermagem.repository.EvolucaoRepository;

import java.util.Objects;

@Service
public class EvolucaoService {

    private final EvolucaoRepository repository;
    private final AnamneseService anamneseService;

    public EvolucaoService(EvolucaoRepository repository, AnamneseService anamneseService) {
        this.repository = repository;
        this.anamneseService = anamneseService;
    }

    public Page<Evolucao> findAll(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

    public Evolucao findEvolucaoById(Long id) {
        return this.repository.findById(id).orElseThrow(() -> new NotFoundException("Evolução não encontrada!"));
    }

    public Long save(Evolucao dto) {
   //     findAnamneseById(dto);
        return this.repository.save(dto).getId();
    }

    public Long update(Evolucao dto) {
        findEvolucaoById(dto.getId());
 //       findAnamneseById(dto);
        return this.repository.save(dto).getId();
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

//    public void findAnamneseById(Evolucao dto) {
//        if (Objects.isNull(dto.getAnamnese())) {
//            throw new BusinessException("O campo anamnese deve ser informado!");
//        }
//
//        anamneseService.findById(dto.getAnamnese().getId());
//    }
}

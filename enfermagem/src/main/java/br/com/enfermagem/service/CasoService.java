package br.com.enfermagem.service;

import br.com.enfermagem.exception.BusinessException;
import br.com.enfermagem.exception.InvalidFieldException;
import br.com.enfermagem.exception.NotFoundException;
import br.com.enfermagem.model.Caso;
import br.com.enfermagem.model.Paciente;
import br.com.enfermagem.repository.CasoRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class CasoService {

    private final CasoRepository casoRepository;
    private final PacienteService pacienteService;

    public CasoService(CasoRepository casoRepository, PacienteService pacienteService) {
        this.casoRepository = casoRepository;
        this.pacienteService = pacienteService;
    }

    public Page<Caso> findAll(Pageable pageable) {
        return casoRepository.findAll(pageable);
    }

    public Caso findById(Long id) {
        return findCasoById(id);
    }

    public Caso save(Caso caso) {
        validateFields(caso);

        if (Objects.isNull(caso.getDataHora())) {
            caso.setDataHora(LocalDateTime.now());
        }

        setCodeCaso(caso);
        return casoRepository.save(caso);
    }

    public Caso update(Caso caso) {
        findCasoById(caso.getId());
        validateFields(caso);
        setCodeCaso(caso);
        return casoRepository.save(caso);
    }

    public void delete(Long id) {
        findCasoById(id);
        List<Paciente> pacientesByIdCaso = pacienteService.findPacientesByIdCaso(id);

        if (!pacientesByIdCaso.isEmpty()) {
            throw new BusinessException("Não é possível excluir um caso referente a um paciente");
        }

        casoRepository.deleteById(id);
    }

    private void setCodeCaso(Caso caso) {
        caso.setCode(UUID.randomUUID().toString().toUpperCase().substring(0, 5));
    }

    private Caso findCasoById(Long id) {
        return casoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Caso não encontrado!"));
    }

    private void validateFields(Caso caso) {
        if (StringUtils.isBlank(caso.getIdentificacao())) {
            throw new InvalidFieldException("O campo Identificação deve ser preenchido");
        }
    }
}

package br.com.enfermagem.service;

import br.com.enfermagem.exception.InvalidFieldException;
import br.com.enfermagem.exception.NotFoundException;
import br.com.enfermagem.model.QuadroPaciente;
import br.com.enfermagem.repository.QuadroPacienteRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class QuadroPacienteService {

    private final QuadroPacienteRepository quadroPacienteRepository;

    public QuadroPacienteService(QuadroPacienteRepository quadroPacienteRepository) {
        this.quadroPacienteRepository = quadroPacienteRepository;
    }

    public Page<QuadroPaciente> findAll(Pageable pageable) {
        return quadroPacienteRepository.findAll(pageable);
    }

    public QuadroPaciente findById(Long id) {
        return findQuadroPacienteById(id);
    }

    public QuadroPaciente save(QuadroPaciente quadroPaciente) {
        validateFields(quadroPaciente);

        if (Objects.isNull(quadroPaciente.getDataHora())) {
            quadroPaciente.setDataHora(LocalDateTime.now());
        }

        return quadroPacienteRepository.save(quadroPaciente);
    }

    public QuadroPaciente update(QuadroPaciente quadroPaciente) {
        validateFields(quadroPaciente);
        findQuadroPacienteById(quadroPaciente.getId());
        return quadroPacienteRepository.save(quadroPaciente);
    }

    public void delete(Long id) {
        findQuadroPacienteById(id);
        quadroPacienteRepository.deleteById(id);
    }

    private QuadroPaciente findQuadroPacienteById(Long id) {
        return quadroPacienteRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Quadro paciente não encontrado!"));
    }

    private void validateFields(QuadroPaciente quadroPaciente) {
        if (StringUtils.isBlank(quadroPaciente.getDescricao())) {
            throw new InvalidFieldException("O campo descrição deve ser preenchido");
        }
    }
}

package br.com.enfermagem.service;

import br.com.enfermagem.exception.NotFoundException;
import br.com.enfermagem.model.Paciente;
import br.com.enfermagem.repository.PacientesRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Service
public class PacienteService {

    private final PacientesRepository pacientesRepository;

    public PacienteService(PacientesRepository pacientesRepository) {
        this.pacientesRepository = pacientesRepository;
    }

    public Page<Paciente> findAll(Pageable pageable) {
        return pacientesRepository.findAll(pageable);
    }

    public Optional<Paciente> findById(Long id) {
        verifyIfPacienteExistsById(id);
        return pacientesRepository.findById(id);
    }

    public Paciente save(Paciente paciente) {
        if (Objects.isNull(paciente.getDataHora())) {
            paciente.setDataHora(LocalDateTime.now());
        }

        return pacientesRepository.save(paciente);
    }

    public Paciente update(Paciente paciente) {
        verifyIfPacienteExistsById(paciente.getId());
        return pacientesRepository.save(paciente);
    }

    private void verifyIfPacienteExistsById(Long id) {
        if (!pacientesRepository.existsById(id))
            throw new NotFoundException("Paciente não encontrado!");
    }

    public void delete(Long id) {
        pacientesRepository.deleteById(id);
    }
}

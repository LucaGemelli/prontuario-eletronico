package br.com.enfermagem.service;

import br.com.enfermagem.exception.NotFoundException;
import br.com.enfermagem.model.Paciente;
import br.com.enfermagem.repository.PacienteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Page<Paciente> findAll(Pageable pageable) {
        return pacienteRepository.findAll(pageable);
    }

    public Optional<Paciente> findById(Long id) {
        verifyIfPacienteExistsById(id);
        return pacienteRepository.findById(id);
    }

    public Paciente save(Paciente paciente) {
        if (Objects.isNull(paciente.getDataHora())) {
            paciente.setDataHora(LocalDateTime.now());
        }
        return pacienteRepository.save(paciente);
    }

    public Paciente update(Paciente paciente) {
        verifyIfPacienteExistsById(paciente.getId());
        return pacienteRepository.save(paciente);
    }

    private void verifyIfPacienteExistsById(Long id) {
        if (!pacienteRepository.existsById(id))
            throw new NotFoundException("Paciente não encontrado!");
    }

    public void delete(Long id) {
        verifyIfPacienteExistsById(id);
        pacienteRepository.deleteById(id);
    }

    //TODO verificar necessidade desse método de consulta
    public List<Paciente> findPacientesByIdUsuario(Long id) {
        Spliterator<Paciente> spliterator = pacienteRepository.findAll().spliterator();
        List<Paciente> pacienteList = StreamSupport.stream(spliterator, false)
                .filter(paciente -> Objects.equals(paciente.getUsuario().getId(), id))
                .collect(Collectors.toList());

        if (pacienteList.isEmpty()) {
            throw new NotFoundException("Não foi encontrado nenhum paciente com o ID de usuário informado!");
        }

        return pacienteList;
    }
}

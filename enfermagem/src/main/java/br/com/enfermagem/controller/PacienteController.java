package br.com.enfermagem.controller;

import br.com.enfermagem.model.Paciente;
import br.com.enfermagem.service.PacienteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/enfermagem/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping
    public Page<Paciente> findAll(Pageable pageable) {
        return pacienteService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Paciente findById(@PathVariable Long id) {
        return pacienteService.findById(id);
    }

    @PostMapping
    public Paciente save(@Valid @RequestBody Paciente paciente) {
        return pacienteService.save(paciente);
    }

    @PutMapping
    public Paciente update(@Valid @RequestBody Paciente paciente) {
        return pacienteService.update(paciente);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        pacienteService.delete(id);
    }

    @GetMapping("/usuarios/{id}")
    public List<Paciente> findPacientesByIdUsuario(@PathVariable Long id) {
        return pacienteService.findPacientesByIdUsuario(id);
    }
}

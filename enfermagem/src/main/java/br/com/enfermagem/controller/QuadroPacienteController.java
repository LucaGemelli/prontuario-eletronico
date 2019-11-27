package br.com.enfermagem.controller;

import br.com.enfermagem.model.QuadroPaciente;
import br.com.enfermagem.service.QuadroPacienteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/enfermagem/quadroPaciente")
public class QuadroPacienteController {

    private final QuadroPacienteService quadroPacienteService;

    public QuadroPacienteController(QuadroPacienteService quadroPacienteService) {
        this.quadroPacienteService = quadroPacienteService;
    }

    @GetMapping
    public Page<QuadroPaciente> findAll(Pageable pageable){
        return quadroPacienteService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public QuadroPaciente findById(@PathVariable Long id){
        return quadroPacienteService.findById(id);
    }

    @PostMapping
    public QuadroPaciente save(@Valid @RequestBody QuadroPaciente quadroPaciente){
        return quadroPacienteService.save(quadroPaciente);
    }

    @PutMapping
    public QuadroPaciente update(@Valid @RequestBody QuadroPaciente quadroPaciente){
        return quadroPacienteService.update(quadroPaciente);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        quadroPacienteService.delete(id);
    }

}

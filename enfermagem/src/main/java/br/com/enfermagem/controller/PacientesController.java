package br.com.enfermagem.controller;

import br.com.enfermagem.model.Pacientes;
import br.com.enfermagem.service.PacientesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/enfermagem")
public class PacientesController {

    private final PacientesService pacientesService;

    public PacientesController(PacientesService pacientesService) {
        this.pacientesService = pacientesService;
    }

    @GetMapping("pacientes")
    public Page<Pacientes> findAll(Pageable pageable){
        return pacientesService.findAll(pageable);
    }
}

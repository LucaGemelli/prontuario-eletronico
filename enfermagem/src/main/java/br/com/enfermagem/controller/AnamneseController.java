package br.com.enfermagem.controller;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.enfermagem.model.Anamnese;
import br.com.enfermagem.service.AnamneseService;

@RestController
@RequestMapping("/pacientes")
public class AnamneseController {

    private final AnamneseService anamneseService;

    public AnamneseController(AnamneseService pacienteService) {
        this.anamneseService = pacienteService;
    }

    @GetMapping
    public ResponseEntity<Page<Anamnese>> findAll(final Pageable pageable) {
        return new ResponseEntity<>(anamneseService.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Anamnese> findById(@PathVariable Long id) {
        return new ResponseEntity<>(anamneseService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> save(@Valid @RequestBody Anamnese dto) {
        return new ResponseEntity<>(anamneseService.save(dto), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Long> update(@Valid @RequestBody Anamnese dto) {
        return new ResponseEntity<>(anamneseService.update(dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        return new ResponseEntity<>(anamneseService.delete(id), HttpStatus.OK);
    }

}

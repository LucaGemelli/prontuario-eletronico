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

import br.com.enfermagem.model.SinaisVitais;
import br.com.enfermagem.service.SinaisVitaisService;

@RestController
@RequestMapping("/fluxo24hs")
public class SinaisVitaisController {

    private final SinaisVitaisService sinaisVitaisService;

    public SinaisVitaisController(SinaisVitaisService fluxo24hsService) {
        this.sinaisVitaisService = fluxo24hsService;
    }

    @GetMapping
    public ResponseEntity<Page<SinaisVitais>> findAll(Pageable pageable) {
        return new ResponseEntity<>(this.sinaisVitaisService.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SinaisVitais> findById(@PathVariable Long id) {
        return new ResponseEntity<>(this.sinaisVitaisService.findFluxoById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> save(@RequestBody @Valid SinaisVitais dto) {
        return new ResponseEntity<>(this.sinaisVitaisService.save(dto), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Long> update(@RequestBody @Valid SinaisVitais dto) {
        return new ResponseEntity<>(this.sinaisVitaisService.update(dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        this.sinaisVitaisService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}

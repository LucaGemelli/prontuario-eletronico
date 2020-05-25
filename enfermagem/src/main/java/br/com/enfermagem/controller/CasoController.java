package br.com.enfermagem.controller;

import br.com.enfermagem.model.Caso;
import br.com.enfermagem.service.CasoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/casos")
public class CasoController {

    private final CasoService casoService;

    public CasoController(CasoService casoService) {
        this.casoService = casoService;
    }

    @GetMapping
    public Page<Caso> findAll(Pageable pageable) {
        return casoService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Caso findById(@PathVariable Long id) {
        return casoService.findById(id);
    }

    @PostMapping
    public Caso save(@Valid @RequestBody Caso caso) {
        return casoService.save(caso);
    }

    @PutMapping
    public Caso update(@Valid @RequestBody Caso caso){
        return casoService.update(caso);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        casoService.delete(id);
    }
}

package br.com.enfermagem.controller;

import br.com.enfermagem.dto.ComentarioDTO;
import br.com.enfermagem.model.Comentario;
import br.com.enfermagem.service.ComentarioService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    private final ComentarioService comentarioService;

    public ComentarioController(ComentarioService comentarioService) {
        this.comentarioService = comentarioService;
    }

    @GetMapping
    public Page<Comentario> findAll(Pageable pageable){
        return this.comentarioService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Comentario findById(@PathVariable Long id) {
        return this.comentarioService.findById(id);
    }

    @PostMapping
    public ComentarioDTO save(@RequestBody @Valid ComentarioDTO dto) {
        return this.comentarioService.save(dto);
    }

    @PutMapping
    public ComentarioDTO update(@RequestBody @Valid ComentarioDTO dto){
        return this.comentarioService.update(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        this.comentarioService.delete(id);
    }

}

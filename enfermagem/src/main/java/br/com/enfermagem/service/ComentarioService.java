package br.com.enfermagem.service;

import br.com.enfermagem.converter.ComentarioConverter;
import br.com.enfermagem.dto.ComentarioDTO;
import br.com.enfermagem.exception.NotFoundException;
import br.com.enfermagem.model.Comentario;
import br.com.enfermagem.repository.ComentarioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;
    private final ComentarioConverter comentarioConverter;

    public ComentarioService(ComentarioRepository comentarioRepository, ComentarioConverter comentarioConverter) {
        this.comentarioRepository = comentarioRepository;
        this.comentarioConverter = comentarioConverter;
    }

    public Page<Comentario> findAll(Pageable pageable) {
        return this.comentarioRepository.findAll(pageable);
    }

    public Comentario findById(Long id) {
        return findComentarioById(id);
    }

    private Comentario findComentarioById(Long id) {
        return this.comentarioRepository.findById(id).orElseThrow(() -> new NotFoundException("Comentário não encontrado!"));
    }

    public ComentarioDTO save(ComentarioDTO dto) {
        Comentario comentario = this.comentarioConverter.convertToEntity(dto);
        Comentario savedComentario = this.comentarioRepository.save(comentario);
        return this.comentarioConverter.convertToDTO(savedComentario);
    }

    public ComentarioDTO update(ComentarioDTO dto) {
        Comentario comentario = this.comentarioConverter.convertToEntity(dto);
        this.findComentarioById(comentario.getId());
        Comentario updatedComentario = this.comentarioRepository.save(comentario);
        return this.comentarioConverter.convertToDTO(updatedComentario);
    }

    public void delete(Long id) {
        this.comentarioRepository.deleteById(id);
    }
}

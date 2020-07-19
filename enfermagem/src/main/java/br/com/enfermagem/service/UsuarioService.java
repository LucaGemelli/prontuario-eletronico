package br.com.enfermagem.service;

import br.com.enfermagem.exception.NotFoundException;
import br.com.enfermagem.model.Usuario;
import br.com.enfermagem.repository.UsuarioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(final UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Page<Usuario> findAll(final Pageable pageable) {
        return usuarioRepository.findAll(pageable);
    }

    public Usuario findById(Long id) {
        return findUsuarioById(id);
    }

    public Long save(final Usuario dto) {
        if (Objects.isNull(dto.getDataHoraCriacao())) {
            dto.setDataHoraCriacao(LocalDateTime.now());
        }

        return usuarioRepository.save(dto).getId();
    }

    public Long update(Usuario dto) {
        findUsuarioById(dto.getId());
        return usuarioRepository.save(dto).getId();
    }

    public void delete(Long id) {
        findUsuarioById(id);
        usuarioRepository.deleteById(id);
    }

    private Usuario findUsuarioById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado!"));
    }
}

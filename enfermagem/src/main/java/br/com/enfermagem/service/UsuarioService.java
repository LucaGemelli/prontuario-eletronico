package br.com.enfermagem.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.enfermagem.exception.MessageListException;
import br.com.enfermagem.exception.NotFoundException;
import br.com.enfermagem.model.Usuario;
import br.com.enfermagem.repository.UsuarioRepository;

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
        this.validateFields(dto);

        if (Objects.isNull(dto.getDataHoraCriacao())) {
            dto.setDataHoraCriacao(LocalDateTime.now());
        }

        return usuarioRepository.save(dto).getId();
    }

    public Long update(Usuario dto) {
        findUsuarioById(dto.getId());
        this.validateFields(dto);
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

    private void validateFields(final Usuario dto) {
        List<String> exceptions = new ArrayList<>();

        if (StringUtils.isBlank(dto.getSenha())) {
            exceptions.add("O campo senha deve ser preenchido");
        }

        if (StringUtils.isBlank(dto.getNome())) {
            exceptions.add("O campo nome deve ser preenchido");
        }

        if (StringUtils.isBlank(dto.getEmail())) {
            exceptions.add("O campo e-mail deve ser preenchido");
        }

        if (!exceptions.isEmpty()) {
            throw new MessageListException(exceptions);
        }
    }
}

package br.com.enfermagem.service;

import br.com.enfermagem.exception.MessageListException;
import br.com.enfermagem.exception.NotFoundException;
import br.com.enfermagem.model.Usuario;
import br.com.enfermagem.repository.UsuarioRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Page<Usuario> findAll(Pageable pageable) {
        return usuarioRepository.findAll(pageable);
    }

    public Usuario findById(Long id) {
        return findUsuarioById(id);
    }

    public Usuario save(Usuario usuario) {
        validateFields(usuario);

        if (Objects.isNull(usuario.getDataHora())) {
            usuario.setDataHora(LocalDateTime.now());
        }

        return usuarioRepository.save(usuario);
    }

    public Usuario update(Usuario usuario) {
        findUsuarioById(usuario.getId());
        validateFields(usuario);
        return usuarioRepository.save(usuario);
    }

    public void delete(Long id) {
        findUsuarioById(id);
        usuarioRepository.deleteById(id);
    }

    private Usuario findUsuarioById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado!"));
    }

    private void validateFields(Usuario usuario) {
        List<String> exceptions = new ArrayList<>();

        if (StringUtils.isBlank(usuario.getLogin())) {
            exceptions.add("O campo login deve ser preenchido");
        }

        if (StringUtils.isBlank(usuario.getSenha())) {
            exceptions.add("O campo senha deve ser preenchido");
        }

        if (StringUtils.isBlank(usuario.getNome())) {
            exceptions.add("O campo nome deve ser preenchido");
        }

        if (StringUtils.isBlank(usuario.getEmail())) {
            exceptions.add("O campo e-mail deve ser preenchido");
        }

        if (!exceptions.isEmpty()) {
            throw new MessageListException(exceptions);
        }
    }
}

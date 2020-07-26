package br.com.enfermagem.service;

import br.com.enfermagem.domain.PerfilEnum;
import br.com.enfermagem.exception.BusinessException;
import br.com.enfermagem.exception.NotFoundException;
import br.com.enfermagem.model.Usuario;
import br.com.enfermagem.repository.UsuarioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
        validatePerfil(dto);
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

    private void validatePerfil(Usuario dto) {
        if (dto.getPerfil() != PerfilEnum.A) {
            throw new BusinessException("O perfil selecionado é inválido!");
        }
    }
}

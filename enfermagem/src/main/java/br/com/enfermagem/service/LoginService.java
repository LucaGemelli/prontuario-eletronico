package br.com.enfermagem.service;

import br.com.enfermagem.dto.LoginDTO;
import br.com.enfermagem.exception.BusinessException;
import br.com.enfermagem.model.Usuario;
import br.com.enfermagem.repository.LoginRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LoginService {

    private final LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public boolean existsUsuario(LoginDTO dto) {
        Usuario usuario = loginRepository.findByEmailAndSenha(dto.getEmail(), dto.getSenha());

        if (Objects.isNull(usuario)) {
            throw new BusinessException("E-MAIL e/ou SENHA inválido(s)!");
        }

        return true;
    }
}

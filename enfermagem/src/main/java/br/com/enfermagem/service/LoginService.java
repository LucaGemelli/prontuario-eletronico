package br.com.enfermagem.service;

import br.com.enfermagem.dto.LoginDTO;
import br.com.enfermagem.exception.BusinessException;
import br.com.enfermagem.model.Usuario;
import br.com.enfermagem.repository.LoginRepository;
import br.com.enfermagem.util.EmailUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
public class LoginService {

    private final LoginRepository loginRepository;
    private final EmailUtil emailUtil;

    public LoginService(LoginRepository loginRepository, EmailUtil emailUtil) {
        this.loginRepository = loginRepository;
        this.emailUtil = emailUtil;
    }

    public boolean existsUsuario(LoginDTO dto) {
        Usuario usuario = loginRepository.findByEmailAndSenha(dto.getEmail(), dto.getSenha());

        if (Objects.isNull(usuario)) {
            throw new BusinessException("E-MAIL e/ou SENHA inválido(s)!");
        }

        return true;
    }

    public void sendEmail(LoginDTO dto) {
        Usuario usuario = loginRepository.findByEmail(dto.getEmail());

        if (Objects.isNull(usuario)) {
            throw new BusinessException("E-mail não encontrado!");
        }

        emailUtil.sendEmail(dto);
        usuario.setSenha(dto.getSenha());
        loginRepository.save(usuario);
        log.info("Senha alterada com sucesso!");
    }
}

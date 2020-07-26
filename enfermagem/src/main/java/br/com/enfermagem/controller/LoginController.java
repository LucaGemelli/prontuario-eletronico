package br.com.enfermagem.controller;

import br.com.enfermagem.dto.LoginDTO;
import br.com.enfermagem.service.LoginService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public boolean existsUsuario(@RequestBody @Valid LoginDTO dto) {
        return loginService.existsUsuario(dto);
    }
}

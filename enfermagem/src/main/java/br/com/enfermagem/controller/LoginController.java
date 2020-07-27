package br.com.enfermagem.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.enfermagem.dto.LoginDTO;
import br.com.enfermagem.service.LoginService;

@CrossOrigin
@RestController
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public ResponseEntity<Boolean> existsUsuario(@RequestBody @Valid LoginDTO dto) {
        return new ResponseEntity<>(loginService.existsUsuario(dto), HttpStatus.OK);
    }
}

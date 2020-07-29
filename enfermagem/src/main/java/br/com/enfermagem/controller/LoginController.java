package br.com.enfermagem.controller;

import br.com.enfermagem.dto.LoginDTO;
import br.com.enfermagem.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/sendEmail")
    public ResponseEntity<Void> sendEmail(@RequestBody LoginDTO dto) {
        loginService.sendEmail(dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

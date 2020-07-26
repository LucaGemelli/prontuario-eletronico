package br.com.enfermagem.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class LoginDTO {

    @NotBlank(message = "Preencher o Campo EMAIL")
    @Size(max = 40, message = "Máximo 40 Caracteres")
    private String email;

    @NotBlank(message = "Preencher o Campo SENHA")
    @Size(max = 40, message = "Máximo 40 Caracteres")
    private String senha;
}

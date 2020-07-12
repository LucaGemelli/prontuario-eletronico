package br.com.enfermagem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USUARIO")
public class Usuario extends DefaultModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Preencher o Campo NOME")
    @Size(max = 40, message = "Máximo 40 Caracteres")
    private String nome;

    @NotBlank(message = "Preencher o Campo EMAIL")
    @Size(max = 40, message = "Máximo 40 Caracteres")
    private String email;

    @NotBlank(message = "Preencher o Campo SENHA")
    @Size(max = 40, message = "Máximo 40 Caracteres")
    private String senha;

    @NotBlank(message = "Preencher o Campo PERFIL")
    private String perfil;

}

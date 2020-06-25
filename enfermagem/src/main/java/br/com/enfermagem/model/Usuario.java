package br.com.enfermagem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.enfermagem.domain.PerfilEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuarios")
public class Usuario extends DefaultModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message="Preencher o Campo NOME")
    @Size(max=40, message="Máximo 40 Caracteres")
    private String nome;

    @NotNull(message="Preencher o Campo EMAIL")
    @Size(max=40, message="Máximo 40 Caracteres")
    private String email;

    @NotNull(message="Preencher o Campo SENHA")
    @Size(max=40, message="Máximo 40 Caracteres")
    private String senha;

    @NotNull(message="Preencher o Campo PERFIL")
    private PerfilEnum perfil;

}

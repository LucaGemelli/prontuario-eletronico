package br.com.enfermagem.model;


import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.enfermagem.domain.EstadoCivilEnum;
import br.com.enfermagem.domain.SexoEnum;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "anamnese")
@EqualsAndHashCode(exclude = "anamnese")
@Table(name = "INTERNACOES")
public class Internacao extends DefaultModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Preencher Campo NOME")
    @Size(max = 40, message = "Máximo 40 Caracteres NOME")
    private String nome;

    @NotBlank(message = "Preencher Campo INFORMANTE")
    @Size(max = 40, message = "Máximo 40 Caracteres INFORMANTE")
    private String informante;

    @NotNull(message = "Preencher Campo SEXO")
    private SexoEnum sexo;

    @NotNull(message = "Preencher Campo DATA NASCIMENTO")
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @NotNull(message = "Preencher Campo QUANTIDADE FILHOS")
    @Column(name = "quantidade_filhos")
    private Long quantidadeFilhos;

    @NotNull(message = "Preencher Campo ESTADO CIVIL")
    @Column(name = "estado_civil")
    private EstadoCivilEnum estadoCivil;

    @NotBlank(message = "Preencher Campo PROFISSÃO")
    @Size(max = 20, message = "Máximo 20 Caracteres PROFISSÃO")
    private String profissao;

    @NotBlank(message = "Preencher Campo ENDEREÇO")
    @Size(max = 20, message = "Máximo 20 Caracteres ENDEREÇO")
    private String endereco;

    @NotBlank(message = "Preencher Campo NATURALIDADE")
    @Size(max = 20, message = "Máximo 20 Caracteres NATURALIDADE")
    private String naturalidade;

    @NotBlank(message = "Preencher Campo MOTIVO INTERNAÇÃO")
    @Size(max = 40, message = "Máximo 40 Caracteres MOTIVO INTERNAÇÃO")
    @Column(name = "motivo_internacao")
    private String motivoInternacao;

    @OneToOne(mappedBy = "internacao", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("internacao")
    private Anamnese anamnese;
}

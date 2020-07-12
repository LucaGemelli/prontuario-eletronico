package br.com.enfermagem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@EqualsAndHashCode(exclude = "anamnese")
@ToString(exclude = "anamnese")
@Table(name = "EVOLUCOES")
public class Evolucao extends DefaultModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Preencher Campo SUBJETIVO")
    @Size(max = 20, message = "Máximo 20 Caracteres SUBJETIVO")
    private String subjetivo;

    @NotBlank(message = "Preencher Campo OBJETIVO")
    @Size(max = 20, message = "Máximo 20 Caracteres OBJETIVO")
    private String objetivo;

    @NotBlank(message = "Preencher Campo IMPRESSÃO")
    @Size(max = 20, message = "Máximo 20 Caracteres IMPRESSÃO")
    private String impressao;

    @NotBlank(message = "Preencher Campo CONDUTA")
    @Size(max = 20, message = "Máximo 20 Caracteres  CONDUTA")
    private String conduta;

    @NotBlank(message = "Preencher Campo DIAGNÓSTICO")
    @Size(max = 20, message = "Máximo 20 Caracteres DIAGNÓSTICO")
    private String diagnostico;

    @ManyToOne
    @JoinColumn(name = "id_anamnese")
    @JsonIgnoreProperties({"sinaisVitais", "evolucoes"})
    private Anamnese anamnese;

}

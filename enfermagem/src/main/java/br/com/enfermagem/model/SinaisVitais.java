package br.com.enfermagem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
@ToString(exclude = "internacao")
@EqualsAndHashCode(exclude = "internacao")
@Table(name = "SINAIS_VITAIS")
public class SinaisVitais extends DefaultModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Preencher Campo COD")
    @Size(max = 10, message = "Máximo 10 Caracteres COD")
    private Long cod;

    @NotBlank(message = "Preencher Campo PA")
    @Size(max = 10, message = "Máximo 10 Caracteres PA")
    private String pa;

    @NotBlank(message = "Preencher Campo FC")
    @Size(max = 10, message = "Máximo 10 Caracteres FC")
    private String fc;

    @NotBlank(message = "Preencher Campo FR")
    @Size(max = 10, message = "Máximo 10 Caracteres FR")
    private String fr;

    @NotBlank(message = "Preencher Campo TAX")
    @Size(max = 10, message = "Máximo 10 Caracteres TAX")
    private String tax;

    @NotBlank(message = "Preencher Campo DOR")
    @Size(max = 10, message = "Máximo 10 Caracteres DOR")
    private String dor;

    @NotBlank(message = "Preencher Campo SAT")
    @Size(max = 10, message = "Máximo 10 Caracteres SAT")
    private String sat;

    @NotBlank(message = "Preencher Campo PVC")
    @Size(max = 10, message = "Máximo 10 Caracteres PVC")
    private String pvc;

    @NotBlank(message = "Preencher Campo HGT")
    @Size(max = 10, message = "Máximo 10 Caracteres HGT")
    private String hgt;

    @Size(max = 40, message = "Máximo 40 Caracteres ADMINISTRADOS")
    private String administrados;

    @Size(max = 40, message = "Máximo 40 Caracteres ELIMINADOS")
    private String eliminados;

    @Size(max = 40, message = "Máximo 40 Caracteres para o campo OBSERVAÇÕES")
    private String observacoes;

    @ManyToOne
    @JoinColumn(name = "id_internacao")
    @JsonIgnoreProperties({"sinaisVitais", "evolucoes"})
    private Internacao internacao;

}

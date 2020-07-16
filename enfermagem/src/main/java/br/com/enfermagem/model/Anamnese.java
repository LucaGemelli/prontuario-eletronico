package br.com.enfermagem.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
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
@ToString(exclude = {"sinaisVitais", "evolucoes", "internacao"})
@EqualsAndHashCode(exclude = {"sinaisVitais", "evolucoes", "internacao"})
@Table(name = "ANAMNESE")
public class Anamnese extends DefaultModel {

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

    @Size(max = 10, message = "Máximo 10 Caracteres DOENÇA GRAVE CRÔNICA")
    @Column(name = "doenca_grave_cronica")
    private String doencasGraveCronica;

    private Boolean doenca;

    @Size(max = 10, message = "Máximo 10 Caracteres DOENÇA INFÂNCIA")
    @Column(name = "doenca_infancia")
    private String doencaInfancia;

    @Size(max = 10, message = "Máximo 10 Caracteres MEDICAMENTO USO DOMICILIAR")
    @Column(name = "medicamento_uso_domiciliar")
    private String medicamentoUsoDomiciliar;

    @Size(max = 10, message = "Máximo 10 Caracteres ALERGIA A MEDICAMENTOS")
    @Column(name = "alergia_medicamentos")
    private String alergiaMedicamentos;

    @Size(max = 10, message = "Máximo 10 Caracteres ALERGIA ALIMENTAR ")
    @Column(name = "alergia_alimentares")
    private String alergiaAlimentares;

    @Size(max = 10, message = "Máximo 10 Caracteres ALERGIA OUTRAS")
    @Column(name = "alergia_outras")
    private String alergiaOutras;

    @Size(max = 10, message = "Máximo 10 Caracteres TRATAMENTOS ANTERIORES")
    @Column(name = "tratamentos_anteriores")
    private String tratamentosAnteriores;

    private Boolean cirurgias;

    @Size(max = 10, message = "Máximo 10 Caracteres HISTÓRICO OBSTETRICA")
    @Column(name = "historico_obstetrica")
    private String historicoObstetrica;

    @Size(max = 10, message = "Máximo 10 Caracteres HISTÓRICO FAMILIAR")
    @Column(name = "historico_familiar")
    private String historicoFamiliar;

    @Max(value = 10, message = "Máximo 10 Caracteres HISTÓRICO CANCER")
    @Column(name = "historico_cancer")
    private Long historicoCancer;

    private Boolean fumante;
    private Boolean alcool;
    private Boolean drogas;

    @Column(name = "condicao_moradia_saneamento_basico")
    private Boolean condicaoMoradiaSaneamentoBasico;

    @Column(name = "saneamento_basico")
    private Boolean saneamentoBasico;

    @Column(name = "atividade_fisica")
    private Boolean atividadeFisica;

    private Boolean repouso;

    @Size(max = 100, message = "Máximo 100 Caracteres HABITOS HIGIENE BANHO")
    @Column(name = "habitos_higiene_banho")
    private String habitosHigieneBanho;

    @Size(max = 100, message = "Máximo 100 Caracteres HABITOS HIGIENE BUCAL")
    @Column(name = "habitos_higiene_bucal")
    private String habitosHigieneBucal;

    @Size(max = 100, message = "Máximo 100 Caracteres HABITOS ALIMENTARES")
    @Column(name = "habitos_alimentares")
    private String habitoAlimentares;

    @Size(max = 10, message = "Máximo 10 Caracteres EQUILIBRIO EMOCIONAL")
    @Column(name = "equilibrio_emocional")
    private String equilibrioEmocional;

    @Size(max = 10, message = "Máximo 10 Caracteres ELIMINAÇÕES URINÁRIAS")
    @Column(name = "eliminacoes_urinarias")
    private String eliminacoesUrinarias;

    @Size(max = 10, message = "Máximo 10 Caracteres ELIMINAÇÕES INTESTINAIS")
    @Column(name = "eliminacoes_intestinais")
    private String eliminacoesIntestinais;

    @Size(max = 10, message = "Máximo 10 Caracteres ATIVIDADE SEXUAL")
    @Column(name = "atividade_sexual")
    private String atividadeSexual;

    @Size(max = 10, message = "Máximo 10 Caracteres PROBLEMA SAÚDE")
    @Column(name = "problema_saude")
    private String problemaSaude;

    private Float peso;

    private Float altura;

    @OneToMany(mappedBy = "internacao", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("internacao")
    private Internacao internacao;
}
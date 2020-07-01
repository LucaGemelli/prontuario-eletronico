package br.com.enfermagem.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
@ToString(exclude = {"sinaisVitais", "evolucoes"})
@EqualsAndHashCode(exclude = {"sinaisVitais", "evolucoes"})
@Table(name = "anamnese")
public class Anamnese extends DefaultModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message="Preencher Campo DOENÇA GRAVE CRÔNICA")
    @Size(max=10, message="Máximo 10 Caracteres DOENÇA GRAVE CRÔNICA")
    @Column(name = "doencas_grave_cronica")
    private String doencasGraveCronica;

    @NotNull(message="Preencher Campo DOENÇA")
    private Boolean doenca;

    @NotNull(message="Preencher Campo DOENÇA INFÂNCIA")
    @Size(max=10, message="Máximo 10 Caracteres DOENÇA INFÂNCIA")
    @Column(name = "doenca_infancia")
    private String doencaInfancia;

    @NotNull(message="Preencher Campo MEDICAMENTO USO DOMICILIAR")
    @Size(max=10, message="Máximo 10 Caracteres MEDICAMENTO USO DOMICILIAR")
    @Column(name = "medicamento_uso_domiciliar")
    private String medicamentoUsoDomiciliar;

    @NotNull(message="Preencher Campo ALERGIA A MEDICAMENTOS")
    @Size(max=10, message="Máximo 10 Caracteres ALERGIA A MEDICAMENTOS")
    @Column(name = "alergias_medicamentos")
    private String alergiasMedicamentos;

    @NotNull(message="Preencher Campo ALERGIA ALIMENTAR")
    @Size(max=10, message="Máximo 10 Caracteres ALERGIA ALIMENTAR ")
    @Column(name = "alergias_alimentar")
    private String alergiasAlimentar;

    @NotNull(message="Preencher Campo ALERGIA OUTRAS")
    @Size(max=10, message="Máximo 10 Caracteres ALERGIA OUTRAS")
    @Column(name = "alergias_outras")
    private String alergiasOutras;

    @NotNull(message="Preencher Campo TRATAMENTOS ANTERIORES")
    @Size(max=10, message="Máximo 10 Caracteres TRATAMENTOS ANTERIORES")
    @Column(name = "tratamentos_anteriores")
    private String tratamentosAnteriores;

    @NotNull(message="Preencher Campo CIRURGIAS")
    private Boolean cirurgias;

    @NotNull(message="Preencher Campo HISTÓRICO OBSTETRICA")
    @Size(max=10, message="Máximo 10 Caracteres HISTÓRICO OBSTETRICA")
    @Column(name = "historico_obstetrica")
    private String historicoObstetrica;

    @NotNull(message="Preencher Campo HISTÓRICO FAMILIAR")
    @Size(max=10, message="Máximo 10 Caracteres HISTÓRICO FAMILIAR")
    @Column(name = "historico_familiar")
    private String historicoFamiliar;

    @NotNull(message="Preencher Campo HISTÓRICO CANCER")
    @Size(max=10, message="Máximo 10 Caracteres HISTÓRICO CANCER")
    @Column(name = "historico_cancer")
    private Long historicoCancer;

    @NotNull(message="Preencher Campo FUMANTE")
    private Boolean fumante;

    @NotNull(message="Preencher Campo ALCOOL")
    private Boolean alcool;

    @NotNull(message="Preencher Campo DROGAS")
    private Boolean drogas;

    @NotNull(message="Preencher Campo CONDIÇÃO MORADIA SANEAMENTO BÁSICO")
    @Column(name = "condicao_moradia_saneamento_basico")
    private Boolean condicaoMoradiaSaneamentoBasico;

    @NotNull(message="Preencher Campo SANEAMENTO BÁSICO")
    @Column(name = "saneamento_basico")
    private Boolean saneamentoBasico;

    @NotNull(message="Preencher Campo ATIVIDADE FISÍCA")
    @Column(name = "atividade_fisica")
    private Boolean atividadeFisica;

    @NotNull(message="Preencher Campo REPOUSO")
    private Boolean repouso;

    @NotNull(message="Preencher Campo HABITOS HIGIENE BANHO")
    @Size(max=100, message="Máximo 100 Caracteres HABITOS HIGIENE BANHO")
    @Column(name = "habitos_higiene_banho")
    private String habitosHigieneBanho;

    @NotNull(message="Preencher Campo HABITOS HIGIENE BUCAL")
    @Size(max=100, message="Máximo 100 Caracteres HABITOS HIGIENE BUCAL")
    @Column(name = "habitos_higiene_bucal")
    private String habitosHigieneBucal;

    @NotNull(message="Preencher Campo HABITOS ALIMENTARES")
    @Size(max=100, message="Máximo 100 Caracteres HABITOS ALIMENTARES")
    @Column(name = "habitos_alimentares")
    private String habitoAlimentares;

    @NotNull(message="Preencher Campo EQUILIBRIO EMOCIONAL")
    @Size(max=10, message="Máximo 10 Caracteres EQUILIBRIO EMOCIONAL")
    @Column(name = "equilibrio_emocional")
    private String equilibrioEmocional;

    @NotNull(message="Preencher Campo ELIMINAÇÕES URINÁRIAS")
    @Size(max=10, message="Máximo 10 Caracteres ELIMINAÇÕES URINÁRIAS")
    @Column(name = "eliminacoes_urinarias")
    private String eliminacoesUrinarias;

    @NotNull(message="Preencher Campo ELIMINAÇÕES INTESTINAIS")
    @Size(max=10, message="Máximo 10 Caracteres ELIMINAÇÕES INTESTINAIS")
    @Column(name = "eliminacoes_intestinais")
    private String eliminacoesIntestinais;

    @NotNull(message="Preencher Campo ATIVIDADE SEXUAL")
    @Size(max=10, message="Máximo 10 Caracteres ATIVIDADE SEXUAL")
    @Column(name = "atividade_sexual")
    private String atividadeSexual;

    @NotNull(message="Preencher Campo PROBLEMA SAÚDE")
    @Size(max=10, message="Máximo 10 Caracteres PROBLEMA SAÚDE")
    @Column(name = "problema_saude")
    private String problemaSaude;

    @NotNull(message="Preencher Campo PESO")
    private Float peso;

    @NotNull(message="Preencher Campo ALTURA")
    private Float altura;

    @ManyToOne
    @JoinColumn(name = "idInternacao")
    private Internacao internacao;

    @OneToMany(mappedBy = "anamnese", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("anamnese")
    private List<SinaisVitais> sinaisVitais;

    @OneToMany(mappedBy = "anamnese", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("anamnese")
    private List<Evolucao> evolucoes;
}
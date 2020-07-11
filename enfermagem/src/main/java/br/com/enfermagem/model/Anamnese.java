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

    @Size(max=10, message="Máximo 10 Caracteres DOENÇA GRAVE CRÔNICA")
    @Column(name = "doencas_grave_cronica")
    private String doencasGraveCronica;

    private Boolean doenca;

    @Size(max=10, message="Máximo 10 Caracteres DOENÇA INFÂNCIA")
    @Column(name = "doenca_infancia")
    private String doencaInfancia;

    @Size(max=10, message="Máximo 10 Caracteres MEDICAMENTO USO DOMICILIAR")
    @Column(name = "medicamento_uso_domiciliar")
    private String medicamentoUsoDomiciliar;

    @Size(max=10, message="Máximo 10 Caracteres ALERGIA A MEDICAMENTOS")
    @Column(name = "alergias_medicamentos")
    private String alergiasMedicamentos;

    @Size(max=10, message="Máximo 10 Caracteres ALERGIA ALIMENTAR ")
    @Column(name = "alergias_alimentar")
    private String alergiasAlimentar;

    @Size(max=10, message="Máximo 10 Caracteres ALERGIA OUTRAS")
    @Column(name = "alergias_outras")
    private String alergiasOutras;

    @Size(max=10, message="Máximo 10 Caracteres TRATAMENTOS ANTERIORES")
    @Column(name = "tratamentos_anteriores")
    private String tratamentosAnteriores;

    private Boolean cirurgias;

    @Size(max=10, message="Máximo 10 Caracteres HISTÓRICO OBSTETRICA")
    @Column(name = "historico_obstetrica")
    private String historicoObstetrica;

    @Size(max=10, message="Máximo 10 Caracteres HISTÓRICO FAMILIAR")
    @Column(name = "historico_familiar")
    private String historicoFamiliar;

    @Size(max=10, message="Máximo 10 Caracteres HISTÓRICO CANCER")
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

    @Size(max=100, message="Máximo 100 Caracteres HABITOS HIGIENE BANHO")
    @Column(name = "habitos_higiene_banho")
    private String habitosHigieneBanho;

    @Size(max=100, message="Máximo 100 Caracteres HABITOS HIGIENE BUCAL")
    @Column(name = "habitos_higiene_bucal")
    private String habitosHigieneBucal;

    @Size(max=100, message="Máximo 100 Caracteres HABITOS ALIMENTARES")
    @Column(name = "habitos_alimentares")
    private String habitoAlimentares;

    @Size(max=10, message="Máximo 10 Caracteres EQUILIBRIO EMOCIONAL")
    @Column(name = "equilibrio_emocional")
    private String equilibrioEmocional;

    @Size(max=10, message="Máximo 10 Caracteres ELIMINAÇÕES URINÁRIAS")
    @Column(name = "eliminacoes_urinarias")
    private String eliminacoesUrinarias;

    @Size(max=10, message="Máximo 10 Caracteres ELIMINAÇÕES INTESTINAIS")
    @Column(name = "eliminacoes_intestinais")
    private String eliminacoesIntestinais;

    @Size(max=10, message="Máximo 10 Caracteres ATIVIDADE SEXUAL")
    @Column(name = "atividade_sexual")
    private String atividadeSexual;

    @Size(max=10, message="Máximo 10 Caracteres PROBLEMA SAÚDE")
    @Column(name = "problema_saude")
    private String problemaSaude;

    private Float peso;

    private Float altura;

    @ManyToOne
    @JoinColumn(name = "id_internacao")
    private Internacao internacao;

    @OneToMany(mappedBy = "anamnese", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("anamnese")
    private List<SinaisVitais> sinaisVitais;

    @OneToMany(mappedBy = "anamnese", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("anamnese")
    private List<Evolucao> evolucoes;
}
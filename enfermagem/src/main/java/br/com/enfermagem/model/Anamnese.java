package br.com.enfermagem.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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

    @Column(name = "diagnostico_medico")
    private String diagnosticoMedico;

    @Column(name = "historico_doenca_atual")
    private String historicoDoencaAtual;

    @Column(name = "doencas_grave_cronica")
    private String doencasGraveCronica;

    private String doenca;

    @Column(name = "doenca_obs")
    private String doencaObs;

    @Column(name = "doenca_infancia")
    private String doencaInfancia;
    
    @Column(name = "medicamento_uso_domiciliar")
    private String medicamentoUsoDomiciliar;

    @Column(name = "alergias_medicamentos")
    private String alergiasMedicamentos;

    @Column(name = "alergias_alimentar")
    private String alergiasAlimentar;

    @Column(name = "alergias_outras")
    private String alergiasOutras;

    @Column(name = "tratamentos_anteriores")
    private String tratamentosAnteriores;

    @Column(name = "internacoes_anteriores")
    private String internacoesAnteriores;

    private String cirurgias;

    @Column(name = "historico_obstetrica_gesta")
    private String historicoObstetricaGesta;

    @Column(name = "historico_obstetrica_para")
    private String historicoObstetricaPara;

    @Column(name = "historico_obstetrica_aborto")
    private String historicoObstetricaAborto;

    @Column(name = "historico_familiar")
    private String historicoFamiliar;

    @Column(name = "historico_cancer")
    private Long historicoCancer;

    @Column(name = "historico_cancer_obs")
    private String historicoCancerObs;

    private Long fumante;

    @Column(name = "fumante_obs")
    private String fumanteObs;

    private Long alcool;

    @Column(name = "alcool_obs")
    private String alcoolObs;

    private Long drogas;

    @Column(name = "drogas_obs")
    private String drogasObs;

    @Column(name = "condicao_moradia")
    private Long condicaoMoradia;

    @Column(name = "condicao_moradia_saneamento_basico")
    private Long condicaoMoradiaSaneamentoBasico;

    @Column(name = "condicao_moradia_obs")
    private String condicaoMoradiaObs;

    @Column(name = "saneamento_basico")
    private Long saneamentoBasico;

    @Column(name = "saneamento_basico_obs")
    private String saneamentoBasicoObs;

    @Column(name = "atividade_fisica")
    private Long atividadeFisica;

    @Column(name = "atividade_fisica_qtde")
    private Long atividadeFisicaQtde;

    @Column(name = "atividade_fisica_obs")
    private String atividadeFisicaObs;

    @Column(name = "atividade_fisica_vezes_tipo")
    private String atividadeFisicaVezesTipo;

    private Long repouso;

    @Column(name = "repouso_hrs")
    private Long repousoHrs;

    @Column(name = "repouso_hrs_obs")
    private String repouso_Hrs_Obs;

    @Column(name = "habitos_higiene_banho")
    private String habitosHigieneBanho;

    @Column(name = "habitos_higiene_bucal")
    private String habitosHigieneBucal;

    @Column(name = "frutas_verduras")
    private Long frutasVerduras;

    @Column(name = "carne_vermelha")
    private Long carneVermelha;

    private Long peixe;

    @Column(name = "frango_suco")
    private Long frangoSuco;

    private Long agua;

    private Long cafe;

    private Long leite;

    private Long fritura;

    @Column(name = "come_quantas_vezes_dia")
    private Long comeQuantasVezesDia;

    @Column(name = "come_quantas_vezes_dia_obs")
    private String comeQuantasVezesDiaObs;

    @Column(name = "habitos_alimentares")
    private Long habitosAlimentares;

    @Column(name = "habitos_alimentares_vezes_dia_obs")
    private String habitosAlimentaresVezesDiaObs;

    @Column(name = "equilibrio_emocional")
    private String equilibrioEmocional;

    @Column(name = "eliminacoes_urinarias")
    private Long eliminacoesUrinarias;

    @Column(name = "eliminacoes_urinarias_obs")
    private String eliminacoesUrinariasObs;

    @Column(name = "eliminacoes_urinarias_normais")
    private Long eliminacoesUrinariasNormais;

    @Column(name = "eliminacoes_urinarias_alteracoes")
    private String eliminacoesUrinariasAlteracoes;

    @Column(name = "eliminacoes_intestinais")
    private Long eliminacoesIntestinais;

    @Column(name = "eliminacoes_intestinais_obs")
    private String eliminacoesIntestinaisObs;

    @Column(name = "atividade_sexual")
    private Long atividadeSexual;

    @Column(name = "problema_saude")
    private Long problemaSaude;

    @Column(name = "problema_saude_obs")
    private String problemaSaudeObs;

    @Column(name = "conhecimento_problema_saude")
    private Long conhecimentoProblemaSaude;

    @Column(name = "conhecimento_problema_saude_obs")
    private String conhecimentoProblemaSaudeObs;

    @Column(name = "estado_nutricional")
    private Long estadoNutricional;

    private Float peso;

    private Float altura;

    @OneToMany(mappedBy = "anamnese", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("anamnese")
    private List<SinaisVitais> sinaisVitais;

    @OneToMany(mappedBy = "anamnese", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("anamnese")
    private List<Evolucao> evolucoes;
}
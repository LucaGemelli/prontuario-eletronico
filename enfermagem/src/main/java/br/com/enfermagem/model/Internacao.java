package br.com.enfermagem.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@ToString(exclude = "anamnese")
@EqualsAndHashCode(exclude = "anamnese")
@Table(name = "INTERNACOES")
public class Internacao extends DefaultModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    @ManyToOne
    @JoinColumn(name = "id_anamnese")
    @JsonIgnoreProperties("anamnese")
    private Anamnese anamnese;

    @OneToMany(mappedBy = "internacao", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("internacao")
    private List<SinaisVitais> sinaisVitais;

    @OneToMany(mappedBy = "internacao", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("internacao")
    private List<Evolucao> evolucoes;


}

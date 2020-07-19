package br.com.enfermagem.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"anamnese", "sinaisVitais", "evolucoes"})
@EqualsAndHashCode(exclude = {"anamnese", "sinaisVitais", "evolucoes"})
@Table(name = "INTERNACOES")
public class Internacao extends DefaultModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Preencher Campo STATUS")
    @Size(max = 10, message = "Máximo 10 Caracteres STATUS")
    private String status;

    @ManyToOne
    @JoinColumn(name = "id_anamnese")
    @JsonIgnoreProperties("internacao")
    private Anamnese anamnese;

    @OneToMany(mappedBy = "internacao", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("internacao")
    private List<SinaisVitais> sinaisVitais;

    @OneToMany(mappedBy = "internacao", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("internacao")
    private List<Evolucao> evolucoes;

}

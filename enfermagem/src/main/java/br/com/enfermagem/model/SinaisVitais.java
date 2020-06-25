package br.com.enfermagem.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "paciente")
@EqualsAndHashCode(exclude = "paciente")
@Builder
@Entity
@Table(name = "sinaisvitais")
public class SinaisVitais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message="Preencher Campo" + "cod")
    private Long cod;
    @Size(max=10, message="Máximo 10 Caracteres")
    private String pa;
    @Size(max=10, message="Máximo 10 Caracteres")
    private String fc;
    @Size(max=10, message="Máximo 10 Caracteres")
    private String fr;
    @Size(max=10, message="Máximo 10 Caracteres")
    private String tax;
    @Size(max=10, message="Máximo 10 Caracteres")
    private String dor;
    @Size(max=10, message="Máximo 10 Caracteres")
    private String sat;
    @Size(max=10, message="Máximo 10 Caracteres")
    private String pvc;
    @Size(max=10, message="Máximo 10 Caracteres")
    private String hgt;
    private String administrados;
    private String eliminados;
    private String observacoes;

    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "idFluxo24hPaciente")
    @JsonIgnoreProperties({"usuario", "caso", "comentarios", "sinaisVitais", "evolucoes"})
    private Paciente paciente;

}

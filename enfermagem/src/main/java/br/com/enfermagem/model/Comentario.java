package br.com.enfermagem.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(exclude = "paciente")
@ToString(exclude = "paciente")
@Table(name = "comentarios")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "datahora")
    private LocalDateTime dataHora;

    @Column(name = "descricaocomentario")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "idcomentariopaciente")
    @JsonIgnoreProperties({"usuario", "caso", "comentarios"})
    private Paciente paciente;
}

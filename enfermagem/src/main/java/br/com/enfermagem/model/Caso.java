package br.com.enfermagem.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"usuario", "pacientes"})
@ToString(exclude = {"usuario", "pacientes"})
@Table(name = "casos")
public class Caso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "identificacao")
    @Size(min = 1, message = "Preencher Campo")
    private String identificacao;

    @Column(name = "code")
    @Size(min = 5, max = 5, message = "Campo deve ter 5 digitos")
    private String code;

    @Column(name = "datahora")
    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "idcasousuario")
    @JsonIgnoreProperties("casos")
    private Usuario usuario;

    @OneToMany(mappedBy = "caso", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("idPacienteCaso")
    private List<Paciente> pacientes;
}

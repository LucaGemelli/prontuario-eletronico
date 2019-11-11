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
@EqualsAndHashCode(exclude = {"pacientes", "casos"})
@ToString(exclude = {"pacientes", "casos"})
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 1, message = "Preencher Campo")
    @Column(name = "login")
    private String login;

    @Size(min = 1, message = "Preencher Campo")
    @Column(name = "senha")
    private String senha;

    @Size(min = 1, message = "Preencher Campo")
    @Column(name = "nome")
    private String nome;

    @Column(name = "datahora")
    private LocalDateTime dataHora;

    @Size(min = 1, message = "Preencher Campo")
    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("idPacienteUsuario")
    private List<Paciente> pacientes;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("idCasoUsuario")
    private List<Caso> casos;
}

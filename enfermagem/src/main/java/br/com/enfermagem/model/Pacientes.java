package br.com.enfermagem.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Pacientes {

    //TODO Realizar o mapeamento das entidades
    @Id
    private Long id;
    private String informante;
}


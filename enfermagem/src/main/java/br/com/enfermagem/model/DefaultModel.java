package br.com.enfermagem.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class DefaultModel {

    @Column(name = "data_hora_criacao")
    private LocalDateTime dataHoraCriacao;
}

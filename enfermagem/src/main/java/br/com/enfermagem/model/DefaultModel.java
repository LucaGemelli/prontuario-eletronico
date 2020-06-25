package br.com.enfermagem.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class DefaultModel {

    @NotNull(message="Preencher o Campo DATA HORA CRIAÇÃO")
    @Column(name = "data_Hora_Criacao")
    private LocalDateTime dataHoraCriacao;
}

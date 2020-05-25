package br.com.enfermagem.dto;

import br.com.enfermagem.model.Paciente;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ComentarioDTO {

    private Long id;
    private LocalDateTime dataHora;
    private String descricao;
    private Paciente paciente;
}

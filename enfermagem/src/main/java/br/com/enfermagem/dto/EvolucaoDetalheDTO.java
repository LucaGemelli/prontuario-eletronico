package br.com.enfermagem.dto;

import br.com.enfermagem.model.Paciente;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EvolucaoDetalheDTO extends EvolucaoEditarDTO {

    private Paciente paciente;
}

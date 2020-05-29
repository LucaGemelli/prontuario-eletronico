package br.com.enfermagem.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import br.com.enfermagem.model.Caso;
import br.com.enfermagem.model.Paciente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioDetalheDTO extends UsuarioEditarDTO {

	private List<Paciente> pacientes;

    private List<Caso> casos;
}

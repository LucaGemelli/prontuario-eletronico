package br.com.enfermagem.converter;

import br.com.enfermagem.dto.ComentarioDTO;
import br.com.enfermagem.model.Comentario;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

@Component
public class ComentarioConverter {

    public Comentario convertToEntity(ComentarioDTO dto) {
        LocalDateTime dataHora = dto.getDataHora();

        return Comentario.builder()
                .id(dto.getId())
                .descricao(dto.getDescricao())
                .dataHora(Objects.nonNull(dataHora) ? dataHora : LocalDateTime.now())
                .paciente(dto.getPaciente())
                .build();
    }

    public ComentarioDTO convertToDTO(Comentario comentario) {
        return ComentarioDTO.builder()
                .id(comentario.getId())
                .descricao(comentario.getDescricao())
                .dataHora(comentario.getDataHora())
                .paciente(comentario.getPaciente())
                .build();
    }
}

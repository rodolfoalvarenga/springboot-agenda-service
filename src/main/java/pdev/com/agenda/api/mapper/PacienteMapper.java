package pdev.com.agenda.api.mapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pdev.com.agenda.api.request.PacienteRequest;
import pdev.com.agenda.api.response.PacienteCompletoResponse;
import pdev.com.agenda.api.response.PacienteResponse;
import pdev.com.agenda.domain.entity.Paciente;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PacienteMapper {

    private final ModelMapper mapper;

    public Paciente toPaciente(PacienteRequest pacienteRequest) {
        return mapper.map(pacienteRequest, Paciente.class);
    }

    public PacienteResponse toPacienteResponse(Paciente paciente) {
        return mapper.map(paciente, PacienteResponse.class);
    }

    public PacienteCompletoResponse toPacienteCompletoResponse(Paciente paciente) {
        return mapper.map(paciente, PacienteCompletoResponse.class);
    }

    public List<PacienteResponse> toPacienteResponseList(List<Paciente> pacientes) {
        return pacientes.stream()
                .map(this::toPacienteResponse)
                .collect(Collectors.toList());
    }

//    public static Paciente toPaciente(PacienteRequest pacienteRequest) {
//        Paciente paciente = new Paciente();
//        paciente.setNome(pacienteRequest.getNome());
//        paciente.setSobrenome(pacienteRequest.getSobrenome());
//        paciente.setEmail(pacienteRequest.getEmail());
//        paciente.setCpf(pacienteRequest.getCpf());
//        return paciente;
//    }

//    public static PacienteResponse toPacienteResponse(Paciente paciente) {
//        PacienteResponse pacienteResponse = new PacienteResponse();
//        pacienteResponse.setId(paciente.getId());
//        pacienteResponse.setNome(paciente.getNome());
//        pacienteResponse.setSobrenome(paciente.getSobrenome());
//        pacienteResponse.setEmail(paciente.getEmail());
//        pacienteResponse.setCpf(paciente.getCpf());
//        return pacienteResponse;
//    }

//    public static List<PacienteResponse> toPacienteResponseList(List<Paciente> pacientes) {
//        List<PacienteResponse> pacienteResponses = new ArrayList<>();
//        for (Paciente paciente : pacientes) {
//            pacienteResponses.add(toPacienteResponse(paciente));
//        }
//        return pacienteResponses;
//    }

}

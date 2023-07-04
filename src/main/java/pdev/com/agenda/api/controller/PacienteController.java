package pdev.com.agenda.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pdev.com.agenda.domain.entity.Paciente;
import pdev.com.agenda.domain.service.PacienteService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<Paciente> salvar(@RequestBody Paciente paciente) {
        Paciente pacienteSalvo = pacienteService.salvar(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteSalvo);
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> listarTodos() {
//        return ResponseEntity.status(HttpStatus.OK).body(pacienteService.listarTodos());
        List<Paciente> pacientes = pacienteService.listarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(pacientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPorId(@PathVariable Long id) {
        Optional<Paciente> optPaciente = pacienteService.buscarPorId(id);

        if (optPaciente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

//        Paciente paciente = optPaciente.get();
//        return ResponseEntity.status(HttpStatus.OK).body(paciente);

        return ResponseEntity.status(HttpStatus.OK).body(optPaciente.get());
    }

    @PutMapping()
    public ResponseEntity<Paciente> alterar(@RequestBody Paciente paciente) {
        Paciente pacienteSalvo = pacienteService.salvar(paciente);
        return ResponseEntity.status(HttpStatus.OK).body(pacienteSalvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        pacienteService.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}

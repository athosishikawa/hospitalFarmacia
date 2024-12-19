package edu.ifpr.projeto.hospitalfarmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.ifpr.projeto.hospitalfarmacia.model.Paciente;
import edu.ifpr.projeto.hospitalfarmacia.services.PacienteService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
           
    @Autowired
    private PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService){
        super();
        this.pacienteService = pacienteService;
    }

    @GetMapping("/listarPacientes")
    public List<Paciente> listarPacientes(){
        return pacienteService.findAllPacientes();
    }

    @PostMapping("/cadastrarPacientes")
    public boolean cadastrarPessoa(@RequestBody Paciente paciente){
        try {
            pacienteService.cadastrarPaciente(paciente);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @GetMapping("/findPaciente")
    public ResponseEntity<Paciente> buscarPaciente(@RequestParam("id") int id ){
        return new ResponseEntity<Paciente>(pacienteService.findById(id), HttpStatus.OK);
    }

}
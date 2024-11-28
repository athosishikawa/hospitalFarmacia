package edu.ifpr.projeto.hospitalfarmacia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ifpr.projeto.hospitalfarmacia.model.Paciente;
import edu.ifpr.projeto.hospitalfarmacia.repository.PacienteRepository;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public void cadatrarPaciente(Paciente paciente){
        if(paciente.getId() == null){
            return;
        }
        pacienteRepository.save(paciente);
    }

    public void alterarPaciente(Paciente paciente){
        if(paciente.getId() == null || paciente.getId().equals(0)){
            cadatrarPaciente(paciente);
        }
        pacienteRepository.save(paciente);
    }

    public void excluirPaciente(int idPaciente){
        Paciente p = pacienteRepository.findById(idPaciente);
        pacienteRepository.delete(p);
    }

    public Paciente findById(int idPaciente){
        return pacienteRepository.findById(idPaciente);
    }

    public List<Paciente> findAllReceita(){
        return pacienteRepository.findAll();
    }


}

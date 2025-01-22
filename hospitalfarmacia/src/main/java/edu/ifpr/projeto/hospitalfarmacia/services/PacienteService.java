package edu.ifpr.projeto.hospitalfarmacia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ifpr.projeto.hospitalfarmacia.model.Paciente;
import edu.ifpr.projeto.hospitalfarmacia.model.Pessoa;
import edu.ifpr.projeto.hospitalfarmacia.model.Plano;
import edu.ifpr.projeto.hospitalfarmacia.repository.PacienteRepository;
import edu.ifpr.projeto.hospitalfarmacia.repository.PessoaRepository;
import edu.ifpr.projeto.hospitalfarmacia.repository.PlanoRepository;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private PlanoService planoService;

    @Autowired
    private PessoaService pessoaService;

    public Paciente cadastrarPaciente(Paciente paciente){
            System.out.println("Received paciente: " + paciente);

            Plano plano = planoService.findById(paciente.getPlano().getId());
            paciente.setPlano(plano);
        
            Pessoa pessoa = pessoaService.findById(paciente.getPessoa().getId());
            paciente.setPessoa(pessoa);

            return pacienteRepository.save(paciente);
    }

    public void alterarPaciente(Paciente paciente){
        if(paciente.getId() == null || paciente.getId().equals(0)){
            cadastrarPaciente(paciente);
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

    public List<Paciente> findAllPacientes(){
        return pacienteRepository.findAll();
    }


}

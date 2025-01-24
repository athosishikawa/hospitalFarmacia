package edu.ifpr.projeto.hospitalfarmacia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ifpr.projeto.hospitalfarmacia.model.ItemReceita;
import edu.ifpr.projeto.hospitalfarmacia.model.Medicamento;
import edu.ifpr.projeto.hospitalfarmacia.model.Medico;
import edu.ifpr.projeto.hospitalfarmacia.model.Paciente;
import edu.ifpr.projeto.hospitalfarmacia.model.Pessoa;
import edu.ifpr.projeto.hospitalfarmacia.model.Plano;
import edu.ifpr.projeto.hospitalfarmacia.model.Receita;
import edu.ifpr.projeto.hospitalfarmacia.repository.ReceitaRepository;

@Service
public class ReceitaService {

    @Autowired
    private ReceitaRepository receitaRepository;


    @Autowired
    private MedicamentoService medicamentoService;

    @Autowired
    private MedicoService medicoService;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private ItemReceitaService itemReceitaService;

    public Receita cadastrarReceita(Receita receita) {
        System.out.println("Recebendo Receita: " + receita);
    
        // Validação de Medicamento
        if (receita.getMedicamento() != null && receita.getMedicamento().getId() != null) {
            Medicamento medicamento = medicamentoService.findById(receita.getMedicamento().getId());
            receita.setMedicamento(medicamento);
        }
    
        // Validação de Médico
        if (receita.getMedico() != null && receita.getMedico().getId() != null) {
            Medico medico = medicoService.findById(receita.getMedico().getId());
            receita.setMedico(medico);
        }
    
        // Validação de Paciente
        if (receita.getPaciente() != null && receita.getPaciente().getId() != null) {
            Paciente paciente = pacienteService.findById(receita.getPaciente().getId());
            receita.setPaciente(paciente);
        }
    
        // Validação de ItemReceita
        if (receita.getItemReceita() != null && receita.getItemReceita().getId() != null) {
            ItemReceita itemReceita = itemReceitaService.findById(receita.getItemReceita().getId());
            receita.setItemReceita(itemReceita);
        }
    
        Receita receitaSalva = receitaRepository.save(receita);
        System.out.println("Receita salva: " + receitaSalva);
        return receitaSalva;
    }
    


    public void alterarReceita(Receita receita){
        if(receita.getId() == null || receita.getId().equals(0)){
            cadastrarReceita(receita);
        }
        receitaRepository.save(receita);
    }

    public void excluirReceita(int idReceita){
        Receita p = receitaRepository.findById(idReceita);
        receitaRepository.delete(p);
    }

    public Receita findById(int idReceita){
        return receitaRepository.findById(idReceita);
    }

    public List<Receita> findAllReceita(){
        return receitaRepository.findAll();
    }


}

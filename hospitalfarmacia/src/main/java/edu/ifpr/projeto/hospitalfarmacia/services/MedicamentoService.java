package edu.ifpr.projeto.hospitalfarmacia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ifpr.projeto.hospitalfarmacia.model.Medicamento;
import edu.ifpr.projeto.hospitalfarmacia.repository.MedicamentoRepository;

@Service
public class MedicamentoService {
     
    @Autowired
    private MedicamentoRepository medicamentoRepository;

    public void cadastrarItemReceita(Medicamento itemReceita){
        if(itemReceita.getId() == null){
            return;
        }
        medicamentoRepository.save(itemReceita);
    }

    public void alterarItemReceita(Medicamento itemReceita){
        if(itemReceita.getId() == null || itemReceita.getId().equals(0)){
            cadastrarItemReceita(itemReceita);
        }
        medicamentoRepository.save(itemReceita);
    }

    public void excluirItemReceita(int idItemReceita){
        Medicamento p = medicamentoRepository.findById(idItemReceita);
        medicamentoRepository.delete(p);
    }

    public Medicamento findById(int idItemReceita){
        return medicamentoRepository.findById(idItemReceita);
    }

    public List<Medicamento> findAllDependente(){
        return medicamentoRepository.findAll();
    }


   
}
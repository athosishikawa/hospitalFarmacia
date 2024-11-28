package edu.ifpr.projeto.hospitalfarmacia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ifpr.projeto.hospitalfarmacia.model.Receita;
import edu.ifpr.projeto.hospitalfarmacia.repository.ReceitaRepository;

@Service
public class ReceitaService {

    @Autowired
    private ReceitaRepository receitaRepository;

    public void cadatrarReceita(Receita receita){
        if(receita.getId() == null){
            return;
        }
        receitaRepository.save(receita);
    }

    public void alterarReceita(Receita receita){
        if(receita.getId() == null || receita.getId().equals(0)){
            cadatrarReceita(receita);
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

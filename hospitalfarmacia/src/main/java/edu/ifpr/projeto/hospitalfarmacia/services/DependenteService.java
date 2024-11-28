package edu.ifpr.projeto.hospitalfarmacia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ifpr.projeto.hospitalfarmacia.model.Dependente;
import edu.ifpr.projeto.hospitalfarmacia.repository.DependenteRepository;

@Service
public class DependenteService {
     
    @Autowired
    private DependenteRepository dependenteRepository;

    public void cadastrarDependente(Dependente dependente){
        if(dependente.getNome() == null || dependente.getNome().isEmpty()){
            return;
        }
        dependenteRepository.save(dependente);
    }

    public void alterarDependente(Dependente dependente){
        if(dependente.getId() == null || dependente.getId().equals(0)){
            cadastrarDependente(dependente);
        }
        dependenteRepository.save(dependente);
    }

    public void excluirDependente(int idDependente){
        Dependente p = dependenteRepository.findById(idDependente);
        dependenteRepository.delete(p);
    }

    public Dependente findById(int idDependente){
        return dependenteRepository.findById(idDependente);
    }

    public List<Dependente> findAllDependente(){
        return dependenteRepository.findAll();
    }


   
}

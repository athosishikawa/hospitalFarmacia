package edu.ifpr.projeto.hospitalfarmacia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ifpr.projeto.hospitalfarmacia.model.Plano;
import edu.ifpr.projeto.hospitalfarmacia.repository.PlanoRepository;

@Service
public class PlanoService {
     
    @Autowired
    private PlanoRepository planoRepository;

    public void cadastrarPlano(Plano plano){
        if(plano.getId() == null){
            return;
        }
        planoRepository.save(plano);
    }

    public void alterarPlano(Plano plano){
        if(plano.getId() == null || plano.getId().equals(0)){
            cadastrarPlano(plano);
        }
        planoRepository.save(plano);
    }

    public void excluirPlano(int idPlano){
        Plano p = planoRepository.findById(idPlano);
        planoRepository.delete(p);
    }

    public Plano findById(int idPlano){
        return planoRepository.findById(idPlano);
    }

    public List<Plano> findAllPlanos(){
        return planoRepository.findAll();
    }


   
}
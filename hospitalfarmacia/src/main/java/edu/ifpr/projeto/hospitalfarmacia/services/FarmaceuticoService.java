package edu.ifpr.projeto.hospitalfarmacia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ifpr.projeto.hospitalfarmacia.model.Farmaceutico;
import edu.ifpr.projeto.hospitalfarmacia.repository.FarmaceuticoRepository;

@Service
public class FarmaceuticoService {
     
    @Autowired
    private FarmaceuticoRepository farmaceuticoRepository;

    public void cadastrarFarmaceutico(Farmaceutico farmaceutico){
        if(farmaceutico.getCrf() == null || farmaceutico.getCrf().isEmpty()){
            return;
        }
        farmaceuticoRepository.save(farmaceutico);
    }

    public void alterarFarmaceutico(Farmaceutico dependente){
        if(dependente.getId() == null || dependente.getId().equals(0)){
            cadastrarFarmaceutico(dependente);
        }
        farmaceuticoRepository.save(dependente);
    }

    public void excluirFarmaceutico(String crfFarmaceutico){
        Farmaceutico p = farmaceuticoRepository.findByCrf(crfFarmaceutico);
        farmaceuticoRepository.delete(p);
    }

    public Farmaceutico findByCrf(String crfFarmaceutico){
        return farmaceuticoRepository.findByCrf(crfFarmaceutico);
    }

    public List<Farmaceutico> findAllFarmaceutico(){
        return farmaceuticoRepository.findAll();
    }


   
}

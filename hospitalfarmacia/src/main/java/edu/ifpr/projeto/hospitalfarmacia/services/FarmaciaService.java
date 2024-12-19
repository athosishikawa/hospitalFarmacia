package edu.ifpr.projeto.hospitalfarmacia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ifpr.projeto.hospitalfarmacia.model.Farmacia;
import edu.ifpr.projeto.hospitalfarmacia.repository.FarmaciaRepository;

@Service
public class FarmaciaService {
     
    @Autowired
    private FarmaciaRepository farmaciaRepository;

    public void cadastrarFarmacia(Farmacia farmacia){
        if(farmacia.getCnpj() == null || farmacia.getCnpj().isEmpty()){
            return;
        }
        farmaciaRepository.save(farmacia);
    }

    public void alterarFarmacia(Farmacia farmacia){
        if(farmacia.getId() == null || farmacia.getId().equals(0)){
            cadastrarFarmacia(farmacia);
        }
        farmaciaRepository.save(farmacia);
    }

    public void excluirFarmacia(String cnpjFarmacia){
        Farmacia p = farmaciaRepository.findByCnpj(cnpjFarmacia);
        farmaciaRepository.delete(p);
    }

    public Farmacia findById(String idFarmacia){
        return farmaciaRepository.findByCnpj(idFarmacia);
    }

    public List<Farmacia> findAllFarmacia(){
        return farmaciaRepository.findAll();
    }


   
}

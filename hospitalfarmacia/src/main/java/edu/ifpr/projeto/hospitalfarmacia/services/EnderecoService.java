package edu.ifpr.projeto.hospitalfarmacia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ifpr.projeto.hospitalfarmacia.model.Endereco;
import edu.ifpr.projeto.hospitalfarmacia.repository.EnderecoRepository;

@Service
public class EnderecoService {
    
    @Autowired
    private EnderecoRepository enderecoRepository;

    public void salvarEndereco(Endereco endereco){
        if(endereco.getCep() == null || endereco.getCep().isEmpty()){
            return;
        }

        enderecoRepository.save(endereco);
    }

    public void excluirEndereco(int idEndereco){
        Endereco endereco = enderecoRepository.findById(idEndereco).get();

        if(endereco != null){
            return; //implementar essa parte
        }

        enderecoRepository.delete(endereco);
    }

    //SELECT e FROM Endereco 
    public List<Endereco> listAll(){
        return enderecoRepository.findAll();
    }

    // SELECT * FROM endereco_tb
    // WHERE id = :idEndereco

    public Endereco findById(int IdEndereco){
        return enderecoRepository.findById(IdEndereco).get();
    }

    public List<Endereco> findByEstado(String estado){
        return enderecoRepository.findByEstado(estado);
    }

}

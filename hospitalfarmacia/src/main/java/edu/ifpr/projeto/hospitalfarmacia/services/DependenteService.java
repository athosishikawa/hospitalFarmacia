package edu.ifpr.projeto.hospitalfarmacia.services;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ifpr.projeto.hospitalfarmacia.model.Dependente;
import edu.ifpr.projeto.hospitalfarmacia.model.Endereco;
import edu.ifpr.projeto.hospitalfarmacia.model.Pessoa;
import edu.ifpr.projeto.hospitalfarmacia.repository.PessoaRepository;
import edu.ifpr.projeto.hospitalfarmacia.repository.DependenteRepository;
import edu.ifpr.projeto.hospitalfarmacia.repository.EnderecoRepository;

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

    public void excluirPessoa(int idDependente){
        Pessoa p = dependenteRepository.findById(idDependente).get();
        dependenteRepository.delete(p);
    }

    public Pessoa findById(int idPessoa){
        return pessoaRepository.findById(idPessoa).get();
    }

    public List<Pessoa> findAllPeople(){
        return pessoaRepository.findAll();
    }

    public Pessoa findByCpf(String cpf){
        return pessoaRepository.findByCpf(cpf);
    }
   
}

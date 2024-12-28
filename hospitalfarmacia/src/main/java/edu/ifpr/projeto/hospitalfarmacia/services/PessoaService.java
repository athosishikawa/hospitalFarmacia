package edu.ifpr.projeto.hospitalfarmacia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ifpr.projeto.hospitalfarmacia.model.Pessoa;
import edu.ifpr.projeto.hospitalfarmacia.repository.PessoaRepository;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa cadastrarPessoa(Pessoa pessoa){
        if(pessoa.getCpf() == null || pessoa.getCpf().isEmpty()){
        }
        pessoaRepository.save(pessoa);
        return pessoa;
    }

    public void alterarPessoa(Pessoa pessoa){
        if(pessoa.getId() == null || pessoa.getId().equals(0)){
            cadastrarPessoa(pessoa);
        }
        pessoaRepository.save(pessoa);
    }

    public void excluirPessoa(int idPessoa){
        Pessoa p = pessoaRepository.findById(idPessoa).get();
        pessoaRepository.delete(p);
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

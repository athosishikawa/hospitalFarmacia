package edu.ifpr.projeto.hospitalfarmacia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ifpr.projeto.hospitalfarmacia.model.Dispensacao;
import edu.ifpr.projeto.hospitalfarmacia.repository.DispensacaoRepository;

@Service
public class DispensacaoService {

    @Autowired
    private DispensacaoRepository dispensacaoRepository;

    public void cadastrarDispensacao(Dispensacao dispensacao){
        if(dispensacao.getId() == null){
            return;
        }
        dispensacaoRepository.save(dispensacao);
    }

    public void alterarReceita(Dispensacao dispensacao){
        if(dispensacao.getId() == null || dispensacao.getId().equals(0)){
            cadastrarDispensacao(dispensacao);
        }
        dispensacaoRepository.save(dispensacao);
    }

    public void excluirUser(int idDispensacao){
        Dispensacao p = dispensacaoRepository.findById(idDispensacao);
        dispensacaoRepository.delete(p);
    }

    public Dispensacao findById(int idDispensacao){
        return dispensacaoRepository.findById(idDispensacao);
    }

    public List<Dispensacao> findAllDispensacao(){
        return dispensacaoRepository.findAll();
    }


}

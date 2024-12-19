package edu.ifpr.projeto.hospitalfarmacia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ifpr.projeto.hospitalfarmacia.model.Medico;
import edu.ifpr.projeto.hospitalfarmacia.repository.MedicoRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public void cadastrarMedico(Medico medico){
        if(medico.getCrm() == null || medico.getCrm().isEmpty()){
            return;
        }
        medicoRepository.save(medico);
    }

    public void alterarMedico(Medico medico){
        if(medico.getId() == null || medico.getId().equals(0)){
            cadastrarMedico(medico);
        }
        medicoRepository.save(medico);
    }

    public void excluirMedico(int idMedico){
        Medico p = medicoRepository.findById(idMedico).get();
        medicoRepository.delete(p);
    }

    public Medico findById(int idMedico){
        return medicoRepository.findById(idMedico).get();
    }

    public List<Medico> findAllMedicos(){
        return medicoRepository.findAll();
    }

    public Medico findByCrm(String crm){
        return medicoRepository.findByCrm(crm);
    }

}
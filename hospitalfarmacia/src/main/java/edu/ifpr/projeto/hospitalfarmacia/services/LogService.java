package edu.ifpr.projeto.hospitalfarmacia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ifpr.projeto.hospitalfarmacia.model.Log;
import edu.ifpr.projeto.hospitalfarmacia.repository.LogRepository;

@Service
public class LogService {

    @Autowired
    private LogRepository logRepository;

    public void cadatrarLog(Log log){
        if(log.getId() == null){
            return;
        }
        logRepository.save(log);
    }

    public void alterarLog(Log log){
        if(log.getId() == null || log.getId().equals(0)){
            cadatrarLog(log);
        }
        logRepository.save(log);
    }

    public void excluirLog(int idLog){
        Log p = logRepository.findById(idLog);
        logRepository.delete(p);
    }

    public Log findById(int idLog){
        return logRepository.findById(idLog);
    }

    public List<Log> findAllReceita(){
        return logRepository.findAll();
    }


}

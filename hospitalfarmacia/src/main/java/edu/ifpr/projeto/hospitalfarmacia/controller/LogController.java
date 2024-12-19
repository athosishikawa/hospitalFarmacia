package edu.ifpr.projeto.hospitalfarmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.ifpr.projeto.hospitalfarmacia.model.Log;
import edu.ifpr.projeto.hospitalfarmacia.services.LogService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/log")
public class LogController {
           
    @Autowired
    private LogService logService;

    public LogController(LogService logService){
        super();
        this.logService = logService;
    }

    @GetMapping("/listarLogs")
    public List<Log> listarLogs(){
        return logService.findAllLog();
    }

    @PostMapping("/cadastrarLog")
    public boolean cadastrarLog(@RequestBody Log log){
        try {
            logService.cadastrarLog(log);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @GetMapping("/findLog")
    public ResponseEntity<Log> buscarLog(@RequestParam("id") int id ){
        return new ResponseEntity<Log>(logService.findById(id), HttpStatus.OK);
    }

}
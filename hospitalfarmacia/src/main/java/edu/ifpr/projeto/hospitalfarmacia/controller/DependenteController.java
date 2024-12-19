package edu.ifpr.projeto.hospitalfarmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.ifpr.projeto.hospitalfarmacia.model.Dependente;
import edu.ifpr.projeto.hospitalfarmacia.services.DependenteService;

@RestController
@RequestMapping("/dependente")
public class DependenteController {
           
    @Autowired
    private DependenteService dependenteService;

    public DependenteController(DependenteService dependenteService){
        super();
        this.dependenteService = dependenteService;
    }

    @GetMapping("/listarDependentes")
    public List<Dependente> listarDependentes(){
        return dependenteService.findAllDependente();
    }

    @PostMapping("/cadastrarDependente")
    public boolean cadastrarPessoa(@RequestBody Dependente dependente){
        try {
            dependenteService.cadastrarDependente(dependente);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @GetMapping("/findDependente")
    public ResponseEntity<Dependente> buscarDependente(@RequestParam("idDependente") int idDependente ){
        return new ResponseEntity<Dependente>(dependenteService.findById(idDependente), HttpStatus.OK);
    }
}

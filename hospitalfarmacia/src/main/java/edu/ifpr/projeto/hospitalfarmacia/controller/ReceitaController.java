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

import edu.ifpr.projeto.hospitalfarmacia.model.Receita;
import edu.ifpr.projeto.hospitalfarmacia.services.ReceitaService;
// import io.swagger.v3.oas.annotations.parameters.RequestBody;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/receita")
public class ReceitaController {
           
    @Autowired
    private ReceitaService receitaService;

    public ReceitaController(ReceitaService receitaService){
        super();
        this.receitaService = receitaService;
    }

    @GetMapping("/listarReceitas")
    public List<Receita> listarPlanos(){
        return receitaService.findAllReceita();
    }

    @PostMapping("/cadastrarReceita")
    public boolean cadastrarReceita(@RequestBody Receita receita){
        try {
            receitaService.cadastrarReceita(receita);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @GetMapping("/findReceita")
    public ResponseEntity<Receita> buscarReceita(@RequestParam("id") int id ){
        return new ResponseEntity<Receita>(receitaService.findById(id), HttpStatus.OK);
    }

}
package edu.ifpr.projeto.hospitalfarmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.ifpr.projeto.hospitalfarmacia.model.Pessoa;
import edu.ifpr.projeto.hospitalfarmacia.services.MedicoService;
import edu.ifpr.projeto.hospitalfarmacia.services.PessoaService;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
       
    @Autowired
    private MedicoService medicoService;

    public MedicoController(MedicoService medicoService){
        super();
        this.medicoService = medicoService;
    }

    @GetMapping("/listarPessoas")
    public List<Pessoa> listarPessoas(){
        return pessoaService.findAllPeople();
    }

    @PostMapping("/cadastrarPessoa")
    public boolean cadastrarPessoa(@RequestBody Pessoa pessoa){
        try {
            pessoaService.cadatrarPessoa(pessoa);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @GetMapping("/findPessoa")
    public ResponseEntity<Pessoa> buscarPessoa(@RequestParam("idPessoa") int idPessoa ){
        return new ResponseEntity<Pessoa>(pessoaService.findById(idPessoa), HttpStatus.OK);
    }
}
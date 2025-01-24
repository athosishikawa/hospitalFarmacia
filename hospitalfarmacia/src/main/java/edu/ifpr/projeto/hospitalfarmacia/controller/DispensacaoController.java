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

import edu.ifpr.projeto.hospitalfarmacia.model.Dispensacao;
import edu.ifpr.projeto.hospitalfarmacia.services.DispensacaoService;
// import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/dispensacao")
public class DispensacaoController {
           
    @Autowired
    private DispensacaoService dispensacaoService;

    public DispensacaoController(DispensacaoService dispensacaoService){
        super();
        this.dispensacaoService = dispensacaoService;
    }

    @GetMapping("/listarDispensacao")
    public List<Dispensacao> listarDispensacao(){
        return dispensacaoService.findAllDispensacao();
    }

    @PostMapping("/cadastrarDispensacao")
    public boolean cadastrarPessoa(@RequestBody Dispensacao dispensacao){
        try {
            dispensacaoService.cadastrarDispensacao(dispensacao);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @GetMapping("/findDispensacao")
    public ResponseEntity<Dispensacao> buscarDependente(@RequestParam("idDispensacao") int idDispensacao ){
        return new ResponseEntity<Dispensacao>(dispensacaoService.findById(idDispensacao), HttpStatus.OK);
    }
}
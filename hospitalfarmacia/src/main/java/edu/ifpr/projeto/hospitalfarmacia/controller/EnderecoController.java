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

import edu.ifpr.projeto.hospitalfarmacia.model.Endereco;
import edu.ifpr.projeto.hospitalfarmacia.services.EnderecoService;
// import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/endereco")
public class EnderecoController {
           
    @Autowired
    private EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService){
        super();
        this.enderecoService = enderecoService;
    }

    @GetMapping("/listarEnderecos")
    public List<Endereco> listarDependentes(){
        return enderecoService.findAllEnderecos();
    }

    @PostMapping("/cadastrarEndereco")
    public boolean cadastrarPessoa(@RequestBody Endereco endereco){
        try {
            enderecoService.cadastrarEndereco(endereco);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @GetMapping("/findEndereco")
    public ResponseEntity<Endereco> buscarDependente(@RequestParam("idEndereco") int idEndereco ){
        return new ResponseEntity<Endereco>(enderecoService.findById(idEndereco), HttpStatus.OK);
    }
}

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

import edu.ifpr.projeto.hospitalfarmacia.model.Plano;
import edu.ifpr.projeto.hospitalfarmacia.services.PlanoService;
// import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/plano")
public class PlanoController {
           
    @Autowired
    private PlanoService planoService;

    public PlanoController(PlanoService planoService){
        super();
        this.planoService = planoService;
    }

    @GetMapping("/listarPlanos")
    public List<Plano> listarPlanos(){
        return planoService.findAllPlanos();
    }

    @PostMapping("/cadastrarPlanos")
    public boolean cadastrarPlano(@RequestBody Plano plano){
        try {
            planoService.cadastrarPlano(plano);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @GetMapping("/findPlano")
    public ResponseEntity<Plano> buscarPlano(@RequestParam("id") int id ){
        return new ResponseEntity<Plano>(planoService.findById(id), HttpStatus.OK);
    }

}
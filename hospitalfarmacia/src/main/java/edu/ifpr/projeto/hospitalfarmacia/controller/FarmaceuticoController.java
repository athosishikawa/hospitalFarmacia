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

import edu.ifpr.projeto.hospitalfarmacia.model.Farmaceutico;
import edu.ifpr.projeto.hospitalfarmacia.services.FarmaceuticoService;
// import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/farmaceutico")
public class FarmaceuticoController {
           
    @Autowired
    private FarmaceuticoService farmaceuticoService;

    public FarmaceuticoController(FarmaceuticoService farmaceuticoService){
        super();
        this.farmaceuticoService = farmaceuticoService;
    }

    @GetMapping("/listarFarmaceutico")
    public List<Farmaceutico> listarFarmaceuticos(){
        return farmaceuticoService.findAllFarmaceutico();
    }

    @PostMapping("/cadastrarFarmaceutico")
    public boolean cadastrarPessoa(@RequestBody Farmaceutico farmaceutico){
        try {
            farmaceuticoService.cadastrarFarmaceutico(farmaceutico);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @GetMapping("/findFarmaceutico")
    public ResponseEntity<Farmaceutico> buscarFarmaceutico(@RequestParam("crf") String crf ){
        return new ResponseEntity<Farmaceutico>(farmaceuticoService.findByCrf(crf), HttpStatus.OK);
    }
}

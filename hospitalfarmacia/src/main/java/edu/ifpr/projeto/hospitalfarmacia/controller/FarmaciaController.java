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

import edu.ifpr.projeto.hospitalfarmacia.model.Farmacia;
import edu.ifpr.projeto.hospitalfarmacia.services.FarmaciaService;
// import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/farmacia")
public class FarmaciaController {
           
    @Autowired
    private FarmaciaService farmaciaService;

    public FarmaciaController(FarmaciaService farmaciaService){
        super();
        this.farmaciaService = farmaciaService;
    }

    @GetMapping("/listarFarmacia")
    public List<Farmacia> listarFarmaceuticos(){
        return farmaciaService.findAllFarmacia();
    }

    @PostMapping("/cadastrarFarmacia")
    public boolean cadastrarPessoa(@RequestBody Farmacia farmacia){
        try {
            farmaciaService.cadastrarFarmacia(farmacia);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @GetMapping("/findFarmacia")
    public ResponseEntity<Farmacia> buscarFarmacia(@RequestParam("cnpj") String cnpj ){
        return new ResponseEntity<Farmacia>(farmaciaService.findById(cnpj), HttpStatus.OK);
    }
}

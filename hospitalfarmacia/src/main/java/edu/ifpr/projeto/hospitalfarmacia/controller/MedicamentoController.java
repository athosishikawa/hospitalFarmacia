package edu.ifpr.projeto.hospitalfarmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.ifpr.projeto.hospitalfarmacia.model.Medicamento;
import edu.ifpr.projeto.hospitalfarmacia.services.MedicamentoService;
// import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController

@RequestMapping("/medicamento")
public class MedicamentoController {
           
    @Autowired
    private MedicamentoService medicamentoService;

    public MedicamentoController(MedicamentoService medicamentoService){
        super();
        this.medicamentoService = medicamentoService;
    }

    @GetMapping("/listarMedicamentos")
    public List<Medicamento> listarMedicamentos(){
        return medicamentoService.findAllMedicamentos();
    }

    @PostMapping("/cadastrarMedicamento")
    public boolean cadastrarMedicamento(@RequestBody Medicamento medicamento){
        try {
            medicamentoService.cadastrarMedicamento(medicamento);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @GetMapping("/findMedicamento")
    public ResponseEntity<Medicamento> buscarMedicamento(@RequestParam("id") int id ){
        return new ResponseEntity<Medicamento>(medicamentoService.findById(id), HttpStatus.OK);
    }

}
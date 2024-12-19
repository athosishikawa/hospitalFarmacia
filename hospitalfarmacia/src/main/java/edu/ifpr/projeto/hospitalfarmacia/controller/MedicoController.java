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

import edu.ifpr.projeto.hospitalfarmacia.model.Medico;
import edu.ifpr.projeto.hospitalfarmacia.services.MedicoService;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
       
    @Autowired
    private MedicoService medicoService;

    public MedicoController(MedicoService medicoService){
        super();
        this.medicoService = medicoService;
    }

    @GetMapping("/listarMedicos")
    public List<Medico> listarPessoas(){
        return medicoService.findAllMedicos();
    }

    @PostMapping("/cadastrarMedico")
    public boolean cadastrarMedico(@RequestBody Medico medico){
        try {
            medicoService.cadastrarMedico(medico);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @GetMapping("/findMedico")
    public ResponseEntity<Medico> buscarMedico(@RequestParam("crm") String crm ){
        return new ResponseEntity<Medico>(medicoService.findByCrm(crm), HttpStatus.OK);
    }
}
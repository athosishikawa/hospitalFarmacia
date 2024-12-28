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

import edu.ifpr.projeto.hospitalfarmacia.model.ItemReceita;
import edu.ifpr.projeto.hospitalfarmacia.services.ItemReceitaService;

@RestController
@RequestMapping("/itemReceita")
public class ItemReceitaController {
           
    @Autowired
    private ItemReceitaService itemReceitaService;

    public ItemReceitaController(ItemReceitaService itemReceitaService){
        super();
        this.itemReceitaService = itemReceitaService;
    }

    @GetMapping("/listarItensReceita")
    public List<ItemReceita> listarItemReceitas(){
        return itemReceitaService.findAllItemReceita();
    }

    @PostMapping("/cadastrarItemReceita")
    public ResponseEntity<ItemReceita> cadastrarItemReceita(@RequestBody ItemReceita itemReceita){
        try {
            ItemReceita itemCriado = itemReceitaService.cadastrarItemReceita(itemReceita);
            return new ResponseEntity<>(itemCriado, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findItemReceita")
    public ResponseEntity<ItemReceita> buscarItemReceita(@RequestParam("id") int id ){
        return new ResponseEntity<ItemReceita>(itemReceitaService.findById(id), HttpStatus.OK);
    }

}
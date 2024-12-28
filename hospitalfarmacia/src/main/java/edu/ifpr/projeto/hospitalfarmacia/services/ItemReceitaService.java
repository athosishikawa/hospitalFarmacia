package edu.ifpr.projeto.hospitalfarmacia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ifpr.projeto.hospitalfarmacia.model.ItemReceita;
import edu.ifpr.projeto.hospitalfarmacia.repository.ItemReceitaRepository;

@Service
public class ItemReceitaService {
     
    @Autowired
    private ItemReceitaRepository itemReceitaRepository;

    public ItemReceita cadastrarItemReceita(ItemReceita itemReceita){
        
        itemReceitaRepository.save(itemReceita);
        return itemReceita;
    }

    public void alterarItemReceita(ItemReceita itemReceita){
        if(itemReceita.getId() == null || itemReceita.getId().equals(0)){
            cadastrarItemReceita(itemReceita);
        }
        itemReceitaRepository.save(itemReceita);
    }

    public void excluirItemReceita(int idItemReceita){
        ItemReceita p = itemReceitaRepository.findById(idItemReceita);
        itemReceitaRepository.delete(p);
    }

    public ItemReceita findById(int idItemReceita){
        return itemReceitaRepository.findById(idItemReceita);
    }

    public List<ItemReceita> findAllItemReceita(){
        return itemReceitaRepository.findAll();
    }


   
}

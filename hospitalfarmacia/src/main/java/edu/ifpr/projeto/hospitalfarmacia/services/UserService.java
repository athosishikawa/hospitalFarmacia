package edu.ifpr.projeto.hospitalfarmacia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ifpr.projeto.hospitalfarmacia.model.User;
import edu.ifpr.projeto.hospitalfarmacia.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void cadatrarUser(User user){
        if(user.getLogin() == null || user.getLogin().isEmpty()){
            return;
        }
        userRepository.save(user);
    }

    public void alterarPessoa(User user){
        if(user.getId() == null || user.getId().equals(0)){
            cadatrarUser(user);
        }
        userRepository.save(user);
    }

    public void excluirUser(int idUser){
        User p = userRepository.findById(idUser).get();
        userRepository.delete(p);
    }

    public User findById(int idUser){
        return userRepository.findById(idUser).get();
    }

    public List<User> findAllUser(){
        return userRepository.findAll();
    }


}

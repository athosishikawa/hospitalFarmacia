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

import edu.ifpr.projeto.hospitalfarmacia.model.User;
import edu.ifpr.projeto.hospitalfarmacia.services.UserService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/user")
public class UserController {
           
    @Autowired
    private UserService userService;

    public UserController(UserService userService){
        super();
        this.userService = userService;
    }

    @GetMapping("/listarUsers")
    public List<User> listarLogs(){
        return userService.findAllUser();
    }

    @PostMapping("/cadastrarUser")
    public boolean cadastrarLog(@RequestBody User user){
        try {
            userService.cadastrarUser(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @GetMapping("/findUser")
    public ResponseEntity<User> buscarUser(@RequestParam("id") int id ){
        return new ResponseEntity<User>(userService.findById(id), HttpStatus.OK);
    }

}
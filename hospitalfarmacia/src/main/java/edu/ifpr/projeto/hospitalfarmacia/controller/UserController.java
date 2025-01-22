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

import edu.ifpr.projeto.hospitalfarmacia.configuration.TokenService;
import edu.ifpr.projeto.hospitalfarmacia.dtos.AuthenticationDTO;
import edu.ifpr.projeto.hospitalfarmacia.dtos.LoginResponse;
import edu.ifpr.projeto.hospitalfarmacia.dtos.RegisterDTO;
import edu.ifpr.projeto.hospitalfarmacia.enums.UserRole;
import edu.ifpr.projeto.hospitalfarmacia.model.User;
import edu.ifpr.projeto.hospitalfarmacia.repository.UserRepository;
import edu.ifpr.projeto.hospitalfarmacia.services.UserService;
// import io.swagger.v3.oas.annotations.parameters.RequestBody;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.annotations.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("auth")
@Tag(name="Auth", description="Controlador para salvar e editar os dados do usuários")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    @Operation(summary="Realiza o Login", description="Método para realizar o login do usuário")
    @ApiResponse(code=200, message="Usuário atenticado com sucesso")
    public ResponseEntity login (@RequestBody AuthenticationDTO authenticationDTO){
        var usernamePassword = new UsernamePasswordAuthenticationToken(authenticationDTO.login(), authenticationDTO.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO registerDTO){
        if(userRepository.findByLogin(registerDTO.login()) != null) {
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(registerDTO.password());
        User user = User.builder()
                  .login(registerDTO.login())
                  .senha(encryptedPassword)
                  .roles(UserRole.valueOf(registerDTO.role()))
                  .build();
        this.userRepository.save(user);

        return ResponseEntity.ok().build();
    }
    
}

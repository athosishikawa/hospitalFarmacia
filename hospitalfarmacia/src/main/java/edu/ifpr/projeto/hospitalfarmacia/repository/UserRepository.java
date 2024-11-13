package edu.ifpr.projeto.hospitalfarmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import edu.ifpr.projeto.hospitalfarmacia.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

    public UserDetails findByLogin(String user);
    
}

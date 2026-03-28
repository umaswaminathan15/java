package com.example.TNTRANSPORT.service;


import com.example.TNTRANSPORT.model.User;
import com.example.TNTRANSPORT.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
     public UserRepository repo;

    @Autowired
    private PasswordEncoder encoder;

    public String registeruser(User user){

        User existing=repo.findByEmail(user.getEmail());

        if(existing!=null){
            return  "email already exits";
        }else{
            user.setPassword(encoder.encode(user.getPassword()));
            repo.save(user);
        }
        return "Register success";
    }

    public String loginUser(User user){

        User exists=repo.findByEmail(user.getEmail());

        if(exists==null){
            return "user not found";
        }
        if (encoder.matches(user.getPassword(), exists.getPassword())) {
            return "login success";
        }
        return "invalid password";

    }
}

package com.danielseab.cruid_cars.controllers;



import com.danielseab.cruid_cars.dto.AuthenticationDTO;
import com.danielseab.cruid_cars.dto.LoginResponseDTO;
import com.danielseab.cruid_cars.dto.RegisterDTO;
import com.danielseab.cruid_cars.infra.entity.users.User;
import com.danielseab.cruid_cars.infra.repository.UserRepository;
import com.danielseab.cruid_cars.services.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
        if(this.userRepository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();

        String encrptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.login(), encrptedPassword, data.role());

        this.userRepository.save(newUser);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}

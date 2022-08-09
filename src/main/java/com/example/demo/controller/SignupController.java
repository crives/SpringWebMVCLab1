package com.example.demo.controller;

import com.example.demo.dto.SignupDTO;
import com.example.demo.model.Signup;
import com.example.demo.service.SignupService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signup")
public class SignupController {

    @Autowired
    SignupService signupService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<SignupDTO> createActivity(@RequestBody SignupDTO signupDto) {

        // convert DTO to entity
        Signup signupRequest = modelMapper.map(signupDto, Signup.class);
        Signup signup = signupService.createSignup(signupRequest);

        // convert entity to DTO
        SignupDTO signupResponse = modelMapper.map(signup, SignupDTO.class);

        return new ResponseEntity<>(signupResponse, HttpStatus.CREATED);
    }
}

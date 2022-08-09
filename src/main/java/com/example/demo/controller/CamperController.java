package com.example.demo.controller;

import com.example.demo.dto.CamperDTO;
import com.example.demo.dto.CreateCamperDTO;
import com.example.demo.model.Camper;
import com.example.demo.service.CamperService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/campers")
public class CamperController {

    @Autowired
    private CamperService camperService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<CamperDTO> createCamper(@Valid @RequestBody CreateCamperDTO createCamperDto) {

        // convert DTO to entity
        Camper camperRequest = modelMapper.map(createCamperDto, Camper.class);
        Camper camper = camperService.createCamper(camperRequest);

        // convert entity to DTO
        CamperDTO camperResponse = modelMapper.map(camper, CamperDTO.class);

        return new ResponseEntity<>(camperResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public List<CamperDTO> getAllCampers() {

        return camperService.getAllCampers()
                .stream()
                .map(camper -> modelMapper.map(camper, CamperDTO.class))
                .collect(Collectors.toList());
    }
}

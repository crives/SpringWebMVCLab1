package com.example.demo.controller;

import com.example.demo.dto.ActivityDTO;
import com.example.demo.dto.CamperDTO;
import com.example.demo.model.Activity;
import com.example.demo.model.Camper;
import com.example.demo.service.ActivityService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    ActivityService activityService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<ActivityDTO> createActivity(@RequestBody ActivityDTO activityDto) {

        // convert DTO to entity
        Activity activityRequest = modelMapper.map(activityDto, Activity.class);
        Activity activity = activityService.createActivity(activityRequest);

        // convert entity to DTO
        ActivityDTO activityResponse = modelMapper.map(activity, ActivityDTO.class);

        return new ResponseEntity<>(activityResponse, HttpStatus.CREATED);
    }
}

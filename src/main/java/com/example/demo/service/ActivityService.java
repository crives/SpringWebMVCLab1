package com.example.demo.service;

import com.example.demo.model.Activity;
import com.example.demo.repository.ActivityRepository;
import com.example.demo.repository.SignupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {

//    @Autowired
//    private SignupRepository signupRepository;

    @Autowired
    private ActivityRepository activityRepository;

    public Activity createActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    public List<Activity> getAllActivites() {
        return activityRepository.findAll();
    }

    public void deleteActivity(Long id) throws Exception {
        Activity activity = activityRepository.findById(id)
                .orElseThrow(() -> new Exception("Activity not found"));

        activityRepository.delete(activity);
    }
}

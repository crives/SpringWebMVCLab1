package com.example.demo.service;

import com.example.demo.model.Signup;
import com.example.demo.repository.ActivityRepository;
import com.example.demo.repository.CamperRepository;
import com.example.demo.repository.SignupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignupService {

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private CamperRepository camperRepository;

    @Autowired
    private SignupRepository signupRepository;

    public Signup createSignup(Signup signup) {
        return signupRepository.save(signup);
    }

    public List<Signup> getAllSignups() {
        return signupRepository.findAll();
    }

    public void deleteSignup(Long id) throws Exception {
        Signup signup = signupRepository.findById(id)
                .orElseThrow(() -> new Exception("Signup not found"));

        signupRepository.delete(signup);
    }
}
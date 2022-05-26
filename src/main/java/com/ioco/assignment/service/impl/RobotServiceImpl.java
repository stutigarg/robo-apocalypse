package com.ioco.assignment.service.impl;

import com.ioco.assignment.model.RobotModel;
import com.ioco.assignment.service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class RobotServiceImpl implements RobotService {

    private static final String SERVICE_URL = "https://robotstakeover20210903110417.azurewebsites.net/robotcpu";

    @Autowired
    RestTemplate restTemplate;


    @Override
    @Cacheable(value = "robot_cache")
    public List<RobotModel> getRobots() {
        List<RobotModel> robotModels = restTemplate.getForObject(SERVICE_URL, ArrayList.class);
        return robotModels;
    }
}

package com.ioco.assignment.controller;

import com.ioco.assignment.model.RobotModel;
import com.ioco.assignment.service.RobotService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/robot")
public class RobotController {


    @Autowired
    RobotService robotService;

    @GetMapping
    @ApiOperation("API to get robots")
    public ResponseEntity<List<RobotModel>> getRobots() {
        List<RobotModel> response = robotService.getRobots();
        if (response.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(response);
    }
}
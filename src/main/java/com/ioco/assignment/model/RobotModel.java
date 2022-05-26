package com.ioco.assignment.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@lombok.Getter
@lombok.Setter
public class RobotModel {

    private String model;
    private String serialNumber;
    private LocalDate manufacturedDate;
    private String category;

}

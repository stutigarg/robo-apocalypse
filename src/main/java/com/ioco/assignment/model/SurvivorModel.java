package com.ioco.assignment.model;

import com.ioco.assignment.domain.Resource;
import com.ioco.assignment.domain.Survivor;

import java.io.Serializable;
import java.util.List;

@lombok.Getter
@lombok.Setter
public class SurvivorModel implements Serializable {
    private Long id;
    private String name;
    private int age;
    private Survivor.Gender gender;
    private LocationModel location;

    private List<ResourceModel> resources;

}

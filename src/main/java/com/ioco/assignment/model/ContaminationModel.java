package com.ioco.assignment.model;

import javax.validation.constraints.Positive;

@lombok.Getter
@lombok.Setter
public class ContaminationModel {

    @Positive
    private long suspectId;
    @Positive
    private long reporterId;
}

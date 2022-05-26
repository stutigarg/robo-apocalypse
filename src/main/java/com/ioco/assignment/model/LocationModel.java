package com.ioco.assignment.model;

import java.io.Serializable;

@lombok.Getter
@lombok.Setter
public class LocationModel implements Serializable {

    public static final long serialVersionUID = -4635160252891701074L;
    private Double latitude;
    private Double longitude;
}

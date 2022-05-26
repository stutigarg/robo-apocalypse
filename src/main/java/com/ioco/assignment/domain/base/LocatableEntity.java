package com.ioco.assignment.domain.base;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;

@lombok.Getter
@lombok.Setter
@MappedSuperclass
public class LocatableEntity implements Serializable {

    private static final long serialVersionUID = -1590646033450634786L;

    @NotNull
    private Double latitude;

    @NotNull
    private Double longitude;
}

package com.ioco.assignment.service;

import com.ioco.assignment.domain.Survivor;
import com.ioco.assignment.model.LocationModel;
import com.ioco.assignment.model.SurvivorModel;

public interface SurvivorService {

    Survivor saveSurvivor(SurvivorModel request);

    boolean updateLocation(long survivorId, LocationModel location);
}

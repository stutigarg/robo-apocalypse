package com.ioco.assignment.service.impl;

import com.ioco.assignment.domain.Survivor;
import com.ioco.assignment.model.LocationModel;
import com.ioco.assignment.model.SurvivorModel;
import com.ioco.assignment.repository.SurvivorRepository;
import com.ioco.assignment.service.SurvivorService;
import com.ioco.assignment.service.mapper.SurvivorMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class SurvivorServiceImpl implements SurvivorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SurvivorServiceImpl.class);
    @Autowired
    private SurvivorRepository survivorRepository;

    @Autowired
    private SurvivorMapper survivorMapper;

    @Override
    @Transactional
    public Survivor saveSurvivor(SurvivorModel request) {
        Survivor survivor = survivorRepository.save(SurvivorMapper.map(request));
        LOGGER.info("Congratulations! We've a new survivor: {}", survivor.getId());
        return survivor;
    }

    @Override
    public boolean updateLocation(long survivorId, LocationModel location) {
        int countRecordsUpdated = survivorRepository.updateLocation(survivorId, location.getLatitude(), location.getLongitude());
        boolean isMoved = countRecordsUpdated == 1;
        LOGGER.debug("Movement detected. Survivor: {}, Result: {}", survivorId, isMoved);
        return isMoved;
    }
}

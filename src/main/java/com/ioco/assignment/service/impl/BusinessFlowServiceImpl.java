package com.ioco.assignment.service.impl;

import com.ioco.assignment.config.ApocalypseConfiguration;
import com.ioco.assignment.domain.Survivor;
import com.ioco.assignment.domain.Zombie;
import com.ioco.assignment.model.ContaminationModel;
import com.ioco.assignment.repository.SurvivorRepository;
import com.ioco.assignment.repository.ZombieRepository;
import com.ioco.assignment.service.BusinessFlowService;
import com.ioco.assignment.service.mapper.SurvivorMapper;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class BusinessFlowServiceImpl implements BusinessFlowService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BusinessFlowServiceImpl.class);

    @Autowired
    private SurvivorRepository survivorRepository;
    @Autowired
    private ZombieRepository zombieRepository;
    @Autowired
    private ApocalypseConfiguration config;

    /**
     * Things we do inside
     * 1. Fetch the suspected survivor details
     * 2. Check his/her suspicious index
     * 3. A. Either update the survivor state for the extra contamination, or
     *    B. We lost the survivor, and a zombie is born
     *
     * @param contaminationReport
     */
    @Override
    @Transactional
    public void processContaminationReport(ContaminationModel contaminationReport) {
        LOGGER.debug("Received contamination request. Suspect: {}, Reporter: {}",
                contaminationReport.getSuspectId(), contaminationReport.getReporterId());

        // The repo API returns an Optional
        Survivor suspect = survivorRepository.findById(contaminationReport.getSuspectId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid suspect id"));
        int countContaminated = suspect.getContaminated().size();
        boolean lostSurvivor = countContaminated >= config.getContaminationThreshold();

        Survivor contaminated = new Survivor();
        contaminated.setId(contaminationReport.getReporterId());
        suspect.getContaminated().add(contaminated);

        suspect.setIsDeleted(lostSurvivor);
        survivorRepository.save(suspect);
        if (lostSurvivor) {
            moronSurvivor(suspect);
        }
    }

    private Zombie moronSurvivor(Survivor lostSurvivor) {
        Zombie zombie = SurvivorMapper.mapAsZombie(lostSurvivor);
        return zombieRepository.save(zombie);
    }
}

package com.ioco.assignment.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.Positive;

@ConfigurationProperties(prefix = "drogon-client")
@lombok.Getter
@lombok.Setter
public class ApocalypseConfiguration {

    @Positive
    private int contaminationThreshold;
}

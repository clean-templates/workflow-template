package com.workflow.cadence.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CadenceProperties {

    @Value("${cadence.domain}")
    private String domain;

    @Value("${cadence.host}")
    private String host;

    @Value("${cadence.port}")
    private String port;


    public String getDomain() {
        return domain;
    }

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }
}

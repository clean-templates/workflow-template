package com.workflow.cadence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class CadenceWorkflowApplication {

    public static void main(String[] args) {
        SpringApplication.run(CadenceWorkflowApplication.class, args);
    }

}

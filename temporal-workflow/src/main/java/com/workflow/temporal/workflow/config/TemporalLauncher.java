package com.workflow.temporal.workflow.config;

import io.temporal.worker.WorkerFactory;
import jakarta.annotation.PreDestroy;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TemporalLauncher implements CommandLineRunner {

    private final WorkerFactory workerFactory;

    @Override
    public void run(String... args) throws Exception {
        workerFactory.start();

    }
    @PreDestroy
    public void shutdown(){
        workerFactory.shutdownNow();
    }

}



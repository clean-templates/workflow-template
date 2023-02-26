package com.workflow.cadence.config;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.uber.cadence.worker.WorkerFactory;

@Component
@AllArgsConstructor
public class CadenceLauncher implements CommandLineRunner {

    private final WorkerFactory workerFactory;

    @Override
    public void run(String... args) throws Exception {
        workerFactory.start();

    }

}

package com.workflow.temporal.workflow.config;

import com.workflow.temporal.workflow.core.application.workflow.main.IOrderActivity;
import com.workflow.temporal.workflow.core.application.workflow.main.OrderWorkflow;
import com.workflow.temporal.workflow.core.application.workflow.prepare.PrepareWorkflow;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class WorkerConfiguration {

    public static final String ORDER_TASK_LIST = "ORDER_TASK_LIST";
    public static final String PREPARE_TASK_LIST = "PREPARE_TASK_LIST";
    private IOrderActivity orderActivity;
    private WorkerFactory factory;


    @PostConstruct
    public void managementWorker() {
        Worker orderWorker = factory.newWorker(ORDER_TASK_LIST);
        Worker prepareWorker = factory.newWorker(PREPARE_TASK_LIST);

        orderWorker.registerWorkflowImplementationTypes(OrderWorkflow.class);
        prepareWorker.registerWorkflowImplementationTypes(PrepareWorkflow.class);

        orderWorker.registerActivitiesImplementations(orderActivity);
        factory.start();
    }

    @PreDestroy
    public void shutdown(){
        factory.shutdown();
    }
}


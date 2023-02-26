package com.workflow.cadence.config;

import com.uber.cadence.client.WorkflowClient;
import com.uber.cadence.worker.Worker;
import com.uber.cadence.worker.WorkerFactory;
import com.uber.cadence.worker.WorkerFactoryOptions;
import com.workflow.cadence.core.application.workflow.main.IOrderActivity;
import com.workflow.cadence.core.application.workflow.main.OrderWorkflow;
import com.workflow.cadence.core.application.workflow.prepare.PrepareWorkflow;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class WorkerConfiguration {

    public static final String ORDER_TASK_LIST = "ORDER_TASK_LIST";
    public static final String PREPARE_TASK_LIST = "PREPARE_TASK_LIST";
    private IOrderActivity orderActivity;

    @Bean
    public WorkerFactoryOptions workerFactoryOptions() {
        return WorkerFactoryOptions.newBuilder().build();
    }

    @Bean
    public WorkerFactory workerFactory(WorkflowClient workflowClient, WorkerFactoryOptions workerFactoryOptions) {
        return WorkerFactory.newInstance(workflowClient, workerFactoryOptions);
    }


    @Bean
    public WorkerFactory managementWorker(WorkerFactory factory) {
        Worker orderWorker = factory.newWorker(ORDER_TASK_LIST);
        Worker prepareWorker = factory.newWorker(PREPARE_TASK_LIST);

        orderWorker.registerWorkflowImplementationTypes(OrderWorkflow.class);
        prepareWorker.registerWorkflowImplementationTypes(PrepareWorkflow.class);

        orderWorker.registerActivitiesImplementations(orderActivity);
        return factory;
    }

}

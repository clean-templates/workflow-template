package com.workflow.temporal.workflow.config;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowClientOptions;
import io.temporal.common.converter.DefaultDataConverter;
import io.temporal.common.converter.JacksonJsonPayloadConverter;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.serviceclient.WorkflowServiceStubsOptions;
import io.temporal.worker.WorkerFactory;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class TemporalLauncher {

    @Value("${temporal.url}")
    private String url;


    @Bean
    public ObjectMapper getObjectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public WorkflowClientOptions workflowClientOptions(ObjectMapper objectMapper) {
        return WorkflowClientOptions.newBuilder()
                .setNamespace("test-namespace")
                .setDataConverter(DefaultDataConverter
                        .newDefaultInstance()
                        .withPayloadConverterOverrides(new JacksonJsonPayloadConverter(objectMapper))              )
                .build();
    }

    @Bean
    public WorkflowServiceStubs workflowServiceStubs() {
        return WorkflowServiceStubs.newServiceStubs(
                WorkflowServiceStubsOptions.newBuilder()
                        .setTarget(url)
                        .build());


    }

    @Bean
    public WorkflowClient workflowClient(WorkflowServiceStubs temporalWorkflowService, WorkflowClientOptions workflowClientOptions) {
        return WorkflowClient.newInstance(temporalWorkflowService, workflowClientOptions);
    }



    @Bean
    public WorkerFactory workerFactory(WorkflowClient client) {
        return WorkerFactory.newInstance(client);

    }

}



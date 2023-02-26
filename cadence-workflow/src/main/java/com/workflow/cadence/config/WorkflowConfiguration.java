package com.workflow.cadence.config;

import com.uber.cadence.client.WorkflowClient;
import com.uber.cadence.client.WorkflowClientOptions;
import com.uber.cadence.serviceclient.ClientOptions;
import com.uber.cadence.serviceclient.IWorkflowService;
import com.uber.cadence.serviceclient.WorkflowServiceTChannel;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class WorkflowConfiguration {
    private CadenceProperties cadenceProperties;

    @Bean
    public WorkflowClientOptions workflowClientOptions() {
        return WorkflowClientOptions.newBuilder()
                .setDomain(cadenceProperties.getDomain())
                .build();
    }

    @Bean
    public ClientOptions clientOptions(){
        return ClientOptions.newBuilder()
                .setHost(cadenceProperties.getHost())
                .setPort(Integer.parseInt(cadenceProperties.getPort()))
                .build();
    }

    @Bean
    public IWorkflowService getService(ClientOptions clientOptions) {
        return new WorkflowServiceTChannel(clientOptions);
    }


    @Bean
    public WorkflowClient workflowClient(IWorkflowService workflowService, WorkflowClientOptions workflowClientOptions) {
        return WorkflowClient.newInstance(workflowService, workflowClientOptions);
    }

}
